package apiTests;
import assertions.AssertionForPackaging;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import httpRequest.RequestPackaging;
import org.junit.jupiter.api.*;
import responses.packaging.PackagingErrorMsg;
import responses.packaging.PackagingForStore;
import storage.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackagingTest {
    Gson gson = new Gson();
    AssertionForPackaging assertionForPackaging = new AssertionForPackaging();
    RequestPackaging requestPackaging = new RequestPackaging();
    @Test
    @Order(1)
    @SerializedName("Check create Packing")
    public void addPackaging() {

        PackagingForStore createPacking = requestPackaging.requestCreate(ApiV1.STAGE.getApi(),  ApiV2.PACKAGING.getApi());
        Assertions.assertEquals("Ok", createPacking.getMessage());
        Assertions.assertEquals("OK", createPacking.getCode());
        Assertions.assertTrue(createPacking.getData().pickupByDriver);
        Assertions.assertTrue(createPacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(createPacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(createPacking.getData().getPacks());
        assertionForPackaging.assertBoxes(createPacking.getData().getBoxes());
    }
    @Test
    @Order(2)
    @SerializedName("Check update Packing")
    public void updatePackaging() {
        PackagingForStore updatePacking = requestPackaging.requestUpdate(ApiV1.STAGE.getApi(), ApiV2.PACKAGING.getApi());
        Assertions.assertEquals("Ok", updatePacking.getMessage());
        Assertions.assertEquals("OK", updatePacking.getCode());
        Assertions.assertFalse(updatePacking.getData().pickupByDriver);
        Assertions.assertFalse(updatePacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(updatePacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(updatePacking.getData().getPacks());
        assertionForPackaging.assertBoxes(updatePacking.getData().getBoxes());
    }
    @Test
    @Order(3)
    @SerializedName("Check error messages Packing")
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
    @SerializedName("Check delete Packing")
    public void deletePackaging(){
        PackagingForStore deletePacking =   requestPackaging.requestDel(ApiV1.STAGE.getApi(), ApiV2.PACKAGING.getApi());
        Assertions.assertEquals("Ok", deletePacking.getMessage());
        Assertions.assertEquals("OK", deletePacking.getCode());
        Assertions.assertFalse(deletePacking.getData().pickupByDriver);
        Assertions.assertFalse(deletePacking.getData().advancedCollectingFlow);
        assertionForPackaging.assertSpecialTypes(deletePacking.getData().getSpecialTypes());
        ArrayList<PackagingForStore.Data.Box> deleteBoxList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deleteBoxList.isEmpty());
        ArrayList<PackagingForStore.Data.Box> deletePackList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deletePackList.isEmpty());
    }
}

