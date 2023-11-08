package apiTests;

import assertions.AssertionForProduct;
import helpers.RequestProduct;
import org.junit.jupiter.api.*;
import models.responses.product.SuccessCreateProduct;
import models.responses.product.SuccessDeleteProduct;
import models.responses.product.SuccessUpdateProduct;
import specification.RequestSpec;
import specification.ResponseSpec;
import dataProviders.ProductInfoProvider;
import enums.ApiV1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {
    RequestProduct requestProduct = new RequestProduct();
    AssertionForProduct assertionForProduct = new AssertionForProduct();
    @Test
    @Order(1)
    @DisplayName("Check create product")
    public void createProductTest() {
        SuccessCreateProduct successCreateProduct = requestProduct.requestCreateProduct( ApiV1.CREATE_PRODUCT.getApi());
        assertionForProduct.assertCreateProduct(successCreateProduct);
    }
    @Test
    @Order(2)
    @DisplayName("Check success product update")
    public void successUpdateTest() {
        RequestSpec.installSpecification(RequestSpec.requestSpec(ApiV1.LOGIN.getApi()), ResponseSpec.responseOK200());
        SuccessUpdateProduct successUpdateProduct = requestProduct.requestUpdateProduct(ApiV1.UPDATE_PRODUCT.getApi(), RequestProduct.getProductId());
        assertionForProduct.assertUpdateProduct(successUpdateProduct);

    }
    @Test
    @Order(3)
    @DisplayName("Check delete product")
    public void deleteProductTest() {
        SuccessDeleteProduct deleteProductTest = requestProduct.requestDeleteProduct( ApiV1.DELETE_PRODUCT_ID.getApi(), RequestProduct.getProductId());
        assertionForProduct.assertDeleteProduct(deleteProductTest);
    }

}
