package assertions;

import Utils.ErrorMessages;
import org.junit.jupiter.api.Assertions;
import responses.tags.SuccessCreateTags;
import responses.tags.TagsEdit;
import responses.tags.TagsErrorMsg;
import responses.tags.TagsList;
import storage.TagMessages;
import storage.TagMessagesInvalidCredential;

import java.util.ArrayList;
import java.util.List;
public class AssertionForTags {
    public void assertResults(ArrayList<TagsList.Data.Result> list) {
        for (TagsList.Data.Result result : list) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertEquals(result.partnerId, "13546");
            Assertions.assertTrue(result.visible>=0, "visible more than 0");
            Assertions.assertTrue(result.status>=0, "status more than 0");
            Assertions.assertTrue(result.showIconOnProduct>=0, "showIconOnProduct more than 0");
            Assertions.assertFalse(result.title.isEmpty(), "title is empty");
            Assertions.assertTrue(result.products>=0, "products more than 0");
        }
    }
    public void assertResultsForSuccessCreateTags(SuccessCreateTags createTags) {
        Assertions.assertEquals(createTags.getData().getPartnerId(), "13546");
        Assertions.assertFalse(createTags.getData().getIcon().isEmpty(), "icon  is empty");
        Assertions.assertTrue(createTags.getData().getStatus()>0, "status more than 0");
        Assertions.assertFalse(createTags.getData().getPriority().isEmpty(), "priority  is empty");
        Assertions.assertTrue(createTags.getData().getVisible()>0, "visible more than 0");
        Assertions.assertTrue(createTags.getData().getShowIconOnProduct()>0, "show_icon_on_product more than 0");
        Assertions.assertFalse(createTags.getData().getTitle().isEmpty(), "title  is empty");
    }
    public void assertResultsForErrorMsgTags(TagsErrorMsg errorMsg) {
        Assertions.assertEquals(ErrorMessages.messageForTagsTitle, errorMsg.getMessage());
        Assertions.assertEquals(ErrorMessages.codeUnprocessableEntity, errorMsg.getCode());

        List<String> expectedList = TagMessages.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (TagsErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }

    public void assertResultsForInvalidErrorMsgTags(TagsErrorMsg errorMsg) {
        Assertions.assertEquals(ErrorMessages.messageForTags, errorMsg.getMessage());
        Assertions.assertEquals(ErrorMessages.codeUnprocessableEntity, errorMsg.getCode());

        List<String> expectedList = TagMessagesInvalidCredential.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (TagsErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct2");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }

    public void assertResultsForEditTags(TagsEdit tagsEdit) {
        Assertions.assertFalse(tagsEdit.getData().getId().isEmpty(), "is  is empty");
        Assertions.assertEquals(tagsEdit.getData().getPartnerId(), "13546");
        Assertions.assertEquals(tagsEdit.getData().getPriority(), "1");
        Assertions.assertFalse(tagsEdit.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertTrue(tagsEdit.getData().getIcon().contains("jpg"));
        Assertions.assertEquals(tagsEdit.getData().getVisible(), 0);
        Assertions.assertEquals(tagsEdit.getData().getStatus(), 0);
        Assertions.assertEquals(tagsEdit.getData().getShowIconOnProduct(), 0);
    }
}
