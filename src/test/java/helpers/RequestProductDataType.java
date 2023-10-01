package helpers;

import io.restassured.http.Header;
import models.responses.productDataType.ProductDataType;
import dataProviders.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestProductDataType {
    public ProductDataType requestProductDataType(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then().log().all()
                .extract().as(ProductDataType.class);
    }
}
