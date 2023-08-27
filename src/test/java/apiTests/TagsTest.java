package apiTests;

import assertions.AssertionForMessages;
import assertions.AssertionForTags;
import httpRequest.RequestTags;
import org.junit.jupiter.api.*;
import responses.tags.*;
import steps.data.users.TagsInfoProvider;
import storage.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagsTest {
    AssertionForTags assertionForTags = new AssertionForTags();
    RequestTags postRequest =  new RequestTags();
    AssertionForMessages assertionForMessages = new AssertionForMessages();

    @Test
    @Order(1)
    @DisplayName("Check create tags")
    public void CreateTags() {
        SuccessCreateTags createTags = postRequest.requestPost(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
        assertionForMessages.assertRequestMessageAndCode(createTags.getMessage(), createTags.getCode());
        assertionForTags.assertResultsForSuccessCreateTags(createTags);
    }
    @Test
    @Order(2)
    @DisplayName("Check create tags without title")
    public void CreateTagsWithoutTitle() {
        TagsErrorMsg errorMsg = postRequest.requestPutErrorMsg(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
       assertionForTags.assertResultsForErrorMsgTags(errorMsg);
    }
    @Test
    @Order(3)
    @DisplayName("Check create tags with invalid credential")
    public void CreateTagsInvalidCredential() {
        TagsErrorMsg errorMsg = postRequest.requestPutErrorMsgInvalidCredential(ApiV1.STAGE.getApi(), ApiV1.TAGS.getApi());
        assertionForTags.assertResultsForInvalidErrorMsgTags(errorMsg);
    }

    @Test
    @Order(4)
    @DisplayName("Check edit tags")
    public void EditTags() {
        TagsEdit tagsEdit = postRequest.requestPut(ApiV1.STAGE.getApi(), ApiV2.TAGS_EDIT.getApi(), TagsInfoProvider.assertResultsMaxId());
        assertionForMessages.assertRequestMessageAndCode(tagsEdit.getMessage(), tagsEdit.getCode());
        assertionForTags.assertResultsForEditTags(tagsEdit);
    }

    @Test
    @Order(5)
    @DisplayName("Check tags list")
    public void getTagsListTest() {
        TagsList tagsList = postRequest.requestPostTagsList(ApiV1.STAGE.getApi(), ApiV1.TAGS_LIST.getApi());
        assertionForMessages.assertRequestMessageAndCode(tagsList.getMessage(), tagsList.getCode());
        assertionForTags.assertResults(tagsList.getData().getResult());
    }

    @Test
    @DisplayName("Check delete tag")
    public void deleteTags() {
        TagsDelete deleteTags = postRequest.requestDel(ApiV1.STAGE.getApi(), ApiV2.TAGS_DELETE.getApi(), TagsInfoProvider.assertResultsMaxId());
        assertionForMessages.assertRequestMessageAndCode(deleteTags.getMessage(), deleteTags.getCode());
    }
}
