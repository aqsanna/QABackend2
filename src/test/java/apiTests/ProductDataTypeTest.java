package apiTests;

import assertions.AssertionForProductDataType;
import httpRequest.RequestProductDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import storage.ApiV1;

public class ProductDataTypeTest {
    RequestProductDataType requestProductDataType = new RequestProductDataType();
    AssertionForProductDataType assertionForProductDataType = new AssertionForProductDataType();
    @Test
    @DisplayName("Check product data type")
    public void successProductDataTypeTest() {

        responses.ProductDataType productDataType = requestProductDataType.requestProductDataType(ApiV1.STAGE.getApi(), ApiV1.PRODUCT_DATA_TYPE.getApi());
        assertionForProductDataType.assertProductDataType(productDataType);
    }
}
