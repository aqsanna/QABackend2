package httpRequest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import responses.Taxes.SuccessCreateTax;
import responses.Taxes.Taxes;
import steps.data.users.TaxesInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.User;

import static io.restassured.RestAssured.given;

public class RequestTaxes {
    public SuccessCreateTax requestCreateTax (String path, String url){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .body(TaxesInfoProvider.getTaxes(User.EMAIL_INFO))
                .post(path + url)
                .then()
                .extract().as(SuccessCreateTax.class);
    }
    public Taxes requestTaxList(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then()
                .extract().as(Taxes.class);
    }
}
