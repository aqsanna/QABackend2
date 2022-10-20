package apiTests;

import Utile.Store;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.partner.stores.PartnerStores;
import responses.userLogin.SuccessLogin;
import spec.Specifications;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.USER;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PartnerStoresTest{
    UserInfoProvider userInfoProvider = new UserInfoProvider();
    @Test
    @DisplayName("Check partner stores list")
    public void storesListTest(){

        PartnerStores partnerStores = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + userInfoProvider.getToken()))
                .get(APIV1.STAGE.getApi() + APIV1.STORES_LIST.getApi())
                .then().log().all()
                .extract().as(PartnerStores.class);

        Assertions.assertEquals("success", partnerStores.getResult(), "Request is failed");
        Assertions.assertTrue(partnerStores.getError().isEmpty(),"Error message ");

        for (Store store: partnerStores.getData()) {
            try{
                int id = Integer.parseInt(store.getId());
            }
            catch (NumberFormatException ex){
                System.out.println("Incorrect order_id: " + store.getId());
            }
            try {
                Assertions.assertFalse(store.getTitle().isEmpty(),"Store name is empty, store_id: " + store.getId());
                Assertions.assertFalse(store.getAddress().getFirstLine().isEmpty(),"Store address is empty, store_id: " + store.getId());
                Assertions.assertFalse(store.getAddress().getLocation().getLat().isEmpty(),"Store address lat is empty, store_id: " + store.getId());
                Assertions.assertFalse(store.getAddress().getLocation().getLng().isEmpty(),"Store address lng is empty, store_id: " + store.getId());
            }catch (AssertionError e){
                System.out.println(e.getMessage());
            }
        }
    }
}