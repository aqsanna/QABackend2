package apiTests;

import assertions.AssertionForStore;
import helpers.RequestStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.responses.store1.Store;
import enums.ApiV1;

public class StoreTest {
    RequestStore requestStore = new RequestStore();
    AssertionForStore assertionForStore = new AssertionForStore();
    @Test
    @DisplayName("Check success partner store list")
    public void StoreListTest() {
        Store store = requestStore.requestStoreList(ApiV1.STORE.getApi());
        assertionForStore.assertStoreList(store);
        assertionForStore.assertStoreInfoData(store.getData());
    }
}
