package assertions;

import org.junit.jupiter.api.Assertions;
import responses.modificationItems.SuccessCreateModificationItems;
import responses.tags.SuccessCreateTags;

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
        Assertions.assertTrue(createModificationItem.getData().getIsInstock()>0, "is_instock more than 0");
        Assertions.assertTrue(createModificationItem.getData().getIsMultiline()>0, "is_multiline more than 0");
    }
}
