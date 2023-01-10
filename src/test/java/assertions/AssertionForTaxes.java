package assertions;

import org.junit.jupiter.api.Assertions;
import responses.Taxes.SuccessCreateTax;
import storage.User;

public class AssertionForTaxes {
    public void assertTaxes(SuccessCreateTax successCreateTax){

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
}
