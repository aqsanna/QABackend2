package apiTests;
import assertions.AssertionForMessages;
import assertions.AssertionForPackaging;
import com.google.gson.annotations.SerializedName;
import helpers.RequestPackaging;
import org.junit.jupiter.api.*;
import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import enums.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackagingTest {
    AssertionForPackaging assertionForPackaging = new AssertionForPackaging();
    RequestPackaging requestPackaging = new RequestPackaging();
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    @Test
    @Order(1)
    @SerializedName("Check create Packing - LE-T658-3-4-5-6")
    public void addPackaging() {

        PackagingForStore createPacking = requestPackaging.requestCreate(ApiV1.STAGE.getApi(),  ApiV2.PACKAGING.getApi());
        assertionForMessages.assertRequestMessageAndCode(createPacking.getMessage(), createPacking.getCode());
        Assertions.assertTrue(createPacking.getData().pickupByDriver);
        Assertions.assertTrue(createPacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(createPacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(createPacking.getData().getPacks());
        assertionForPackaging.assertBoxes(createPacking.getData().getBoxes());
    }
    @Test
    @Order(2)
    @SerializedName("Check update Packing - LE-T658-9")
    public void updatePackaging() {
        PackagingForStore updatePacking = requestPackaging.requestUpdate(ApiV1.STAGE.getApi(), ApiV2.PACKAGING.getApi());
        assertionForMessages.assertRequestMessageAndCode(updatePacking.getMessage(), updatePacking.getCode());
        Assertions.assertFalse(updatePacking.getData().pickupByDriver);
        Assertions.assertFalse(updatePacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(updatePacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(updatePacking.getData().getPacks());
        assertionForPackaging.assertBoxes(updatePacking.getData().getBoxes());
    }
    @Test
    @Order(3)
    @SerializedName("Check error messages Packing - LE-T658-7")
    public void errorMessagesPackaging(){
        PackagingErrorMsg errorMsg = requestPackaging.requestPutErrorMsg(ApiV1.STAGE.getApi(), ApiV2.PACKAGING.getApi());
        assertionForPackaging.assertErrorMessages(errorMsg);
    }
    @Test
    @Order(4)
    @SerializedName("Check invalid credential error messages Packing")
    public void errorMessagesPackagingForInvalidCredential(){
        PackagingErrorMsg errorMsg = requestPackaging.requestPutErrorMsgForInvalidCredential(ApiV1.STAGE.getApi(), ApiV2.PACKAGING.getApi());
        assertionForPackaging.assertErrorMessagesInvalidCredential(errorMsg);
    }

    @Test
    @SerializedName("Check delete Packing - LE-T658-8")
    public void deletePackaging(){
        PackagingForStore deletePacking =   requestPackaging.requestDel(ApiV1.STAGE.getApi(), ApiV2.PACKAGING.getApi());
        assertionForMessages.assertRequestMessageAndCode(deletePacking.getMessage(), deletePacking.getCode());
        Assertions.assertFalse(deletePacking.getData().pickupByDriver);
        Assertions.assertFalse(deletePacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(deletePacking.getData().getSpecialTypes());
        ArrayList<PackagingForStore.Data.Box> deleteBoxList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deleteBoxList.isEmpty());
        ArrayList<PackagingForStore.Data.Box> deletePackList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deletePackList.isEmpty());
    }
}

