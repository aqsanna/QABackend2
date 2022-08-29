import io.restassured.RestAssured;
import utils.GeneralUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import storage.APIV2;
import responses.userLogin.DeleteProduct;
import io.restassured.http.Header;

public class DeleteProductTest {
    @Test
    @DisplayName("Check delete product")
    public void deleteProductTest()
    {
        DeleteProduct deleteProductTest = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + GeneralUtils.getToken()))
                .delete(APIV2.STAGE.getApi() + APIV2.DELETEPRODUCTID.getApi())
                .then().log().all()
                 .extract().as(DeleteProduct.class);

        Assertions.assertEquals("success", deleteProductTest.getResult());
        Assertions.assertEquals(200, deleteProductTest.getCode());
        Assertions.assertEquals(true, deleteProductTest.isData());
    }

}