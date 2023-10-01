package assertions;

import org.junit.jupiter.api.Assertions;
import models.requests.productDadaType.ProductDataTypeInfo;
import enums.ProductDataType;

import java.util.ArrayList;
import java.util.List;

public class AssertionForProductDataType {
    public void assertProductDataType( models.responses.productDataType.ProductDataType productDataType){
        Assertions.assertEquals("success", productDataType.getResult());
        Assertions.assertEquals("", productDataType.getError());
        Assertions.assertEquals(200, productDataType.getCode());
        List<String> expectedList = ProductDataType.getType();
        List<String> actualList = new ArrayList<String>();
        for (ProductDataTypeInfo data : productDataType.getData()) {
            actualList.add(data.getId());
            actualList.add(data.getName());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }
}
