package apiTests;

import assertions.AssertionForMessages;
import assertions.AssertionForModificationItems;
import helpers.RequestModificationItems;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.tags.TagsErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import models.responses.modificationItems.SuccessCreateModificationItems;
import enums.ApiV1;

public class ModificationItemsTest {

    RequestModificationItems requestModificationItems = new RequestModificationItems();
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    AssertionForModificationItems assertionForModificationItems = new AssertionForModificationItems();

    @Test
    @DisplayName("Check create modification item")
    public void CreateModificationItemsRegular(){
        SuccessCreateModificationItems createModificationItems = requestModificationItems.requestPost(ApiV1.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(createModificationItems.getMessage(), createModificationItems.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItem(createModificationItems);

    }
    @Test
    @DisplayName("Check create modification item by text")
    public void CreateModificationItemsText(){
        SuccessCreateModificationItems createModificationItemsText = requestModificationItems.requestPostText(ApiV1.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(createModificationItemsText.getMessage(), createModificationItemsText.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItemText(createModificationItemsText);
    }

    @Test
    @DisplayName("Check create tags with invalid credential")
    public void CreateModificationItemInvalidCredential() {
        ModificationItemErrorMsg errorMsg = requestModificationItems.requestPutErrorMsgInvalidCredential(ApiV1.MODIFICATIONITEM.getApi());
        assertionForModificationItems.assertResultsForInvalidErrorMsgModificationItem(errorMsg);
    }
}
