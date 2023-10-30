package apiTests;

import assertions.AssertionForProduct;
import helpers.RequestProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.responses.product.SuccessCreateProduct;
import models.responses.product.SuccessDeleteProduct;
import models.responses.product.SuccessUpdateProduct;
import specification.RequestSpec;
import specification.ResponseSpec;
import dataProviders.ProductInfoProvider;
import enums.ApiV1;

public class ProductTest {
    RequestProduct requestProduct = new RequestProduct();
    AssertionForProduct assertionForProduct = new AssertionForProduct();
    @Test
    @DisplayName("Check create product")
    public void createProductTest() {
        SuccessCreateProduct successCreateProduct = requestProduct.requestCreateProduct( ApiV1.CREATE_PRODUCT.getApi());
        assertionForProduct.assertCreateProduct(successCreateProduct);
    }
    @Test
    @DisplayName("Check delete product")
    public void deleteProductTest() {
        SuccessDeleteProduct deleteProductTest = requestProduct.requestDeleteProduct( ApiV1.DELETE_PRODUCT_ID.getApi(), ProductInfoProvider.getProductId());
        assertionForProduct.assertDeleteProduct(deleteProductTest);
    }
    @Test
    @DisplayName("Check success product update")
    public void successUpdateTest() {
        RequestSpec.installSpecification(RequestSpec.requestSpec(ApiV1.LOGIN.getApi()), ResponseSpec.responseOK200());
        SuccessUpdateProduct successUpdateProduct = requestProduct.requestUpdateProduct(ApiV1.UPDATE_PRODUCT.getApi(), ProductInfoProvider.getProductId());
        assertionForProduct.assertUpdateProduct(successUpdateProduct);

    }
}
