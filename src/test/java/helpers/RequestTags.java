package helpers;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.tags.*;
import dataProviders.TagsInfoProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestTags {
    Gson gson = new Gson();

    public TagsDelete requestDel(String path, String url, Integer tagsInfoProvider) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .delete(path + url + tagsInfoProvider)
                .then()
                .extract().as(TagsDelete.class);
    }

    public SuccessCreateTags requestPost(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.getTags(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(SuccessCreateTags.class);
    }
    public TagsErrorMsg requestPutErrorMsg(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.errorMessageTags(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(TagsErrorMsg.class);
    }

    public TagsErrorMsg requestPutErrorMsgInvalidCredential(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.errorMessageTagsInvalidCredential(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(TagsErrorMsg.class);
    }

    public TagsEdit requestPut(String path, String url, Integer tagsInfoProvider) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((TagsInfoProvider.editTags(User.EMAIL_INFO)))
                .put(path + url + tagsInfoProvider)
                .then()
                .extract().as(TagsEdit.class);
    }

    public TagsList requestPostTagsList(String path, String url) {
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((TagsInfoProvider.listTags(User.EMAIL_INFO)))
                .post(path + url)
                .then()
                .extract().as(TagsList.class);
    }

}
