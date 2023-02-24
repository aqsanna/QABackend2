package httpRequest;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import responses.tags.SuccessCreateTags;
import responses.tags.TagsDelete;
import responses.tags.TagsEdit;
import responses.tags.TagsList;
import steps.data.users.TagsInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.User;

import static io.restassured.RestAssured.given;

public class Request {
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
                .post(path + url)
                .then()
                .extract().as(SuccessCreateTags.class);
    }

    public TagsEdit requestPut(String path, String url, Integer tagsInfoProvider) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.editTags(User.EMAIL_INFO)))
                .put(path + url + tagsInfoProvider)
                .then()
                .extract().as(TagsEdit.class);
    }

    public TagsList requestGet(String path, String url) {

        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then()
                .extract().as(TagsList.class);
    }

}
