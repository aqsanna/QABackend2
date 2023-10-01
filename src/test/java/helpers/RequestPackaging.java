package helpers;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import dataProviders.PackagingProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestPackaging {
    Gson gson = new Gson();

    public PackagingForStore requestCreate(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.createPack(User.EMAIL_INFO)))
                .put(path + url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }

    public PackagingForStore requestUpdate(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.updatePacking(User.EMAIL_INFO)))
                .put(path + url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }
    public PackagingErrorMsg requestPutErrorMsg(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.checkErrorMessages(User.EMAIL_INFO)))
                .put(path + url)
                .then().log().all()
                .extract().as(PackagingErrorMsg.class);
    }
    public PackagingErrorMsg requestPutErrorMsgForInvalidCredential(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.checkErrorMessagesForInvalidCredential(User.EMAIL_INFO)))
                .put(path + url)
                .then().log().all()
                .extract().as(PackagingErrorMsg.class);
    }

    public PackagingForStore requestDel(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.deletePacking(User.EMAIL_INFO)))
                .put(path + url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }
}
