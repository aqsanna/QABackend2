package apiTests;

import assertions.AssertionForProduct;
import com.google.gson.Gson;
import httpRequest.RequestProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.product.SuccessCreateProduct;
import responses.product.SuccessDeleteProduct;
import responses.product.SuccessUpdateProduct;
import specification.RequestSpec;
import specification.ResponseSpec;
import steps.data.users.ProductInfoProvider;
import storage.ApiV1;

public class ProductTest {
    RequestProduct requestProduct = new RequestProduct();
    AssertionForProduct assertionForProduct = new AssertionForProduct();
    @Test
    @DisplayName("Check create product")
    public void createProductTest() {
        SuccessCreateProduct successCreateProduct = requestProduct.requestCreateProduct(ApiV1.STAGE.getApi(), ApiV1.CREATE_PRODUCT.getApi());
        assertionForProduct.assertCreateProduct(successCreateProduct);
    }
    @Test
    @DisplayName("Check delete product")
    public void deleteProductTest() {
        SuccessDeleteProduct deleteProductTest = requestProduct.requestDeleteProduct(ApiV1.STAGE.getApi(), ApiV1.DELETE_PRODUCT_ID.getApi(), ProductInfoProvider.getProductId());
        assertionForProduct.assertDeleteProduct(deleteProductTest);
    }
    @Test
    @DisplayName("Check success product update")
    public void successUpdateTest() {
        RequestSpec.installSpecification(RequestSpec.requestSpec(ApiV1.LOGIN.getApi()), ResponseSpec.responseOK200());
        SuccessUpdateProduct successUpdateProduct = requestProduct.requestUpdateProduct(ApiV1.STAGE.getApi(),ApiV1.UPDATE_PRODUCT.getApi(), ProductInfoProvider.getProductId());
        assertionForProduct.assertUpdateProduct(successUpdateProduct);

    }
}
