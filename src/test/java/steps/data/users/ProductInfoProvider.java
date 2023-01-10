package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.CreateProduct;
import requests.UpdateProduct;
import responses.product.SuccessCreateProduct;
import storage.ApiV1;
import storage.User;

import java.util.Random;

public class ProductInfoProvider {
    public static CreateProduct getProduct(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateProduct(
                    new CreateProduct.Params(
                            User.NAME.getUserData()
                            , random()
                            , User.CATEGORY_ID.getUserData()
                            , Double.parseDouble(User.PRICE.getUserData())
                            , User.PRICE_UNITS.getUserData()));

            default -> null;
        };
    }

    public static UpdateProduct updProduct(User email) {
        return switch (email) {
            case EMAIL_INFO -> new UpdateProduct(
                    new UpdateProduct.Params(
                            User.NAME.getUserData()
                            , random()
                            , User.CATEGORY_ID.getUserData()
                            , Double.parseDouble(User.PRICE.getUserData())
                            , User.PRICE_UNITS.getUserData()
                            , Integer.parseInt(User.VOLUME.getUserData())
                            , User.VOLUME_UNITS.getUserData()
                            , Integer.parseInt(User.QUANTITY_IN_PACK.getUserData())
                            , Integer.parseInt(User.DISPLAYED_VALUE_FOR_PRICE.getUserData())
                            , User.DESCRIPTION.getUserData()
                            , User.INGREDIENTS.getUserData()
                            , Integer.parseInt(User.TAG_IDS.getUserData())
                            , Boolean.parseBoolean(User.IS_FOODSTAMP.getUserData())
                            , Boolean.parseBoolean(User.IS_SHIPPABLE.getUserData())
                            , Boolean.parseBoolean(User.HAS_AVAILABILITY_SCHEDULE.getUserData())));

            default -> null;
        };
    }

    public static String getProductId() {
        Gson gson = new Gson();
        SuccessCreateProduct successCreateProduct = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(getProduct(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.CREATE_PRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
        return successCreateProduct.getData();
    }

    public static String random() {
        Random ran = new Random();
        int x = ran.nextInt(999999999);
        return Integer.toString(x);
    }
}
