package utils;

import com.google.gson.annotations.SerializedName;
import responses.GetStore;

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

    public class Address{
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

        public Address setFirst_line(String first_line) {
            this.first_line = first_line;
            return this;
        }

        public Address setLocation(Location location) {
            this.location = location;
            return this;
        }

        public class Location{
            @SerializedName("lat")
            public String lat;

            public String getLat() {
                return lat;
            }

            @SerializedName("lng")
            public String lng;

            public String getLng() {
                return lng;
            }

            public Location setLat(String lat) {
                this.lat = lat;
                return this;
            }

            public Location setLng(String lng) {
                this.lng = lng;
                return this;
            }
        }
    }

    public class Currency{
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

        public Currency setCode(String code) {
            this.code = code;
            return this;
        }

        public Currency setSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }
    }

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
}
