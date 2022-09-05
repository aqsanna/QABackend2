package requests;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

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

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLogo() {
        return logo;
    }

    public Address getAddress() {
        return address;
    }

    public String getTimezone() {
        return timezone;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean isCountryUsesMetric() {
        return isCountryUsesMetric;
    }

    public ArrayList<String> getAccessRoles() {
        return accessRoles;
    }

    public String getCollectingFlow() {
        return collectingFlow;
    }

    public StoreInfo withId(String id) {
        this.id = id;
        return this;
    }

    public StoreInfo withTitle(String title) {
        this.title = title;
        return this;
    }

    public StoreInfo withLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public StoreInfo withAddress(Address address) {
        this.address = address;
        return this;
    }

    public StoreInfo withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public StoreInfo withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public StoreInfo withCountryUsesMetric(boolean countryUsesMetric) {
        isCountryUsesMetric = countryUsesMetric;
        return this;
    }

    public StoreInfo withAccessRoles(ArrayList<String> accessRoles) {
        this.accessRoles = accessRoles;
        return this;
    }

    public StoreInfo withCollectingFlow(String collectingFlow) {
        this.collectingFlow = collectingFlow;
        return this;
    }

    public static class Address {
        @SerializedName("first_line")
        public String first_line;
        @SerializedName("location")
        public Location location;

        public String getFirst_line() {
            return first_line;
        }

        public Location getLocation() {
            return location;
        }

        public static class Location {
            @SerializedName("lat")
            public String lat;
            @SerializedName("lng")
            public String lng;

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }
        }
    }

    public static class Currency {
        @SerializedName("code")
        public String code;
        @SerializedName("symbol")
        public String symbol;

        public String getCode() {
            return code;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
