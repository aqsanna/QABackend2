package helpers;

import io.restassured.http.Header;
import models.responses.store1.Store;
import dataProviders.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestStore {
    public Store requestStoreList(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then().log().all()
                .extract().as(Store.class);
    }
}
