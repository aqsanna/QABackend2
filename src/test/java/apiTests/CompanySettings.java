package apiTests;

import assertions.AssertionForMessages;
import com.google.gson.annotations.SerializedName;
import helpers.RequestCompanySettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.responses.companySettings.SettingCompanyEdit;
import models.responses.companySettings.SettingsCompany;
import dataProviders.UserInfoProvider;
import enums.ApiV1;
import enums.ApiV2;
import enums.CompanySettingsEnum;
import java.util.List;

public class CompanySettings {
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    RequestCompanySettings requestCompanySettings = new RequestCompanySettings();

    @Test
    @DisplayName("Check company settings")
    public void checkCompanySettings() {

        SettingsCompany settings =requestCompanySettings.requestGetCheckCompanySettings(ApiV2.COMPANY_SETTINGS.getApi());
        List<String> expectedList = CompanySettingsEnum.getType();
        assertionForMessages.assertRequestMessageAndCode(settings.getMessage(), settings.getCode());
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
        SettingCompanyEdit companySettingsEdit = requestCompanySettings.putRequestEditCompanySettings(ApiV2.COMPANY_SETTINGS.getApi());
        assertionForMessages.assertRequestMessageAndCode(companySettingsEdit.getMessage(), companySettingsEdit.getCode());
        Assertions.assertTrue(companySettingsEdit.data.isEmpty(), "data is not empty");
    }


}
