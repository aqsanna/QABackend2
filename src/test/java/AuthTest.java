import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.AuthInfo;
import responses.SuccessLogin;
import spec.Specifications;
import storage.APIV2;
import storage.USER;

import static io.restassured.RestAssured.given;

public class AuthTest {
    @Test
    @DisplayName("Check success user login")
    public void successLoginTest() {
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());
        Gson gson = new Gson();

        AuthInfo authInfo = new AuthInfo(
                new AuthInfo.Params(
                        new AuthInfo.Params.App()
                                .withBundleId(USER.BUNDLE_ID.getUserData())
                                .withVersion(USER.APP_VERSION.getUserData())
                        , USER.EMAIL.getUserData()
                        , USER.PASSWORD.getUserData(),
                        new AuthInfo.Params.Device()
                                .withVersion(USER.DEVICE_VERSION.getUserData())
                                .withOs(USER.OS.getUserData())
                                .withPushToken(USER.PUSH_TOKEN.getUserData()),
                        USER.APPLICATION_KEY.getUserData()));

        SuccessLogin successLogin = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(authInfo))
                .post(APIV2.STAGE.getApi() + APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertEquals("success", successLogin.getResult());
        Assertions.assertEquals("info@local.express", successLogin.getData().getUserEmail());
        Assertions.assertEquals("13546", successLogin.getData().getUserId());
        Assertions.assertTrue(successLogin.getError().isEmpty());
        Assertions.assertNotNull(successLogin.getData().getToken());
    }
}
