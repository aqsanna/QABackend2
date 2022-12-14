package apiTests;

import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.ProductDataTypeInfo;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.ProductDataType;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductDataTypeTest {

    @Test
    @DisplayName("Check product data type")
    public void successProductDataTypeTest() {

        responses.ProductDataType productDataType = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV1.PRODUCT_DATA_TYPE.getApi())
                .then().log().all()
                .extract().as(responses.ProductDataType.class);

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
