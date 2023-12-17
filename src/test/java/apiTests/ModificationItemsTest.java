package apiTests;

import assertions.AssertionForMessages;
import assertions.AssertionForModificationItems;
import enums.ApiV2;
import helpers.RequestModificationItems;
import models.requests.modifications.UpdateModificationItems;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.modificationItems.ModificationItemsList;
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
        SuccessCreateModificationItems createModificationItems = requestModificationItems.requestPost(ApiV2.MODIFICATIONITEM.getApi());
        ModificationItemsList modificationItemsList = requestModificationItems.modificationItemsList(ApiV2.MODIFICATIONITEM.getApi());
        Integer count = modificationItemsList.getData().get_meta().totalCount;
        assertionForMessages.assertRequestMessageAndCode(createModificationItems.getMessage(), createModificationItems.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItem(createModificationItems);
        assertionForModificationItems.successCreateModificationRegularItem(createModificationItems);
        Assertions.assertEquals(modificationItemsList.getData().get_meta().totalCount, count);

    }
    @Test
    @Order(2)
    @DisplayName("Check create modification item by text")
    public void CreateModificationItemsText(){
        SuccessCreateModificationItems createModificationItemsText = requestModificationItems.requestPostText(ApiV2.MODIFICATIONITEM.getApi());
        ModificationItemsList modificationItemsList = requestModificationItems.modificationItemsList(ApiV2.MODIFICATIONITEM.getApi());
        Integer count = modificationItemsList.getData().get_meta().totalCount;
        assertionForMessages.assertRequestMessageAndCode(createModificationItemsText.getMessage(), createModificationItemsText.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItemText(createModificationItemsText);
        assertionForModificationItems.successCreateModificationTextItem(createModificationItemsText);
        Assertions.assertEquals(modificationItemsList.getData().get_meta().totalCount, count);
    }
    @Test
    @Order(3)
    @DisplayName("Check create modification item by image")
    public void CreateModificationItemsImage(){
        SuccessCreateModificationItems createModificationItemsImage = requestModificationItems.requestPostImage(ApiV2.MODIFICATIONITEM.getApi());
        ModificationItemsList modificationItemsList = requestModificationItems.modificationItemsList(ApiV2.MODIFICATIONITEM.getApi());
        Integer count = modificationItemsList.getData().get_meta().totalCount;
        assertionForMessages.assertRequestMessageAndCode(createModificationItemsImage.getMessage(), createModificationItemsImage.getCode());
        assertionForModificationItems.assertResultsForSuccessCreateModificationItemImage(createModificationItemsImage);
        assertionForModificationItems.successCreateModificationImageItem(createModificationItemsImage);
        Assertions.assertEquals(modificationItemsList.getData().get_meta().totalCount, count);
    }

    @Test
    @Order(4)
    @DisplayName("Check update modification item by image")
    public void UpdateModificationItemsImage(){
        SuccessCreateModificationItems updateModificationItemsImage = requestModificationItems.updateItems(ApiV2.MODIFICATIONITEM.getApi());
        assertionForMessages.assertRequestMessageAndCode(updateModificationItemsImage.getMessage(), updateModificationItemsImage.getCode());
        assertionForModificationItems.assertResultsForSuccessUpdateModificationItem(updateModificationItemsImage);
        assertionForModificationItems.successUpdateModificationItem(updateModificationItemsImage);

    }
    @Test
    @Order(5)
    @DisplayName("Check create tags with invalid credential")
    public void CreateModificationItemInvalidCredential() {
        ModificationItemErrorMsg errorMsg = requestModificationItems.requestPutErrorMsgInvalidCredential(ApiV2.MODIFICATIONITEM.getApi());
        assertionForModificationItems.assertResultsForInvalidErrorMsgModificationItem(errorMsg);
    }
}
