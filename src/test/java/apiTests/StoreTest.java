package apiTests;

import assertions.AssertionForStore;
import httpRequest.RequestStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.Store;
import storage.ApiV1;

public class StoreTest {
    RequestStore requestStore = new RequestStore();
    AssertionForStore assertionForStore = new AssertionForStore();
    @Test
    @DisplayName("Check success partner store list")
    public void StoreListTest() {
        Store store = requestStore.requestStoreList(ApiV1.STAGE.getApi() , ApiV1.STORE.getApi());
        assertionForStore.assertStoreList(store);
        assertionForStore.assertStoreInfoData(store.getData());
    }
}
