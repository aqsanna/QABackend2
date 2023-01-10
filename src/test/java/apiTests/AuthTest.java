package apiTests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.userLogin.SuccessLogin;
import specification.RequestSpec;
import specification.ResponseSpec;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.User;

import static io.restassured.RestAssured.given;

public class AuthTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check success user login")
    public void successLoginTest() {
        RequestSpec.installSpecification(RequestSpec.requestSpec(ApiV1.LOGIN.getApi()), ResponseSpec.responseOK200());

        SuccessLogin successLogin = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(UserInfoProvider.getUser(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

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
