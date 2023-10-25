package helpers;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.modificationItems.SuccessCreateModificationItems;
import dataProviders.ModificationItemsProvider;
import dataProviders.UserInfoProvider;
import enums.User;


import static io.restassured.RestAssured.given;

public class RequestModificationItems {

    Gson gson = new Gson();

    public SuccessCreateModificationItems requestPost(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(ModificationItemsProvider.createModification(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public SuccessCreateModificationItems requestPostText(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(ModificationItemsProvider.createModificationText(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public ModificationItemErrorMsg requestPutErrorMsgInvalidCredential(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(ModificationItemsProvider.errorMessageModificationItemInvalidCredential(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(ModificationItemErrorMsg.class);
    }
}
