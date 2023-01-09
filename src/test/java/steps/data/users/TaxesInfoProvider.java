package steps.data.users;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.TaxesCreateInfo;
import requests.TaxesUpdate;
import responses.Taxes.SuccessCreateTax;
import responses.Taxes.SuccessUpdateTax;
import responses.product.SuccessCreateProduct;
import storage.ApiV1;
import storage.User;

import java.util.Random;

import static steps.data.users.ProductInfoProvider.random;

public class TaxesInfoProvider {
    public static TaxesCreateInfo getTaxes(User email){
        return switch (email){
            case EMAIL_INFO -> new TaxesCreateInfo(
                             User.SEQUENCE.getUserData(),
                              User.APPLICATIONKEY.getUserData(),
                              User.ACTION.getUserData(),
                            new TaxesCreateInfo.Params()
                                    .withIsActive(User.IS_ACTIVE.getUserData())
                                    .withTitle(User.TITLE.getUserData() + random())
                                    .withVisibleTitle(User.VISIBLE_TITLE.getUserData() + random())
                                    .withStoreId(User.STORE_ID.getUserData())
                                    .withDescription(User.DESCRIPTION.getUserData())
                                    .withPerUnit(User.PER_UNIT.getUserData())
                                    .withIsCrv(User.IS_CRV.getUserData())
                                    .withValue(User.VALUE.getUserData())
                                    .withType(User.TYPE.getUserData())
                                    .withApplyToAllProducts(User.APPLY_TO_ALL_PRODUCTS.getUserData())
                                    .withToken(UserInfoProvider.getToken())
                                    .withLanguage(User.LANGUAGES.getUserData())
                                    .withContentLang(User.CONTENTLANG.getUserData()),
                             User.COMMOND.getUserData());

            default -> null;
        };

    }
    public static TaxesUpdate editTaxes(User email){
        return switch (email){
            case EMAIL_INFO -> new TaxesUpdate(
                    User.SEQUENCE.getUserData(),
                    User.APPLICATIONKEY.getUserData(),
                    User.ACTION.getUserData(),
                    new TaxesUpdate.Params()
                            .withId(getTaxId())
                            .withIsActive(User.IS_ACTIVE.getUserData())
                            .withTitle(User.TITLE.getUserData() + random())
                            .withVisibleTitle(User.VISIBLE_TITLE.getUserData() + random())
                            .withStoreId(User.STORE_ID.getUserData())
                            .withDescription(User.DESCRIPTION.getUserData())
                            .withPerUnit(User.PER_UNIT.getUserData())
                            .withIsCrv(User.IS_CRV.getUserData())
                            .withValue(User.VALUE.getUserData())
                            .withType(User.TYPE.getUserData())
                            .withApplyToAllProducts(User.APPLY_TO_ALL_PRODUCTS.getUserData())
                            .withToken(UserInfoProvider.getToken())
                            .withLanguage(User.LANGUAGES.getUserData())
                            .withContentLang(User.CONTENTLANG.getUserData()),
                    User.COMMOND.getUserData());

            default -> null;
        };

    }
    public static String getTaxId(){
        Gson gson = new Gson();
        SuccessCreateTax successCreateTax = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TaxesInfoProvider.getTaxes(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAX_CREATE.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTax.class);
        return successCreateTax.getData().getResult().id;

    }

}
