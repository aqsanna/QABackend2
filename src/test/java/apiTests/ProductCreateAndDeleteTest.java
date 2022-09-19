package apiTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.product.SuccessCreateProduct;
import responses.product.SuccessDeleteProduct;
import steps.data.users.ProductInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.USER;

public class ProductCreateAndDeleteTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check create product")
    public void createProductTest() {
        SuccessCreateProduct successCreateProduct = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(ProductInfoProvider.getProduct(USER.EMAIL_INFO)))
                .post(APIV1.STAGE.getApi() + APIV1.CREATEPRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);

        Assertions.assertEquals("success", successCreateProduct.getResult());
        Assertions.assertEquals(200, successCreateProduct.getCode());
        Assertions.assertFalse(successCreateProduct.getData().isEmpty(), "data  is empty");
    }

    @Test
    @DisplayName("Check delete product")
    public void deleteProductTest() {
        SuccessDeleteProduct deleteProductTest = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .delete(APIV1.STAGE.getApi() + APIV1.DELETE_PRODUCT_ID.getApi() + ProductInfoProvider.getProductId())
                .then().log().all()
                .extract().as(SuccessDeleteProduct.class);
        Assertions.assertEquals("success", deleteProductTest.getResult());
        Assertions.assertEquals(200, deleteProductTest.getCode());
        Assertions.assertTrue(deleteProductTest.isData());
    }
}
