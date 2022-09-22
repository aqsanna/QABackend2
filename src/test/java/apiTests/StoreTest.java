package apiTests;

import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.StoreInfo;
import responses.Store;
import steps.data.users.UserInfoProvider;
import storage.APIV1;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StoreTest {
    @Test
    @DisplayName("Check success partner store list")
    public void StoreListTest() {
        Store store = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(APIV1.STAGE.getApi() + APIV1.STORE.getApi())
                .then().log().all()
                .extract().as(Store.class);

        Assertions.assertEquals("success", store.getResults());
        Assertions.assertEquals("", store.getError());
        Assertions.assertEquals(200, store.getCode());

        ArrayList<StoreInfo> storeInfo = store.getData();
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
