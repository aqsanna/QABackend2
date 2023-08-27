package httpRequest;

import io.restassured.http.Header;
import steps.data.users.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestProductDataType {
    public responses.ProductDataType requestProductDataType(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then().log().all()
                .extract().as(responses.ProductDataType.class);
    }
}
