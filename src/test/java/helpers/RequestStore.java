package helpers;

import io.restassured.http.Header;
import models.responses.store1.Store;
import dataProviders.UserInfoProvider;

import static io.restassured.RestAssured.given;

public class RequestStore extends AbstractRequest {
    public Store requestStoreList( String url){
        return  baseAuthorizedRequest()
                .get(url)
                .then().log().all()
                .extract().as(Store.class);
    }
}
