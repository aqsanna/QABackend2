package assertions;

import org.junit.jupiter.api.Assertions;
import responses.packaging.PackagingErrorMsg;
import responses.packaging.PackagingForStore;
import storage.PackagingMessages;

import java.util.ArrayList;
import java.util.List;

public class AssertionForPackaging {
    public void assertSpecialTypes(ArrayList<PackagingForStore.Data.SpecialType> list) {
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

    public void assertBoxes(ArrayList<PackagingForStore.Data.Box> list) {
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

    public void assertPacks(ArrayList<PackagingForStore.Data.Pack> list) {
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
        String message ="Please fix the following errors: Box Name cannot be blank., Length cannot be blank., Width cannot be blank., " +
                "Height cannot be blank., Pack name cannot be blank., Price cannot be blank., Free pack quantity cannot be blank.";
        String code ="UNPROCESSABLE_ENTITY";

        Assertions.assertEquals(message, errorMsg.getMessage());
        Assertions.assertEquals(code, errorMsg.getCode());

        List<String> expectedList = PackagingMessages.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (PackagingErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }
}
