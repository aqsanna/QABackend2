package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.AuthInfo;
import requests.CreateProduct;
import requests.UpdateProduct;
import responses.SuccessCreateProduct;
import responses.userLogin.SuccessLogin;
import storage.APIV1;
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
    public static UpdateProduct updProduct(USER email)  {
        return switch (email) {
            case EMAIL_INFO -> new UpdateProduct(
                    new UpdateProduct.Params(
                              USER.NAME.getUserData()
                            ,random()
                            , USER.CATEGORY_ID.getUserData()
                            , Double.parseDouble(USER.PRICE.getUserData())
                            , USER.PRICE_UNITS.getUserData()
                            , Integer.parseInt(USER.VOLUME.getUserData())
                            , USER.VOLUME_UNITS.getUserData()
                            , Integer.parseInt(USER.QUANTITY_IN_PACK.getUserData())
                            , Integer.parseInt(USER.DISPLAYED_VALUE_FOR_PRICE.getUserData())
                            , USER.DESCRIPTION.getUserData()
                            , USER.INGREDIENTS.getUserData()
                            , Integer.parseInt(USER.TAG_IDS.getUserData())
                            , Boolean.parseBoolean(USER.IS_FOODSTAMP.getUserData())
                            , Boolean.parseBoolean(USER.IS_SHIPPABLE.getUserData())
                            , Boolean.parseBoolean(USER.HAS_AVAILABILITY_SCHEDULE.getUserData())));

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
                .post(APIV1.STAGE.getApi() + APIV1.CREATEPRODUCT.getApi())
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
                .post(APIV1.STAGE.getApi() + APIV1.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);
        return login.getData().getToken();
    }

    public static boolean isNumber(String id) {
        return id.matches("[0-9]+") && id.length() > 0;
    }
}
