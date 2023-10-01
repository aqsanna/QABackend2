package enums;

import java.util.ArrayList;
import java.util.List;

public enum CompanySettingsEnum {
    ENABLE("enabled"),
    DISABLE("disabled");

    private final String companySettings;

    CompanySettingsEnum(String companySettings) {
        this.companySettings = companySettings;
    }

    public String getCompanySettings() {
        return companySettings;
    }

    public static List<String> getType() {
        List<String> listType = new ArrayList<String>();
        for (CompanySettingsEnum l : CompanySettingsEnum.values()) {
            listType.add(l.getCompanySettings());
        }
        return listType;
    }

}
