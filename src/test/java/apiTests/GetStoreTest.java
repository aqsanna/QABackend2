package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.GetStore;
import steps.data.users.UserInfoProvider;
import storage.APIV2;
import utils.StoreInfo;
import java.util.ArrayList;
public class GetStoreTest {
    @Test
    @DisplayName("Check success partner store list")
    public void getStoreTest() {
        GetStore getStore = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(APIV2.STAGE.getApi() + APIV2.STORE.getApi())
                .then().log().all()
                .extract().as(GetStore.class);

        Assertions.assertEquals("success", getStore.getResults());
        ArrayList<StoreInfo> storeInfo = getStore.getData();
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
