package assertions;

import Utils.ErrorMessages;
import org.junit.jupiter.api.Assertions;
import models.requests.tax.TaxesInfo;
import models.responses.taxes.SuccessCreateTax;
import models.responses.taxes.Taxes;
import enums.User;
import java.util.ArrayList;

public class AssertionForTaxes {
    public void assertTaxes(SuccessCreateTax successCreateTax) {

        Assertions.assertEquals(1, successCreateTax.getResult());
        Assertions.assertEquals("save-tax63a58f9e63ef6", successCreateTax.getSequence());
        Assertions.assertEquals("", successCreateTax.getMessage());
        Assertions.assertEquals("", successCreateTax.getError());
        Assertions.assertNotNull(successCreateTax.getData().getResult().id, "Id is empty");
        Assertions.assertNotNull(successCreateTax.getData().getResult().type, "type is empty");
        Assertions.assertFalse(successCreateTax.getData().getResult().storeId.isEmpty(), "Store id is empty");
        Assertions.assertEquals(User.VALUE.getUserData(), successCreateTax.getData().getResult().value);
        Assertions.assertEquals(User.APPLY_TO_ALL_PRODUCTS.getUserData(), successCreateTax.getData().getResult().applyToAllProducts);
        Assertions.assertEquals(User.PER_UNIT.getUserData(), successCreateTax.getData().getResult().perUnit);
        Assertions.assertEquals(User.IS_CRV.getUserData(), successCreateTax.getData().getResult().isCrv);
        Assertions.assertFalse(successCreateTax.getData().getResult().title.isEmpty(), "Title is empty");
        Assertions.assertFalse(successCreateTax.getData().getResult().visibleTitle.isEmpty(), "Visible title is empty");
        Assertions.assertFalse(successCreateTax.getData().getResult().description.isEmpty(), "Description is empty");
    }
    public void assertTaxesList(Taxes taxes){
        Assertions.assertEquals(ErrorMessages.successMsg, taxes.getResult());
        Assertions.assertEquals(ErrorMessages.successCode, taxes.getCode());
        Assertions.assertEquals("", taxes.getError());
    }
    public void assertTaxesInfo(ArrayList<TaxesInfo> taxesInfo){
        for (TaxesInfo data : taxesInfo) {
            Assertions.assertNotNull(data.getId(), "id is empty");
            Assertions.assertNotNull(data.getTitle(), "title is empty");
        }
    }
}
