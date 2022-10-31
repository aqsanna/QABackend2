package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import requests.ProductDataTypeInfo;
import responses.ProductDataType;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.ProductDataTypeEnum;

import java.util.ArrayList;

import static storage.ProductDataTypeEnum.ID;
import static storage.ProductDataTypeEnum.NAME;

public class ProductDataTypeTest {
    @ParameterizedTest
    @EnumSource(ProductDataTypeEnum.class)
    @DisplayName("Check product data type")

    public void successProductDataTypeTest(ProductDataTypeEnum productDataTypeEnum){

        var enuminfo = productDataTypeEnum.getProductDataType();
        ProductDataType productDataType = RestAssured.given()
                .header(new Header("Authorization", "Bearer "+ UserInfoProvider.getToken()))
                .get(APIV1.STAGE.getApi() + APIV1.PRODUCTDATATYPE.getApi())
                .then().log().all()
                .extract().as(ProductDataType.class);

        Assertions.assertEquals("success", productDataType.getResult());
        Assertions.assertEquals("", productDataType.getError());
        Assertions.assertEquals(200, productDataType.getCode());

        ArrayList<ProductDataTypeInfo> productDataTypeInfo = productDataType.getData();
        for(ProductDataTypeInfo data : productDataTypeInfo){
            Assertions.assertEquals(enuminfo.equals(ID.getProductDataType()), data.id);
            Assertions.assertEquals(enuminfo.equals(NAME), data.getName());
        }



    }
}
