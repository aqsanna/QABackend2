package apiTests;

import assertions.AssertionForTaxes;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.TaxesInfo;
import responses.Taxes.SuccessCreateTax;
import responses.Taxes.Taxes;
import steps.data.users.TaxesInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TaxesTest {
    Gson gson = new Gson();
    AssertionForTaxes assertionForTaxes = new AssertionForTaxes();

    @Test
    @DisplayName("Check create product")
    public void CreateTax() {
        SuccessCreateTax successCreateTax = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TaxesInfoProvider.getTaxes(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAX_CREATE.getApi())
                .then()
                .extract().as(SuccessCreateTax.class);
        assertionForTaxes.assertTaxes(successCreateTax);

    }

    @Test
    @DisplayName("Check success partner taxes list")
    public void CheckTaxesListTest() {
        Taxes taxes = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV1.TAXES_LIST.getApi())
                .then()
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
