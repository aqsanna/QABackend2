package steps.data.users;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import requests.AuthInfo;
import responses.userLogin.SuccessLogin;
import storage.APIV1;
import storage.USER;

import static io.restassured.RestAssured.given;
import static storage.USER.PUSH_TOKEN;

public class UserInfoProvider {
    public static AuthInfo getUser(USER email) {
        return switch (email) {
            case EMAIL_INFO -> new AuthInfo(
                    new AuthInfo.Params(
                            new AuthInfo.Params.App()
                                    .withBundleId(USER.BUNDLE_ID.getUserData())
                                    .withVersion(USER.APP_VERSION.getUserData())
                            , USER.EMAIL_INFO.getUserData()
                            , USER.PASSWORD.getUserData(),
                            new AuthInfo.Params.Device()
                                    .withVersion(USER.DEVICE_VERSION.getUserData())
                                    .withOs(USER.OS.getUserData())
                                    .withPushToken(PUSH_TOKEN.getUserData()),
                            USER.APPLICATION_KEY.getUserData()));

            default -> null;
        };
    }

    public static AuthInfo getUserClient(USER email) {
        return switch (email) {
            case EMAIL_CLIENT -> new AuthInfo(
                    new AuthInfo.Params(
                            new AuthInfo.Params.App()
                                    .withBundleId(USER.BUNDLE_ID.getUserData())
                                    .withVersion(USER.APP_VERSION.getUserData())
                            , USER.EMAIL_CLIENT.getUserData()
                            , USER.PASSWORD_CLIENT.getUserData(),
                            new AuthInfo.Params.Device()
                                    .withVersion(USER.DEVICE_VERSION.getUserData())
                                    .withOs(USER.OS.getUserData())
                                    .withPushToken(PUSH_TOKEN.getUserData()),
                            USER.APPLICATION_CLIENT.getUserData()));

            default -> null;
        };
    }

    public static String getToken() {
        Gson gson = new Gson();

        AuthInfo authInfo = UserInfoProvider.getUser(USER.EMAIL_INFO);

        SuccessLogin login = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(authInfo))
                .post(APIV1.STAGE.getApi() + APIV1.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);
        return login.getData().getToken();
    }

    public static boolean isNumber(String id) {
        return id.matches("[0-9]+") && id.length() > 0;
    }
}
