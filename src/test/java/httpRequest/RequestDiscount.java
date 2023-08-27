package httpRequest;

import io.restassured.http.Header;
import responses.Discount;
import steps.data.users.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestDiscount {
    public Discount requestDiscountList(String path, String url){
        return  given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then()
                .extract().as(Discount.class);
    }
}
