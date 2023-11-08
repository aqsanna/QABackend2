package dataProviders;

import Utils.RandomGenerateMethods;
import helpers.AbstractRequest;
import helpers.RequestProduct;
import models.requests.tax.TaxesCreateInfo;
import enums.User;

public class TaxesInfoProvider {
    public static TaxesCreateInfo getTaxes(User email) {
        return switch (email) {
            case EMAIL_INFO -> new TaxesCreateInfo(
                    User.SEQUENCE.getUserData(),
                    User.APPLICATIONKEY.getUserData(),
                    User.ACTION.getUserData(),
                    new TaxesCreateInfo.Params()
                            .withIsActive(User.IS_ACTIVE.getUserData())
                            .withTitle(User.TITLE.getUserData() + RandomGenerateMethods.random())
                            .withVisibleTitle(User.VISIBLE_TITLE.getUserData() + RandomGenerateMethods.random())
                            .withStoreId(User.STORE_ID.getUserData())
                            .withDescription(User.DESCRIPTION.getUserData())
                            .withPerUnit(User.PER_UNIT.getUserData())
                            .withIsCrv(User.IS_CRV.getUserData())
                            .withValue(User.VALUE.getUserData())
                            .withType(User.TYPE.getUserData())
                            .withApplyToAllProducts(User.APPLY_TO_ALL_PRODUCTS.getUserData())
                            .withToken(AbstractRequest.getToken())
                            .withLanguage(User.LANGUAGES.getUserData())
                            .withContentLang(User.CONTENTLANG.getUserData()),
                    User.COMMOND.getUserData());

            default -> null; //TODO we don't return null and switch is not correct
        };
    }
}
