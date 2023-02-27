package apiTests;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.companySettings.SettingCompanyEdit;
import responses.companySettings.SettingsCompany;
import steps.data.users.CompanySettingsProvider;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.ApiV2;
import storage.CompanySettingsEnum;
import storage.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CompanySettings {

    Gson gson = new Gson();

    @Test
    @DisplayName("Check company settings")
    public void checkCompanySettings() {

        SettingsCompany settings = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV2.COMPANY_SETTINGS.getApi())
                .then().log().all()
                .extract().as(SettingsCompany.class);
        List<String> expectedList = CompanySettingsEnum.getType();

        Assertions.assertEquals("Ok", settings.getMessage());
        Assertions.assertEquals("OK", settings.getCode());
        Assertions.assertFalse(settings.data.adminSettings.guestCheckoutMobile.isEmpty(), "guest_checkout_mobile is empty");
        Assertions.assertTrue(expectedList.contains(settings.data.adminSettings.guestCheckoutMobile), "text is not contains");
        Assertions.assertTrue(UserInfoProvider.generateRandomNumber(settings.data.adminSettings.collectingOutOfStockConfirmationsCount), "id contains char");
        Assertions.assertTrue(UserInfoProvider.generateRandomNumber(settings.data.adminSettings.printUpcInExternalReceipts), "id contains char");
        Assertions.assertTrue(UserInfoProvider.generateRandomNumber(settings.data.adminSettings.printUpcInInternalReceipts), "id contains char");
        Assertions.assertTrue(expectedList.contains(settings.data.adminSettings.signUpMobile), "text is not contains");
        Assertions.assertTrue(expectedList.contains(settings.data.adminSettings.signUpWeb), "text is not contains");


    }

    @Test
    @SerializedName("Check edit company settings")
    public void editCompanySettings() {
        SettingCompanyEdit companySettingsEdit = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(CompanySettingsProvider.editSettingCompany(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.COMPANY_SETTINGS.getApi())
                .then().log().all()
                .extract().as(SettingCompanyEdit.class);

        Assertions.assertEquals("Ok", companySettingsEdit.getMessage());
        Assertions.assertEquals("OK", companySettingsEdit.getCode());
        Assertions.assertTrue(companySettingsEdit.data.isEmpty(), "data is not empty");
    }


}
