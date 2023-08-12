package apiTests;

import assertions.AssertionForTags;
import com.google.gson.Gson;
import httpRequest.RequestTags;
import org.junit.jupiter.api.*;
import responses.packaging.PackagingErrorMsg;
import responses.tags.*;
import steps.data.users.TagsInfoProvider;
import storage.*;

import java.util.ArrayList;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagsTest {
    Gson gson = new Gson();
    private ArrayList<PackagingErrorMsg.Validation> validation;
    AssertionForTags assertionForTags = new AssertionForTags();

    @Test
    @Order(1)
    @DisplayName("Check create tags")
    public void CreateTags() {
        RequestTags postRequest =  new RequestTags();
        SuccessCreateTags createTags = postRequest.requestPost(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
        Assertions.assertEquals("Ok", createTags.getMessage());
        Assertions.assertEquals("OK", createTags.getCode());
        assertionForTags.assertResultsForSuccessCreateTags(createTags);
    }
    @Test
    @Order(2)
    @DisplayName("Check create tags without title")
    public void CreateTagsWithoutTitle() {
        RequestTags putRequestMsg = new RequestTags();
        TagsErrorMsg errorMsg = putRequestMsg.requestPutErrorMsg(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
       assertionForTags.assertResultsForErrorMsgTags(errorMsg);
    }


    @Test
    @Order(3)
    @DisplayName("Check edit tags")
    public void EditTags() {

        RequestTags putRequest = new RequestTags();
        TagsEdit tagsEdit = putRequest.requestPut(ApiV1.STAGE.getApi(), ApiV2.TAGS_EDIT.getApi(), TagsInfoProvider.getTagsId());
        Assertions.assertEquals("OK", tagsEdit.getCode());
        Assertions.assertEquals("Ok", tagsEdit.getMessage());
        assertionForTags.assertResultsForEditTags(tagsEdit);
    }

    @Test
    @Order(4)
    @DisplayName("Check tags list")
    public void getTagsListTest() {
        Gson gson = new Gson();
        RequestTags getRequest = new RequestTags();
        TagsList tagsList = getRequest.requestPostTagsList(ApiV1.STAGE.getApi(), ApiV1.TAGS_LIST.getApi());
        Assertions.assertEquals("Ok", tagsList.getMessage());
        Assertions.assertEquals("OK", tagsList.getCode());
        assertionForTags.assertResults(tagsList.getData().getResult());
    }

    @Test
    @DisplayName("Check delete tag")
    public void deleteTags() {
        Gson gson = new Gson();
        RequestTags deleteRequest = new RequestTags();
        TagsDelete deleteTags = deleteRequest.requestDel(ApiV1.STAGE.getApi(), ApiV2.TAGS_DELETE.getApi(), TagsInfoProvider.getTagsId());
        Assertions.assertEquals("Ok", deleteTags.getMessage());
        Assertions.assertEquals("OK", deleteTags.getCode());
    }
}
