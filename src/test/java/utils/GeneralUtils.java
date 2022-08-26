package utils;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import requests.AuthInfo;
import responses.SuccessLogin;
import storage.APIV2;
import storage.USER;

import static io.restassured.RestAssured.given;

public class GeneralUtils {

    public static String getToken() {
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

        SuccessLogin login = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(authInfo))
                .post(APIV2.STAGE.getApi() + APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);
        return login.getData().getToken();
    }


    public static boolean isNumber(String id) {
        return id.matches("[0-9]+") && id.length() > 0;
    }

}
