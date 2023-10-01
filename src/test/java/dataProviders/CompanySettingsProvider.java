package dataProviders;

import models.requests.companySettings.CompanySettingsEdit;
import enums.CompanySettingsEnum;
import enums.User;

import java.util.Random;

public class CompanySettingsProvider {
    public static CompanySettingsEdit editSettingCompany(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CompanySettingsEdit(
                    new CompanySettingsEdit.AdminSettings(
                            CompanySettingsEnum.ENABLE.getCompanySettings()
                            , CompanySettingsEnum.ENABLE.getCompanySettings()
                            , random()
                            , Boolean.parseBoolean(User.IS_FOODSTAMP.getUserData())
                            , Boolean.parseBoolean(User.IS_FOODSTAMP.getUserData())
                            , CompanySettingsEnum.DISABLE.getCompanySettings()
                            , CompanySettingsEnum.DISABLE.getCompanySettings()));
            default -> null;
        };
    }

    public static Integer random() {
        Random ran = new Random();
        int x = ran.nextInt(9) + 1;
        return x;
    }
}
