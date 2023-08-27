package assertions;

import Utils.ErrorMessages;
import org.junit.jupiter.api.Assertions;
import responses.product.SuccessCreateProduct;
import responses.product.SuccessDeleteProduct;
import responses.product.SuccessUpdateProduct;

public class AssertionForProduct {
    public void assertCreateProduct( SuccessCreateProduct successCreateProduct){
        Assertions.assertEquals(ErrorMessages.successMsg, successCreateProduct.getResult());
        Assertions.assertEquals(ErrorMessages.successCode, successCreateProduct.getCode());
        Assertions.assertFalse(successCreateProduct.getData().isEmpty(), "data  is empty");
    }

    public void assertDeleteProduct( SuccessDeleteProduct deleteProductTest){
        Assertions.assertEquals(ErrorMessages.successMsg, deleteProductTest.getResult());
        Assertions.assertEquals(ErrorMessages.successCode, deleteProductTest.getCode());
        Assertions.assertTrue(deleteProductTest.isData());
    }
    public void assertUpdateProduct(SuccessUpdateProduct successUpdateProduct){
        Assertions.assertEquals(ErrorMessages.successMsg, successUpdateProduct.getResult());
        Assertions.assertEquals(ErrorMessages.successCode, successUpdateProduct.getCode());
    }
}
