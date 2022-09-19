package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.AuthInfo;
import requests.CreateProduct;
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
                .body(gson.toJson(getProduct(USER.EMAIL_INFO)))
                .post(APIV1.STAGE.getApi() + APIV1.CREATEPRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
        return successCreateProduct.getData();
    }
}