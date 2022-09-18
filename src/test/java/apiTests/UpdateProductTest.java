package apiTests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.SuccessUpdateProduct;
import spec.Specifications;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.USER;

import static io.restassured.RestAssured.given;

public class UpdateProductTest {
    Gson gson = new Gson();
    @Test
    @DisplayName("Check success product update")
    public void successUpdateTest() {
        Specifications.installSpecification(Specifications.requestSpec(APIV1.LOGIN.getApi()), Specifications.responseOK200());

        SuccessUpdateProduct successUpdateProduct = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(UserInfoProvider.updProduct(USER.EMAIL_INFO)))
                .post(APIV1.STAGE.getApi() + APIV1.UPDATEPRODUCT.getApi() + UserInfoProvider.getProductId())
                .then().log().all()
                .extract().as(SuccessUpdateProduct.class);

        Assertions.assertEquals("success", successUpdateProduct.getResult());
        Assertions.assertEquals(200, successUpdateProduct.getCode());
        Assertions.assertFalse(successUpdateProduct.getData().isEmpty(), "data  is empty");
    }
}