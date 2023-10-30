package helpers;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.companySettings.SettingCompanyEdit;
import models.responses.companySettings.SettingsCompany;
import dataProviders.CompanySettingsProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestCompanySettings extends AbstractRequest {
    public SettingsCompany requestGetCheckCompanySettings(String url){
        return baseAuthorizedRequest()
                .get(url)
                .then().log().all()
                .extract().as(SettingsCompany.class);
    }

    public SettingCompanyEdit putRequestEditCompanySettings(String url){
        return baseAuthorizedRequest()
                .body(CompanySettingsProvider.editSettingCompany(User.EMAIL_INFO))
                .put(url)
                .then().log().all()
                .extract().as(SettingCompanyEdit.class);
    }
}
