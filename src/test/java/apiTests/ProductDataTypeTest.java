package apiTests;


import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.ProductDataTypeInfo;
import responses.ProductDataType;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.ProductDataTypeEnum;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductDataTypeTest {

    @Test
    @DisplayName("Check product data type")
    public void successProductDataTypeTest() {

        ProductDataType productDataType = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(APIV1.STAGE.getApi() + APIV1.PRODUCTDATATYPE.getApi())
                .then().log().all()
                .extract().as(ProductDataType.class);

        Assertions.assertEquals("success", productDataType.getResult());
        Assertions.assertEquals("", productDataType.getError());
        Assertions.assertEquals(200, productDataType.getCode());

        List<String> expectedList = ProductDataTypeEnum.getType();
        List<String> actualList = new ArrayList<String>();

        for (ProductDataTypeInfo data : productDataType.getData()) {
            actualList.add(data.getId());
            actualList.add(data.getName());
        }
         Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
    }
}
