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
import storage.APIV2;
import storage.USER;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PartnerStoresTest{
    UserInfoProvider userInfoProvider = new UserInfoProvider();
    Gson gson = new Gson();
    @Test
    @DisplayName("Check partner stores list")
    public void storesListTest(){


        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());

        SuccessLogin successLogin = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(userInfoProvider.getUser(USER.EMAIL_INFO)))
                .post(APIV2.STAGE.getApi() + APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);


        PartnerStores partnerStores = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + successLogin.getData().getToken()))
                .get(APIV2.STAGE.getApi() + APIV2.STORES_LIST.getApi())
                .then().log().all()
                .extract().as(PartnerStores.class);

        Assertions.assertEquals("success", partnerStores.getResult(), "Request is failed");
        Assertions.assertTrue(partnerStores.getError().isEmpty(),"Error message ");

        for (Store store: partnerStores.getData()) {
            try{
                int id = Integer.parseInt(store.getId());
            }
            catch (NumberFormatException ex){
                Assertions.fail("Incorrect order_id: " + store.getId());
            }
            Assertions.assertFalse(store.getTitle().isEmpty(),"Store name is empty, store_id: " + store.getId());
            Assertions.assertFalse(store.getAddress().getFirstLine().isEmpty(),"Store address is empty, store_id: " + store.getId());
            Assertions.assertFalse(store.getAddress().getLocation().getLat().isEmpty(),"Store address lat is empty, store_id: " + store.getId());
            Assertions.assertFalse(store.getAddress().getLocation().getLng().isEmpty(),"Store address lng is empty, store_id: " + store.getId());
        }
    }
}