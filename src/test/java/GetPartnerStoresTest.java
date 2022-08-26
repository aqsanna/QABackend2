import Utile.StoreObject;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.userLogin.PartnerStores;
import storage.APIV2;

import java.util.ArrayList;

public class GetPartnerStoresTest extends AuthTest{
    @Test
    @DisplayName("Check partner stores list")
    public void getStoresList(){

        this.successLoginTest();
        PartnerStores partnerStores = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + this.successLogin.getData().getToken()))
                .get(APIV2.STAGE.getApi() + APIV2.STORES_LIST.getApi())
                .then().log().all()
                .extract().as(PartnerStores.class);

        Assertions.assertEquals("success", partnerStores.getResult());
        Assertions.assertTrue(partnerStores.getError().isEmpty());
    }
}
