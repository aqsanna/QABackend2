package assertions;

import Utils.ErrorMessages;
import enums.ModificationItemMessagesInvalidCredential;
import enums.TagMessagesInvalidCredential;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.tags.TagsErrorMsg;
import org.junit.jupiter.api.Assertions;
import models.responses.modificationItems.SuccessCreateModificationItems;

import java.util.ArrayList;
import java.util.List;


public class AssertionForModificationItems {

    public void assertResultsForSuccessCreateModificationItem(SuccessCreateModificationItems createModificationItem) {
        Assertions.assertFalse(createModificationItem.getData().getId().isEmpty(), "id  is empty");
        Assertions.assertFalse(createModificationItem.getData().getStoreId().isEmpty(), "store_id  is empty");
        Assertions.assertTrue(createModificationItem.getData().getPriceChange()> 0, "price more than 0");
        Assertions.assertFalse(createModificationItem.getData().getUpc().isEmpty(), "upc  is empty");
        Assertions.assertFalse(createModificationItem.getData().getType().isEmpty(), "type is empty");
        Assertions.assertFalse(createModificationItem.getData().getImage().isEmpty(), "image is empty");
        Assertions.assertFalse(createModificationItem.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertFalse(createModificationItem.getData().getDescription().isEmpty(), "description  is empty");
        Assertions.assertTrue(createModificationItem.getData().getIsInstock()>0, "is_instock more than 0");
        Assertions.assertTrue(createModificationItem.getData().getIsMultiline()>0, "is_multiline more than 0");
    }
    public void assertResultsForSuccessCreateModificationItemText(SuccessCreateModificationItems createModificationItem) {
        Assertions.assertFalse(createModificationItem.getData().getId().isEmpty(), "id  is empty");
        Assertions.assertFalse(createModificationItem.getData().getStoreId().isEmpty(), "store_id  is empty");
        Assertions.assertTrue(createModificationItem.getData().getPriceChange()> 0, "price more than 0");
        Assertions.assertFalse(createModificationItem.getData().getUpc().isEmpty(), "upc  is empty");
        Assertions.assertFalse(createModificationItem.getData().getType().isEmpty(), "type is empty");
        Assertions.assertFalse(createModificationItem.getData().getImage().isEmpty(), "image is empty");
        Assertions.assertFalse(createModificationItem.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertFalse(createModificationItem.getData().getDescription().isEmpty(), "description  is empty");
        Assertions.assertTrue(createModificationItem.getData().getIsInstock()>0, "is_instock more than 0");
        Assertions.assertTrue(createModificationItem.getData().getIsMultiline()>0, "is_multiline more than 0");
        Assertions.assertFalse(createModificationItem.getData().getMinLength().isEmpty(), "minLength  is empty");
        Assertions.assertTrue(createModificationItem.getData().getMaxLength()>0, "maxLength more than 0");
    }

    public void assertResultsForInvalidErrorMsgModificationItem(ModificationItemErrorMsg errorMsg) {
        Assertions.assertEquals(ErrorMessages.messageForModificationTitle, errorMsg.getMessage());
        Assertions.assertEquals(ErrorMessages.codeUnprocessableEntity, errorMsg.getCode());

        List<String> expectedList = ModificationItemMessagesInvalidCredential.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (ModificationItemErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct2");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }
}
