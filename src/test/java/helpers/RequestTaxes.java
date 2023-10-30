package helpers;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.taxes.SuccessCreateTax;
import models.responses.taxes.Taxes;
import dataProviders.TaxesInfoProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestTaxes extends AbstractRequest {
    public SuccessCreateTax requestCreateTax (String url){
        return baseAuthorizedRequest()
                .body(TaxesInfoProvider.getTaxes(User.EMAIL_INFO))
                .post( url)
                .then()
                .extract().as(SuccessCreateTax.class);
    }
    public Taxes requestTaxList(String url){
        return baseAuthorizedRequest()
                .get(url)
                .then()
                .extract().as(Taxes.class);
    }
}
