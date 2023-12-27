package dataProviders;

import com.google.gson.Gson;
import config.Configurations;
import io.restassured.http.ContentType;
import models.requests.login.AuthInfo;
import models.responses.userLogin.SuccessLogin;
import enums.ApiV1;
import enums.User;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static enums.User.PUSH_TOKEN;

public class UserInfoProvider {
    public static AuthInfo getUser(User email) {
        return switch (email) {
            case EMAIL_INFO -> new AuthInfo(
                    new AuthInfo.Params(
                            new AuthInfo.Params.App()
                                    .withBundleId(User.BUNDLE_ID.getUserData())
                                    .withVersion(User.APP_VERSION.getUserData())
                            , User.EMAIL_INFO.getUserData()
                            , User.PASSWORD.getUserData(),
                            new AuthInfo.Params.Device()
                                    .withVersion(User.DEVICE_VERSION.getUserData())
                                    .withOs(User.OS.getUserData())
                                    .withPushToken(PUSH_TOKEN.getUserData()),
                            User.APPLICATION_KEY.getUserData()));

            default -> null;
        };
    }

    public static AuthInfo getUserClient(User email) {
        return switch (email) {
            case EMAIL_CLIENT -> new AuthInfo(
                    new AuthInfo.Params(
                            new AuthInfo.Params.App()
                                    .withBundleId(User.BUNDLE_ID.getUserData())
                                    .withVersion(User.APP_VERSION.getUserData())
                            , User.EMAIL_CLIENT.getUserData()
                            , User.PASSWORD_CLIENT.getUserData(),
                            new AuthInfo.Params.Device()
                                    .withVersion(User.DEVICE_VERSION.getUserData())
                                    .withOs(User.OS.getUserData())
                                    .withPushToken(PUSH_TOKEN.getUserData()),
                            User.APPLICATION_CLIENT.getUserData()));

            default -> null;
        };
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

    public static boolean isNumber(String id) {
        return id.matches("[0-9]+") && id.length() > 0;
    }

    public static boolean generateRandomNumber(Integer id) {
        Random random = new Random();
        boolean randomNumber = random.nextInt(99) + 1 > 0;
        return randomNumber;
    }
}
