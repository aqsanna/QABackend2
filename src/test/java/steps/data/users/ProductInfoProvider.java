package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.AuthInfo;
import requests.CreateProduct;
import requests.UpdateProduct;
import responses.product.SuccessCreateProduct;
import storage.APIV1;
import storage.USER;

import java.util.Random;

public class ProductInfoProvider {
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

    public static UpdateProduct updProduct(USER email) {
        return switch (email) {
            case EMAIL_INFO -> new UpdateProduct(
                    new UpdateProduct.Params(
                            USER.NAME.getUserData()
                            , random()
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
        SuccessCreateProduct successCreateProduct = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(getProduct(USER.EMAIL_INFO)))
                .post(APIV1.STAGE.getApi() + APIV1.CREATEPRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
        return successCreateProduct.getData();
    }
}
