package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.AuthInfo;
import requests.CreateProduct;
import responses.product.SuccessCreateProduct;
import responses.userLogin.SuccessLogin;
import storage.APIV2;
import storage.USER;

import java.util.Random;

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

    public static CreateProduct getProduct(USER email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateProduct(
                    new CreateProduct.Params(
                            USER.NAME.getUserData()
                            , random()
                            , USER.CATEGORY_ID.getUserData()
                            , Double.parseDouble(USER.PRICE.getUserData())
                            , USER.PRICE_UNITS.getUserData()));

            default -> null;
        };
    }

    public static String random() {
        Random ran = new Random();
        int x = ran.nextInt(999999999);
        return Integer.toString(x);
    }

    public static String getProductId() {
        Gson gson = new Gson();

        AuthInfo authInfo = UserInfoProvider.getUser(USER.EMAIL_INFO);

        SuccessCreateProduct successCreateProduct = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(UserInfoProvider.getProduct(USER.EMAIL_INFO)))
                .post(APIV2.STAGE.getApi() + APIV2.CREATEPRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
        return successCreateProduct.getData();
    }

    public static String getToken() {
        Gson gson = new Gson();

        AuthInfo authInfo = UserInfoProvider.getUser(USER.EMAIL_INFO);

        SuccessLogin login = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(authInfo))
                .post(APIV2.STAGE.getApi() + APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);
        return login.getData().getToken();
    }
}
