package apiTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.TaxesInfo;
import responses.Taxes.SuccessCreateTax;
import responses.Taxes.Taxes;
import responses.product.SuccessUpdateProduct;
import specification.RequestSpec;
import specification.ResponseSpec;
import steps.data.users.ProductInfoProvider;
import steps.data.users.TaxesInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TaxesTest {
    Gson gson = new Gson();
    @Test
    @DisplayName("Check create product")
    public void CreateTax(){
        SuccessCreateTax successCreateTax = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TaxesInfoProvider.getTaxes(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAX_CREATE.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTax.class);

        Assertions.assertEquals(1, successCreateTax.getResult());
        Assertions.assertEquals("save-tax63a58f9e63ef6", successCreateTax.getSequence());
        Assertions.assertEquals("", successCreateTax.getMessage());
        Assertions.assertEquals("", successCreateTax.getError());
        Assertions.assertNotNull(successCreateTax.getData().getResult().id, "Id is empty");
        Assertions.assertNotNull(successCreateTax.getData().getResult().type, "type is empty");
        Assertions.assertFalse(successCreateTax.getData().getResult().storeId.isEmpty(), "Store id is empty");
        Assertions.assertEquals("2", successCreateTax.getData().getResult().value);
        Assertions.assertEquals("0", successCreateTax.getData().getResult().applyToAllProducts);
        Assertions.assertEquals("1", successCreateTax.getData().getResult().perUnit);
        Assertions.assertEquals("0", successCreateTax.getData().getResult().isCrv);
        Assertions.assertFalse(successCreateTax.getData().getResult().title.isEmpty(), "Title is empty");
        Assertions.assertFalse(successCreateTax.getData().getResult().visibleTitle.isEmpty(), "Visible title is empty");
        Assertions.assertFalse(successCreateTax.getData().getResult().description.isEmpty(), "Description is empty");

    }

    @Test
    @DisplayName("Check success tax update")
    public void successUpdateTax() {
//                SuccessUpdateProduct successUpdateProduct = given()
//                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
//                .when()
//                .contentType(ContentType.JSON)
//                .body(gson.toJson(ProductInfoProvider.updProduct(User.EMAIL_INFO)))
//                .put(ApiV1.STAGE.getApi() + ApiV1.UPDATE_PRODUCT.getApi() + ProductInfoProvider.getProductId())
//                .then().log().all()
//                .extract().as(SuccessUpdateProduct.class);
//
//        Assertions.assertEquals("success", successUpdateProduct.getResult());
//        Assertions.assertEquals(200, successUpdateProduct.getCode());
//        Assertions.assertFalse(successUpdateProduct.getData().isEmpty(), "data  is empty");
    }


    @Test
    @DisplayName("Check success partner taxes list")
    public void CheckTaxesListTest() {
        Taxes taxes = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV1.TAXES_LIST.getApi())
                .then().log().all()
                .extract().as(Taxes.class);
        Assertions.assertEquals("success", taxes.getResult());
        Assertions.assertEquals(200, taxes.getCode());
        Assertions.assertEquals("", taxes.getError());

        ArrayList<TaxesInfo> taxesInfo = taxes.getData();

        for (TaxesInfo data : taxesInfo) {
            Assertions.assertNotNull(data.getId(), "id is empty");
            Assertions.assertNotNull(data.getTitle(), "title is empty");
        }

    }
}
