package apiTests;

import com.google.gson.Gson;
import helpers.AbstractRequest;
import helpers.RequestAuthorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.responses.userLogin.SuccessLogin;
import specification.RequestSpec;
import specification.ResponseSpec;
import dataProviders.UserInfoProvider;
import enums.ApiV1;
import enums.User;

import static io.restassured.RestAssured.given;

public class AuthTest extends AbstractRequest {
    Gson gson = new Gson();
    RequestAuthorization requestAuthorization = new RequestAuthorization();

    @Test
    @DisplayName("Check success user login")
    public void successLoginTest() {
        RequestSpec.installSpecification(RequestSpec.requestSpec(ApiV1.LOGIN.getApi()), ResponseSpec.responseOK200());

        SuccessLogin successLogin = requestAuthorization.requestPostAuth(ApiV1.REGISTER.getApi());
        Assertions.assertEquals("success", successLogin.getResult());
        Assertions.assertEquals("info@local.express", successLogin.getData().getUserEmail());
        Assertions.assertEquals("13546", successLogin.getData().getUserId());
        Assertions.assertTrue(successLogin.getError().isEmpty());
        Assertions.assertNotNull(successLogin.getData().getToken());
    }

    @Test
    @DisplayName("Check success user login with email")
    public void successLoginEmailTest() {
        RequestSpec.installSpecification(RequestSpec.requestSpec(ApiV1.LOGIN.getApi()), ResponseSpec.responseOK200());

        SuccessLogin successLoginEmail = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(UserInfoProvider.getUserClient(User.EMAIL_CLIENT)))
                .post(ApiV1.STAGE.getApi() + ApiV1.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertEquals("success", successLoginEmail.getResult());
        Assertions.assertEquals("oqsannas+31102022@localexpress.io", successLoginEmail.getData().getUserEmail());
        Assertions.assertEquals("65436", successLoginEmail.getData().getUserId());
        Assertions.assertTrue(successLoginEmail.getError().isEmpty());
        Assertions.assertNotNull(successLoginEmail.getData().getToken());
    }
}
