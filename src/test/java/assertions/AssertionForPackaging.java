package assertions;

import Utils.ErrorMessages;
import dataProviders.PackagingProvider;
import enums.User;
import helpers.RequestPackaging;
import models.requests.packaging.PackagingCreate;
import models.requests.packaging.PackagingUpdate;
import org.junit.jupiter.api.Assertions;
import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import enums.PackagingMessages;
import enums.PackagingMessagesForInvalidCredential;

import java.util.ArrayList;
import java.util.List;

public class AssertionForPackaging {
    public void assertSpecialTypes(List<PackagingForStore.Data.SpecialType> list) {
        for (PackagingForStore.Data.SpecialType result : list) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.type.isEmpty(), "type is empty");
            Assertions.assertFalse(result.isSpecial.isEmpty(), "is_special is empty");
            Assertions.assertFalse(result.canMix.isEmpty(), "can_mix is empty");
            Assertions.assertFalse(result.forShipping.isEmpty(), "for_shipping is empty");
            Assertions.assertFalse(result.forPack.isEmpty(), "for_pack is empty");
            Assertions.assertFalse(result.forProduct.isEmpty(), "for_product is empty");
        }
    }

    public void assertBoxes(List<PackagingForStore.Data.Box> list) {
        for (PackagingForStore.Data.Box result : list) {
            Assertions.assertFalse(result.store_id.isEmpty(), "store_id is empty");
            Assertions.assertFalse(result.name.isEmpty(), "name is empty");
            Assertions.assertTrue(result.length>0, "length less than 0");
            Assertions.assertTrue(result.width>0, "width less than 0");
            Assertions.assertTrue(result.height>0, "height less than 0");
            Assertions.assertTrue(result.weight>0, "weight less than 0");
            Assertions.assertTrue(result.freeVolumeReserve>0, "free_volume_reserve less than 0");
            Assertions.assertFalse(result.specialEntityTypeId.isEmpty(), "special_entity_type_id is empty");
            Assertions.assertFalse(result.storeId.isEmpty(), "storeId is empty");
        }
    }
    public void assertGeneratedBox(PackagingForStore createPacking) {
        PackagingCreate.Box generatedBox = PackagingProvider.createPack(User.EMAIL_INFO, RequestPackaging.randomBoxName, RequestPackaging.randomPackName,
                RequestPackaging.randomNumber, RequestPackaging.randomUpc).getBoxes().get(0);
        PackagingForStore.Data.Box responseBox = createPacking.getData().getBoxes().get(0);
        Assertions.assertEquals(generatedBox.getName(), responseBox.getName(), "Box name does not match the expected value");
        Assertions.assertEquals(generatedBox.getLength(), responseBox.getLength(), "Length does not match the expected value");
        Assertions.assertEquals(generatedBox.getWidth(), responseBox.getWidth(), "Width does not match the expected value");
        Assertions.assertEquals(generatedBox.getHeight(), responseBox.getHeight(), "Height does not match the expected value");
        Assertions.assertEquals(generatedBox.getWeight(), responseBox.getWeight(), "Weight does not match the expected value");
        Assertions.assertEquals(generatedBox.getFreeVolumeReserve(), responseBox.getFreeVolumeReserve(), "FreeVolumeReserve does not match the expected value");
    }
    public void assertGeneratedBoxUpd(PackagingForStore createPacking) {
        PackagingUpdate.Box generatedBox = PackagingProvider.updatePacking(User.EMAIL_INFO, RequestPackaging.randomBoxNameUpd, RequestPackaging.randomPackNameUpd,
                RequestPackaging.randomNumberUpd, RequestPackaging.randomUpcUpd).getBoxes().get(0);
        PackagingForStore.Data.Box responseBox = createPacking.getData().getBoxes().get(0);
        Assertions.assertEquals(generatedBox.getName(), responseBox.getName(), "Box name does not match the expected value");
        Assertions.assertEquals(generatedBox.getLength(), responseBox.getLength(), "Length does not match the expected value");
        Assertions.assertEquals(generatedBox.getWidth(), responseBox.getWidth(), "Width does not match the expected value");
        Assertions.assertEquals(generatedBox.getHeight(), responseBox.getHeight(), "Height does not match the expected value");
        Assertions.assertEquals(generatedBox.getWeight(), responseBox.getWeight(), "Weight does not match the expected value");
        Assertions.assertEquals(generatedBox.getFreeVolumeReserve(), responseBox.getFreeVolumeReserve(), "FreeVolumeReserve does not match the expected value");
    }
    public void assertGeneratedPackUpd(PackagingForStore createPacking) {
        PackagingUpdate.Pack generatedPack = PackagingProvider.updatePacking(User.EMAIL_INFO, RequestPackaging.randomBoxNameUpd, RequestPackaging.randomPackNameUpd,
                RequestPackaging.randomNumberUpd, RequestPackaging.randomUpcUpd).getPacks().get(0);
        PackagingForStore.Data.Box responsePack = createPacking.getData().getBoxes().get(0);
        Assertions.assertEquals(generatedPack.getName(), responsePack.getName(), "Box name does not match the expected value");
//        Assertions.assertEquals(generatedPack.getPrice(), responsePack.getPrice(), "Price does not match the expected value");
//        Assertions.assertEquals(generatedPack.getFreeCount(), responsePack.getFreeCount(), "FreeCount does not match the expected value");
//        Assertions.assertEquals(generatedPack.getUpc(), responsePack.getUpc(), "Upc does not match the expected value");
    }
    public void assertGeneratedPack(PackagingForStore createPacking) {
        PackagingCreate.Pack generatedPack = PackagingProvider.createPack(User.EMAIL_INFO, RequestPackaging.randomBoxName, RequestPackaging.randomPackName,
                RequestPackaging.randomNumber, RequestPackaging.randomUpc).getPacks().get(0);
        PackagingForStore.Data.Pack responseBox = createPacking.getData().getPacks().get(0);
        Assertions.assertEquals(generatedPack.getName(), responseBox.getName(), "Pack name does not match the expected value");
        Assertions.assertEquals(generatedPack.getPrice(), responseBox.getPrice(), "Price does not match the expected value");
        Assertions.assertEquals(generatedPack.getFreeCount(), responseBox.getFreeCount(), "FreeCount does not match the expected value");
        Assertions.assertEquals(generatedPack.getUpc(), responseBox.getUpc(), "Upc does not match the expected value");
    }

    public void assertPacks(List<PackagingForStore.Data.Pack> list) {
        for (PackagingForStore.Data.Pack result : list) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.name.isEmpty(), "name is empty");
            Assertions.assertFalse(result.price.isEmpty(), "price is empty");
            Assertions.assertTrue(result.freeCount>0, "freeCount less than 0");
            Assertions.assertFalse(result.upc.isEmpty(), "upc is empty");
            Assertions.assertFalse(result.specialEntityTypeId.isEmpty(), "special_entity_type_id is empty");
            Assertions.assertFalse(result.storeId.isEmpty(), "storeId is empty");
        }
    }
    public void assertErrorMessages(PackagingErrorMsg errorMsg) {
        Assertions.assertEquals(ErrorMessages.messageForPack, errorMsg.getMessage());
        Assertions.assertEquals(ErrorMessages.codeUnprocessableEntity, errorMsg.getCode());

        List<String> expectedList = PackagingMessages.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (PackagingErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }

    public void assertErrorMessagesInvalidCredential(PackagingErrorMsg errorMsg) {
        Assertions.assertEquals(ErrorMessages.messageForPackInvalidCred, errorMsg.getMessage());
        Assertions.assertEquals(ErrorMessages.codeUnprocessableEntity, errorMsg.getCode());

        List<String> expectedList = PackagingMessagesForInvalidCredential.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (PackagingErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }
}
