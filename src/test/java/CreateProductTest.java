import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.deleteProduct.SuccessCreateProduct;
import steps.data.users.UserInfoProvider;
import storage.APIV2;
import storage.USER;

public class CreateProductTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check create product")
    public void createProductTest() {

        SuccessCreateProduct successCreateProduct = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(UserInfoProvider.getProduct(USER.EMAIL_INFO)))
                .post(APIV2.STAGE.getApi() + APIV2.CREATEPRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);

        Assertions.assertEquals("success", successCreateProduct.getResult());
        Assertions.assertEquals(200, successCreateProduct.getCode());
        Assertions.assertFalse(successCreateProduct.getData().isEmpty(), "data  is empty");
    }
}
