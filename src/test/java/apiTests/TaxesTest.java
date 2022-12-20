package apiTests;

import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.TaxesInfo;
import responses.Taxes;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TaxesTest {
    @Test
    @DisplayName("Check success partner taxes list")
    public void CheckTaxesListTest() {
        Taxes taxes = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV1.TAXES_LIST.getApi())
                .then().log().all()
                .extract().as(Taxes.class);
        Assertions.assertEquals("success", taxes.getResult());
        Assertions.assertEquals(200, taxes.getCode());
        Assertions.assertEquals("", taxes.getError());

        ArrayList<TaxesInfo> taxesInfo = taxes.getData();

        for (TaxesInfo data : taxesInfo) {
            Assertions.assertNotNull(data.getId(), "id is empty");
            Assertions.assertNotNull(data.getTitle(), "title is empty");
        }

    }
}
