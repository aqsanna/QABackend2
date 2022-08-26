import Utile.StoreObject;
import com.google.gson.Gson;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.AuthInfo;
import responses.userLogin.PartnerStores;
import responses.userLogin.SuccessLogin;
import storage.APIV2;
import storage.USER;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PartnerStoresTest{
    @Test
    @DisplayName("Check partner stores list")
    public void getStoresList(){

        Gson gson = new Gson();

        AuthInfo authInfo = new AuthInfo(
                new AuthInfo.Params(
                        new AuthInfo.Params.App()
                                .withBundleId(USER.BUNDLE_ID.getUserData())
                                .withVersion(USER.APP_VERSION.getUserData())
                        , USER.EMAIL.getUserData()
                        , USER.PASSWORD.getUserData(),
                        new AuthInfo.Params.Device()
                                .withVersion(USER.DEVICE_VERSION.getUserData())
                                .withOs(USER.OS.getUserData())
                                .withPushToken(USER.PUSH_TOKEN.getUserData()),
                        USER.APPLICATION_KEY.getUserData()));

        SuccessLogin successLogin = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(authInfo))
                .post(APIV2.STAGE.getApi() + APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

        PartnerStores partnerStores = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + successLogin.getData().getToken()))
                .get(APIV2.STAGE.getApi() + APIV2.STORES_LIST.getApi())
                .then().log().all()
                .extract().as(PartnerStores.class);

        ArrayList<StoreObject> storeList = partnerStores.getData();

        for (int i = 0; i < storeList.size(); i++) {
            boolean idIsInteger;
            try{
                int id = Integer.parseInt(storeList.get(i).getId());
                idIsInteger = true;
                // output = 25
            }
            catch (NumberFormatException ex){
                idIsInteger = false;
            }
            Assertions.assertTrue(idIsInteger);
            Assertions.assertFalse(storeList.get(i).getTitle().isEmpty());
            Assertions.assertFalse(storeList.get(i).getAddress().getFirstLine().isEmpty());
            Assertions.assertFalse(storeList.get(i).getAddress().getLocation().getLat().isEmpty());
            Assertions.assertFalse(storeList.get(i).getAddress().getLocation().getLng().isEmpty());
        }
        Assertions.assertEquals("success", partnerStores.getResult());
        Assertions.assertTrue(partnerStores.getError().isEmpty());
    }
}
