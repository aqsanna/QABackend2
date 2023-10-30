package helpers;

import io.restassured.http.Header;
import models.responses.discount.Discount;
import dataProviders.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestDiscount extends AbstractRequest {
    public Discount requestDiscountList(String url){
        return  baseAuthorizedRequest()
                .get(url)
                .then()
                .extract().as(Discount.class);
    }
}
