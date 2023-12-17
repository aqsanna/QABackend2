package apiTests;
import assertions.AssertionForMessages;
import assertions.AssertionForPackaging;
import com.google.gson.annotations.SerializedName;
import helpers.RequestPackaging;
import org.junit.jupiter.api.*;
import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import enums.*;

import java.io.IOException;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackagingTest  {
    AssertionForPackaging assertionForPackaging = new AssertionForPackaging();
    RequestPackaging requestPackaging = new RequestPackaging();
    AssertionForMessages assertionForMessages = new AssertionForMessages();

    private PackagingForStore createPackaging() {
        return requestPackaging.requestCreate(ApiV2.PACKAGING.getApi());
    }
    public PackagingForStore UpdPackaging() {
        return requestPackaging.requestUpdate(ApiV2.PACKAGING.getApi());
    }
    @Test
    @Order(1)
    @SerializedName("Check create Packing - LE-T658-3-4-5-6")
    public void addPackaging() throws IOException {

        PackagingForStore createPacking = createPackaging();
        assertionForMessages.assertRequestMessageAndCode(createPacking.getMessage(), createPacking.getCode());
        Assertions.assertTrue(createPacking.getData().pickupByDriver);
        Assertions.assertTrue(createPacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(createPacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(createPacking.getData().getPacks());
        assertionForPackaging.assertBoxes(createPacking.getData().getBoxes());
        assertionForPackaging.assertGeneratedBox(createPacking);
        assertionForPackaging.assertGeneratedPack(createPacking);
    }

    @Test
    @Order(2)
    @SerializedName("Check update Packing - LE-T658-9")
    public void updatePackaging() throws IOException {
        PackagingForStore updatePacking = UpdPackaging();
        assertionForMessages.assertRequestMessageAndCode(updatePacking.getMessage(), updatePacking.getCode());
        Assertions.assertFalse(updatePacking.getData().pickupByDriver);
        Assertions.assertFalse(updatePacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(updatePacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(updatePacking.getData().getPacks());
        assertionForPackaging.assertBoxes(updatePacking.getData().getBoxes());
        assertionForPackaging.assertGeneratedPackUpd(updatePacking);
        assertionForPackaging.assertGeneratedBoxUpd(updatePacking);
    }
    @Test
    @Order(3)
    @SerializedName("Check error messages Packing - LE-T658-7")
    public void errorMessagesPackaging(){
        PackagingErrorMsg errorMsg = requestPackaging.requestPutErrorMsg(ApiV2.PACKAGING.getApi());
        assertionForPackaging.assertErrorMessages(errorMsg);
    }
    @Test
    @Order(4)
    @SerializedName("Check invalid credential error messages Packing")
    public void errorMessagesPackagingForInvalidCredential(){
        PackagingErrorMsg errorMsg = requestPackaging.requestPutErrorMsgForInvalidCredential(ApiV2.PACKAGING.getApi());
        assertionForPackaging.assertErrorMessagesInvalidCredential(errorMsg);
    }

    @Test
    @SerializedName("Check delete Packing - LE-T658-8")
    public void deletePackaging(){
        PackagingForStore deletePacking =   requestPackaging.requestDel(ApiV2.PACKAGING.getApi());
        assertionForMessages.assertRequestMessageAndCode(deletePacking.getMessage(), deletePacking.getCode());
        Assertions.assertFalse(deletePacking.getData().pickupByDriver);
        Assertions.assertFalse(deletePacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(deletePacking.getData().getSpecialTypes());
        List<PackagingForStore.Data.Box> deleteBoxList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deleteBoxList.isEmpty());
        List<PackagingForStore.Data.Box> deletePackList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deletePackList.isEmpty());
    }
}

