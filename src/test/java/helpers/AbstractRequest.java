package helpers;

import com.google.gson.Gson;
import config.Configurations;
import dataProviders.UserInfoProvider;
import enums.ApiV1;
import enums.User;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import models.requests.login.AuthInfo;
import models.responses.userLogin.SuccessLogin;

import static io.restassured.RestAssured.given;

public abstract class AbstractRequest {
    Gson gson = new Gson();

    protected static RequestSpecification baseAuthorizedRequest() {
        return given()
                .baseUri(Configurations.DEV_URL)
                .header(new Header("Authorization", "Bearer " + getToken()))
                .when()
                .contentType(ContentType.JSON);
    }

    public static String getToken() {
        Gson gson = new Gson();
        AuthInfo authInfo = UserInfoProvider.getUser(User.EMAIL_INFO);
        SuccessLogin login = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(authInfo))
                .post(Configurations.DEV_URL + ApiV1.REGISTER.getApi())
                .then()
                .extract().as(SuccessLogin.class);
        return login.getData().getToken();
    }
}
