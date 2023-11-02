package helpers;

import com.google.gson.Gson;
import config.Configurations;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.tags.*;
import dataProviders.TagsInfoProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestTags extends AbstractRequest{
    Gson gson = new Gson();

    public TagsDelete requestDel(String url, Integer tagsInfoProvider) {

        return baseAuthorizedRequest()
                .delete( url + tagsInfoProvider)
                .then()
                .extract().as(TagsDelete.class);
    }

    public SuccessCreateTags requestPost(String url) {

        return baseAuthorizedRequest()
                .body(gson.toJson(TagsInfoProvider.getTags(User.EMAIL_INFO)))
                .put(url)
                .then()
                .extract().as(SuccessCreateTags.class);
    }
    public TagsErrorMsg requestPutErrorMsg(String url) {

        return baseAuthorizedRequest()
                .body(gson.toJson(TagsInfoProvider.errorMessageTags(User.EMAIL_INFO)))
                .put( url)
                .then()
                .extract().as(TagsErrorMsg.class);
    }
    public TagsEdit requestPutChangeStatus(String url, Integer tagsInfoProvider) {

        return baseAuthorizedRequest()
                .body(gson.toJson(TagsInfoProvider.changeStatus(User.EMAIL_INFO)))
                .put( url + tagsInfoProvider)
                .then()
                .extract().as(TagsEdit.class);
    }
    public TagsEdit requestPutChangeVisible(String url, Integer tagsInfoProvider) {

        return baseAuthorizedRequest()
                .body(gson.toJson(TagsInfoProvider.changeVisible(User.EMAIL_INFO)))
                .put(url + tagsInfoProvider)
                .then()
                .extract().as(TagsEdit.class);
    }
    public TagsEdit requestPutChangeShowOnProductCard(String url, Integer tagsInfoProvider) {

        return baseAuthorizedRequest()
                .body(gson.toJson(TagsInfoProvider.changeShowOnProductCard(User.EMAIL_INFO)))
                .put( url + tagsInfoProvider)
                .then()
                .extract().as(TagsEdit.class);
    }

    public TagsErrorMsg requestPutErrorMsgInvalidCredential(String url) {

        return baseAuthorizedRequest()
                .body(gson.toJson(TagsInfoProvider.errorMessageTagsInvalidCredential(User.EMAIL_INFO)))
                .put(url)
                .then()
                .extract().as(TagsErrorMsg.class);
    }

    public TagsEdit requestPut(String url, Integer tagsInfoProvider) {

        return baseAuthorizedRequest()
                .body((TagsInfoProvider.editTags(User.EMAIL_INFO)))
                .put(url + tagsInfoProvider)
                .then()
                .extract().as(TagsEdit.class);
    }

    public TagsList requestPostTagsList(String url) {
        return baseAuthorizedRequest()
                .body((TagsInfoProvider.listTags(User.EMAIL_INFO)))
                .post(Configurations.DEV_URL + url)
                .then()
                .extract().as(TagsList.class);
    }

}
