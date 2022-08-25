import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.AuthInfo;
import requests.App;
import requests.Device;
import responses.SuccessLogin;
import spec.Specifications;
import storage.APIV2;
import storage.USER;

import static io.restassured.RestAssured.given;

public class AuthTest {
    @Test
    @DisplayName("Check success user login")
    public void authorize() {
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());

        App app = new App(
                USER.BUNDLE_ID.getUserData(),
                USER.APP_VERSION.getUserData()
        );
        Device device = new Device(
                USER.DEVICE_VERSION.getUserData(),
                USER.OS.getUserData(),
                USER.PUSH_TOKEN.getUserData()
        );


        AuthInfo user = new AuthInfo(
                app,
                USER.EMAIL.getUserData(),
                USER.PASSWORD.getUserData(),
                device,
                USER.APPLICATION_KEY.getUserData());

        SuccessLogin successLogin = given()
                .body(user)
                .when()
                .post(APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertEquals(user.getEmail(), successLogin.getUserEmail());
    }
}
