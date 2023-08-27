package apiTests;

import assertions.AssertionForTaxes;
import httpRequest.RequestTaxes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.Taxes.SuccessCreateTax;
import responses.Taxes.Taxes;
import storage.ApiV1;

public class TaxesTest {
    AssertionForTaxes assertionForTaxes = new AssertionForTaxes();
    RequestTaxes requestTaxes = new RequestTaxes();
    @Test
    @DisplayName("Check create tax")
    public void CreateTax() {
        SuccessCreateTax successCreateTax = requestTaxes.requestCreateTax(ApiV1.STAGE.getApi(), ApiV1.TAX_CREATE.getApi());
        assertionForTaxes.assertTaxes(successCreateTax);
    }
    @Test
    @DisplayName("Check success partner taxes list")
    public void CheckTaxesListTest() {
        Taxes taxes = requestTaxes.requestTaxList(ApiV1.STAGE.getApi(), ApiV1.TAXES_LIST.getApi());
       assertionForTaxes.assertTaxesList(taxes);
        assertionForTaxes.assertTaxesInfo(taxes.getData());
    }
}
