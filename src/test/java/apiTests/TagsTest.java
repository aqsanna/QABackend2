package apiTests;

import com.google.gson.Gson;
import httpRequest.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.TagsInfo;
import responses.tags.SuccessCreateTags;
import responses.tags.TagsDelete;
import responses.tags.TagsEdit;
import responses.tags.TagsList;
import steps.data.users.TagsInfoProvider;
import storage.ApiV1;
import storage.User;

import java.util.ArrayList;


public class TagsTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check create tags")
    public void CreateTags() {
        Request postRequest = new Request();
        postRequest.requestPost(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
        SuccessCreateTags createTags = postRequest.requestPost(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
        Assertions.assertEquals("success", createTags.getResult());
        Assertions.assertEquals(200, createTags.getCode());
        Assertions.assertFalse(createTags.getData().getId().isEmpty(), "is  is empty");
        Assertions.assertFalse(createTags.getData().getTitle().isEmpty(), "title  is empty");
    }

    @Test
    @DisplayName("Check edit tags")
    public void EditTags() {

        Request putRequest = new Request();
        putRequest.requestPut(ApiV1.STAGE.getApi(), ApiV1.TAGS_EDIT.getApi(), TagsInfoProvider.getTagsId());
        TagsEdit tagsEdit = putRequest.requestPut(ApiV1.STAGE.getApi(), ApiV1.TAGS_EDIT.getApi(), TagsInfoProvider.getTagsId());

        Assertions.assertEquals("OK", tagsEdit.getCode());
        Assertions.assertEquals("Ok", tagsEdit.getMessage());
        Assertions.assertFalse(tagsEdit.getData().getId().isEmpty(), "is  is empty");
        Assertions.assertEquals(tagsEdit.getData().getPartnerId(), "13546");
        Assertions.assertEquals(tagsEdit.getData().getPriority(), User.PRIORITY.getUserData());
        Assertions.assertFalse(tagsEdit.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertTrue(tagsEdit.getData().getIcon().contains("jpg"));
    }

    @Test
    @DisplayName("Check tags list")
    public void getTagsListTest() {
        Gson gson = new Gson();
        Request getRequest = new Request();
        getRequest.requestGet(ApiV1.STAGE.getApi(), ApiV1.TAGS_LIST.getApi());
        TagsList tagsList = getRequest.requestGet(ApiV1.STAGE.getApi(), ApiV1.TAGS_LIST.getApi());
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
    @DisplayName("Check delete tag")
    public void deleteTags() {
        Gson gson = new Gson();
        Request deleteRequest = new Request();
        deleteRequest.requestDel(ApiV1.STAGE.getApi(), ApiV1.TAGS_DELETE.getApi(), TagsInfoProvider.getTagsId());
        TagsDelete deleteTags = deleteRequest.requestDel(ApiV1.STAGE.getApi(), ApiV1.TAGS_DELETE.getApi(), TagsInfoProvider.getTagsId());
        Assertions.assertEquals("Ok", deleteTags.getMessage());
        Assertions.assertEquals("OK", deleteTags.getCode());
    }
}
