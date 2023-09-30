package apiTests;

import assertions.AssertionForMessages;
import assertions.AssertionForModificationItems;
import httpRequest.RequestModificationItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.modificationItems.SuccessCreateModificationItems;
import storage.ApiV1;

public class ModificationItemsTest {

    RequestModificationItems requestModificationItems = new RequestModificationItems();
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    AssertionForModificationItems assertionForModificationItems = new AssertionForModificationItems();

    @Test
    @DisplayName("Check create modification item")
    public void CreateModificationItemsRegular(){
        SuccessCreateModificationItems createModificationItems = requestModificationItems.requestPost(ApiV1.STAGE.getApi(), ApiV1.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(createModificationItems.getMessage(), createModificationItems.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItem(createModificationItems);

    }
    @Test
    @DisplayName("Check create modification item by text")
    public void CreateModificationItemsText(){
        SuccessCreateModificationItems createModificationItemsText = requestModificationItems.requestPostText(ApiV1.STAGE.getApi(), ApiV1.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(createModificationItemsText.getMessage(), createModificationItemsText.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItemText(createModificationItemsText);
    }
}
