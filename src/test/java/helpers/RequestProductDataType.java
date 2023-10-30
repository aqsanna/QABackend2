package helpers;

import io.restassured.http.Header;
import models.responses.productDataType.ProductDataType;
import dataProviders.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestProductDataType extends AbstractRequest {
    public ProductDataType requestProductDataType(String url){
        return baseAuthorizedRequest()
                .get(url)
                .then().log().all()
                .extract().as(ProductDataType.class);
    }
}
