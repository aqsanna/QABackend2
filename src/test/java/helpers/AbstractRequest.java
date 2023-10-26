package helpers;

import com.google.gson.Gson;
import dataProviders.PackagingProvider;
import dataProviders.UserInfoProvider;
import enums.User;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import models.responses.packaging.PackagingForStore;

import static io.restassured.RestAssured.given;

public abstract class AbstractRequest {
    Gson gson = new Gson();

    protected RequestSpecification baseAuthorizedRequest() {
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON);
    }
}
