package apiTests;

import assertions.AssertionForMessages;
import assertions.AssertionForModificationItems;
import helpers.RequestModificationItems;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.tags.TagsErrorMsg;
import org.junit.jupiter.api.*;
import models.responses.modificationItems.SuccessCreateModificationItems;
import enums.ApiV1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModificationItemsTest {

    RequestModificationItems requestModificationItems = new RequestModificationItems();
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    AssertionForModificationItems assertionForModificationItems = new AssertionForModificationItems();

    @Test
    @Order(1)
    @DisplayName("Check create modification item")
    public void CreateModificationItemsRegular(){
        SuccessCreateModificationItems createModificationItems = requestModificationItems.requestPost(ApiV1.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(createModificationItems.getMessage(), createModificationItems.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItem(createModificationItems);

    }
    @Test
    @Order(2)
    @DisplayName("Check create modification item by text")
    public void CreateModificationItemsText(){
        SuccessCreateModificationItems createModificationItemsText = requestModificationItems.requestPostText(ApiV1.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(createModificationItemsText.getMessage(), createModificationItemsText.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItemText(createModificationItemsText);
    }

    @Test
    @Order(3)
    @DisplayName("Check create tags with invalid credential")
    public void CreateModificationItemInvalidCredential() {
        ModificationItemErrorMsg errorMsg = requestModificationItems.requestPutErrorMsgInvalidCredential(ApiV1.MODIFICATIONITEM.getApi());
        assertionForModificationItems.assertResultsForInvalidErrorMsgModificationItem(errorMsg);
    }
}
