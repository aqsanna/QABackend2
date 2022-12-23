package apiTests;

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
import responses.userLogin.SuccessLogin;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TaxesTest {
    Gson gson = new Gson();
    @Test
    @DisplayName("Check create product")
    public void CreateTax(){
        SuccessCreateTax successCreateTax = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(UserInfoProvider.getUser(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAX_CREATE.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTax.class);

        Assertions.assertEquals("success", successCreateTax.getResult());
        Assertions.assertEquals("save-tax63a58f9e63ef6", successCreateTax.getSequence());
        Assertions.assertEquals("", successCreateTax.getMessage());
        Assertions.assertEquals("", successCreateTax.getError());
    }


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
