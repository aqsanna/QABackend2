package apiTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.TagsInfo;
import responses.tags.SuccessCreateTags;
import responses.tags.TagsDelete;
import responses.tags.TagsEdit;
import responses.tags.TagsList;
import steps.data.users.TagsInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TagsTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check create tags")
    public void CreateTags() {
        SuccessCreateTags successCreateTags = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.getTags(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAGS.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTags.class);

        Assertions.assertEquals("success", successCreateTags.getResult());
        Assertions.assertEquals(200, successCreateTags.getCode());
        Assertions.assertFalse(successCreateTags.getData().getId().isEmpty(), "is  is empty");
        Assertions.assertFalse(successCreateTags.getData().getTitle().isEmpty(), "title  is empty");
    }

    @Test
    @DisplayName("Check edit tags")
    public void EditTags() {
        TagsEdit tagsEdit = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.editTags(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV1.TAGS_EDIT.getApi() + TagsInfoProvider.getTagsId())
                .then().log().all()
                .extract().as(TagsEdit.class);


        Assertions.assertEquals("OK", tagsEdit.getCode());
        Assertions.assertEquals("Ok", tagsEdit.getMessage());
        Assertions.assertFalse(tagsEdit.getData().getId().isEmpty(), "is  is empty");
        Assertions.assertEquals(tagsEdit.getData().getPartnerId(), "13546");
        Assertions.assertEquals(tagsEdit.getData().getPriority(), "10");
        Assertions.assertFalse(tagsEdit.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertTrue(tagsEdit.getData().getIcon().contains("jpg"));
    }

    @Test
    @DisplayName("check tags list")
    public void getTagsListTest() {
        Gson gson = new Gson();

        TagsList tagsList = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV1.TAGS_LIST.getApi())
                .then().log().all()
                .extract().as(TagsList.class);
        Assertions.assertEquals("success", tagsList.getResult());
        Assertions.assertEquals("", tagsList.getError());
        Assertions.assertEquals(200, tagsList.getCode());
        ArrayList<TagsInfo> tagsData = tagsList.getData();
        for (TagsInfo data : tagsData) {
            Assertions.assertFalse(data.title.isEmpty(), "title  is empty");
            Assertions.assertFalse(data.id.isEmpty(), "id  is empty");
            Assertions.assertEquals(tagsData.size(), 100);
        }
    }

    @Test
    @DisplayName("check tags list")
    public void deleteTags() {
        Gson gson = new Gson();

        TagsDelete deleteTags = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .delete(ApiV1.STAGE.getApi() + ApiV1.TAGS_DELETE.getApi() + TagsInfoProvider.getTagsId())
                .then().log().all()
                .extract().as(TagsDelete.class);
        Assertions.assertEquals("Ok", deleteTags.getMessage());
        Assertions.assertEquals("OK", deleteTags.getCode());
    }
}
