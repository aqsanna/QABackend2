package helpers;

import com.google.gson.Gson;
import config.Configurations;
import dataProviders.UserInfoProvider;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class AbstractRequest {
    Gson gson = new Gson();

    protected static RequestSpecification baseAuthorizedRequest() {
        return given()
                .baseUri(Configurations.DEV_URL)
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON);
    }
}
