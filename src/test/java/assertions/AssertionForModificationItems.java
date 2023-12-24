package assertions;

import Utils.ErrorMessages;
import dataProviders.ModificationItemsProvider;
import enums.ModificationItemMessagesInvalidCredential;
import enums.TagMessagesInvalidCredential;
import enums.User;
import helpers.RequestModificationItems;
import models.requests.modifications.CreateModificationItems;
import models.requests.modifications.CreateModificationItemsImage;
import models.requests.modifications.CreateModificationItemsText;
import models.requests.modifications.UpdateModificationItems;
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
    }

    public void successCreateModificationRegularItem(SuccessCreateModificationItems createModificationItem) {
        CreateModificationItems generateInfo = ModificationItemsProvider.createModification(User.EMAIL_INFO,RequestModificationItems.randomBool, RequestModificationItems.randomText,
                RequestModificationItems.randomPrice, RequestModificationItems.randomUpc);
        Assertions.assertEquals(generateInfo.getPriceChange(),createModificationItem.getData().getPriceChange());
        Assertions.assertEquals(generateInfo.getUpc(), createModificationItem.getData().getUpc());
        Assertions.assertEquals(generateInfo.getTitle(), createModificationItem.getData().getTitle());
        Assertions.assertEquals(generateInfo.getDescription(), createModificationItem.getData().getDescription());
        Assertions.assertEquals(generateInfo.getType(), createModificationItem.getData().getType());
        Assertions.assertEquals(generateInfo.getImage(), createModificationItem.getData().getImage());
        Assertions.assertEquals(generateInfo.getIsInstock(), createModificationItem.getData().getIsInstock());
        Assertions.assertEquals(generateInfo.getIsMultiline(), createModificationItem.getData().getIsMultiline());

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
        Assertions.assertFalse(createModificationItem.getData().getMinLength().isEmpty(), "minLength  is empty");
        Assertions.assertTrue(createModificationItem.getData().getMaxLength()>0, "maxLength more than 0");
    }

    public void successCreateModificationTextItem(SuccessCreateModificationItems createModificationItem) {
        CreateModificationItemsText generateInfo = ModificationItemsProvider.createModificationText(User.EMAIL_INFO, RequestModificationItems.randomBool,
                RequestModificationItems.randomText, RequestModificationItems.randomDescription, RequestModificationItems.randomMinLength, RequestModificationItems.randomMaxLength,
                RequestModificationItems.randomPrice,  RequestModificationItems.randomUpc);
        Assertions.assertEquals(generateInfo.getPriceChange(),createModificationItem.getData().getPriceChange());
        Assertions.assertEquals(generateInfo.getUpc(), createModificationItem.getData().getUpc());
        Assertions.assertEquals(generateInfo.getTitle(), createModificationItem.getData().getTitle());
        Assertions.assertEquals(generateInfo.getDescription(), createModificationItem.getData().getDescription());
        Assertions.assertEquals(generateInfo.getType(), createModificationItem.getData().getType());
        Assertions.assertEquals(generateInfo.getImage(), createModificationItem.getData().getImage());
        Assertions.assertEquals(generateInfo.getIsInstock(), createModificationItem.getData().getIsInstock());
        Assertions.assertEquals(generateInfo.getIsMultiline(), createModificationItem.getData().getIsMultiline());
        Assertions.assertEquals(generateInfo.getMinLength(), createModificationItem.getData().getMinLength());
        Assertions.assertEquals(generateInfo.getMaxLength(), createModificationItem.getData().getMaxLength());

    }
    public void assertResultsForSuccessCreateModificationItemImage(SuccessCreateModificationItems createModificationItem) {
        Assertions.assertFalse(createModificationItem.getData().getId().isEmpty(), "id  is empty");
        Assertions.assertFalse(createModificationItem.getData().getStoreId().isEmpty(), "store_id  is empty");
        Assertions.assertTrue(createModificationItem.getData().getPriceChange()> 0, "price more than 0");
        Assertions.assertFalse(createModificationItem.getData().getUpc().isEmpty(), "upc  is empty");
        Assertions.assertFalse(createModificationItem.getData().getType().isEmpty(), "type is empty");
        Assertions.assertFalse(createModificationItem.getData().getImage().isEmpty(), "image is empty");
        Assertions.assertFalse(createModificationItem.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertFalse(createModificationItem.getData().getDescription().isEmpty(), "description  is empty");
    }
    public void successCreateModificationImageItem(SuccessCreateModificationItems createModificationItem) {
        CreateModificationItemsImage generateInfo = ModificationItemsProvider.createModificationImage(User.EMAIL_INFO, RequestModificationItems.randomBool,
                RequestModificationItems.randomText, RequestModificationItems.randomDescription,
                RequestModificationItems.randomPrice,  RequestModificationItems.randomUpc);
        Assertions.assertEquals(generateInfo.getPriceChange(),createModificationItem.getData().getPriceChange());
        Assertions.assertEquals(generateInfo.getUpc(), createModificationItem.getData().getUpc());
        Assertions.assertEquals(generateInfo.getTitle(), createModificationItem.getData().getTitle());
        Assertions.assertEquals(generateInfo.getDescription(), createModificationItem.getData().getDescription());
        Assertions.assertEquals(generateInfo.getType(), createModificationItem.getData().getType());
        Assertions.assertEquals(generateInfo.getImage(), createModificationItem.getData().getImage());
        Assertions.assertEquals(generateInfo.getIsInstock(), createModificationItem.getData().getIsInstock());
        Assertions.assertEquals(generateInfo.getIsMultiline(), createModificationItem.getData().getIsMultiline());
    }

    public void assertResultsForSuccessUpdateModificationItem(SuccessCreateModificationItems updateModificationItem) {
        Assertions.assertFalse(updateModificationItem.getData().getId().isEmpty(), "id  is empty");
        Assertions.assertFalse(updateModificationItem.getData().getStoreId().isEmpty(), "store_id  is empty");
        Assertions.assertTrue(updateModificationItem.getData().getPriceChange()> 0, "price more than 0");
        Assertions.assertFalse(updateModificationItem.getData().getUpc().isEmpty(), "upc  is empty");
        Assertions.assertFalse(updateModificationItem.getData().getType().isEmpty(), "type is empty");
        Assertions.assertFalse(updateModificationItem.getData().getImage().isEmpty(), "image is empty");
        Assertions.assertFalse(updateModificationItem.getData().getTitle().isEmpty(), "title  is empty");
        Assertions.assertFalse(updateModificationItem.getData().getDescription().isEmpty(), "description  is empty");
    }

    public void successUpdateModificationItem(SuccessCreateModificationItems updateModificationItem) {
        UpdateModificationItems generateInfo = ModificationItemsProvider.updateModification(User.EMAIL_INFO, RequestModificationItems.randomBool,
                RequestModificationItems.randomText, RequestModificationItems.randomDescription,RequestModificationItems.randomMinLength,RequestModificationItems.randomMaxLength,
                RequestModificationItems.randomPrice,  RequestModificationItems.randomUpc);
        Assertions.assertEquals(generateInfo.getPriceChange(),updateModificationItem.getData().getPriceChange());
        Assertions.assertEquals(generateInfo.getUpc(), updateModificationItem.getData().getUpc());
        Assertions.assertEquals(generateInfo.getTitle(), updateModificationItem.getData().getTitle());
        Assertions.assertEquals(generateInfo.getDescription(), updateModificationItem.getData().getDescription());
        Assertions.assertEquals(generateInfo.getType(), updateModificationItem.getData().getType());
        Assertions.assertEquals(generateInfo.getImage(), updateModificationItem.getData().getImage());
        Assertions.assertEquals(generateInfo.getIsInstock(), updateModificationItem.getData().getIsInstock());
        Assertions.assertEquals(generateInfo.getIsMultiline(), updateModificationItem.getData().getIsMultiline());
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
