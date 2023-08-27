package assertions;

import Utils.ErrorMessages;
import org.junit.jupiter.api.Assertions;
import requests.StoreInfo;
import responses.Store;
import steps.data.users.UserInfoProvider;

import java.util.ArrayList;

public class AssertionForStore {
    public void assertStoreList( Store store ){
        Assertions.assertEquals(ErrorMessages.successMsg, store.getResult());
        Assertions.assertEquals("", store.getError());
        Assertions.assertEquals(ErrorMessages.successCode, store.getCode());
    }
    public void assertStoreInfoData( ArrayList<StoreInfo> storeInfo){
        for (StoreInfo data : storeInfo) {
            Assertions.assertFalse(data.title.isEmpty(), "title  is empty");
            Assertions.assertNotNull(data.address.first_line, "address is not find " + data.id);
            Assertions.assertFalse(data.address.location.lat.isEmpty(), "location lat is empty");
            Assertions.assertFalse(data.address.location.lng.isEmpty(), "location lng is empty");
            Assertions.assertNotNull(data.title, "title  is null");
            Assertions.assertTrue(UserInfoProvider.isNumber((data.id)), "id  contains char");
        }
    }
}
