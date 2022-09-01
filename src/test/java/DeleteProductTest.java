import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.deleteProduct.DeleteProduct;
import steps.data.users.UserInfoProvider;
import storage.APIV2;

public class DeleteProductTest {
    @Test
    @DisplayName("Check delete product")
    public void deleteProductTest() {
        DeleteProduct deleteProductTest = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .delete(APIV2.STAGE.getApi() + APIV2.DELETE_PRODUCT_ID.getApi())
                .then().log().all()
                .extract().as(DeleteProduct.class);
        Assertions.assertEquals("success", deleteProductTest.getResult());
        Assertions.assertEquals(200, deleteProductTest.getCode());
        Assertions.assertTrue(deleteProductTest.isData());
    }
}