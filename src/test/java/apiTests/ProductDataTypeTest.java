package apiTests;

import assertions.AssertionForProductDataType;
import helpers.RequestProductDataType;
import models.responses.productDataType.ProductDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import enums.ApiV1;

public class ProductDataTypeTest {
    RequestProductDataType requestProductDataType = new RequestProductDataType();
    AssertionForProductDataType assertionForProductDataType = new AssertionForProductDataType();
    @Test
    @DisplayName("Check product data type")
    public void successProductDataTypeTest() {

        ProductDataType productDataType = requestProductDataType.requestProductDataType(ApiV1.PRODUCT_DATA_TYPE.getApi());
        assertionForProductDataType.assertProductDataType(productDataType);
    }
}
