package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class StoreInfo {
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("logo")
    public String logo;
    @SerializedName("address")
    public Address address;
    @SerializedName("timezone")
    public String timezone;
    @SerializedName("currency")
    public Currency currency;
    @SerializedName("is_country_uses_metric")
    public boolean isCountryUsesMetric;
    @SerializedName("access_roles")
    public ArrayList<String> accessRoles;
    @SerializedName("collecting_flow")
    public String collectingFlow;

    @Getter
    public static class Address {
        @SerializedName("first_line")
        public String first_line;
        @SerializedName("location")
        public Location location;

        @Getter
        public static class Location {
            @SerializedName("lat")
            public String lat;
            @SerializedName("lng")
            public String lng;
        }
    }

    @Getter
    public static class Currency {
        @SerializedName("code")
        public String code;
        @SerializedName("symbol")
        public String symbol;
    }
}
