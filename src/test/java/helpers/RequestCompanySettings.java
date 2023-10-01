package helpers;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.companySettings.SettingCompanyEdit;
import models.responses.companySettings.SettingsCompany;
import dataProviders.CompanySettingsProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestCompanySettings {
    public SettingsCompany requestGetCheckCompanySettings(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url)
                .then().log().all()
                .extract().as(SettingsCompany.class);
    }

    public SettingCompanyEdit putRequestEditCompanySettings(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(CompanySettingsProvider.editSettingCompany(User.EMAIL_INFO))
                .put(path + url)
                .then().log().all()
                .extract().as(SettingCompanyEdit.class);
    }
}
