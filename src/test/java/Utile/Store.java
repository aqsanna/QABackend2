package Utile;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Store {
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

    public Store withId(String id) {
        this.id = id;
        return this;
    }

    public Store withTitle(String title) {
        this.title = title;
        return this;
    }

    public Store withLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public Store withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Store withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Store withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Store withCountryUsesMetric(boolean countryUsesMetric) {
        isCountryUsesMetric = countryUsesMetric;
        return this;
    }

    public Store withAccessRoles(ArrayList<String> accessRoles) {
        this.accessRoles = accessRoles;
        return this;
    }

    public Store withCollectingFlow(String collectingFlow) {
        this.collectingFlow = collectingFlow;
        return this;
    }

    public static class Address{
        @SerializedName("first_line")
        public String firstLine;
        @SerializedName("location")
        public Location location;

        public String getFirstLine() {
            return firstLine;
        }

        public Location getLocation() {
            return location;
        }

        public Address withFirstLine(String firstLine) {
            this.firstLine = firstLine;
            return this;
        }

        public Address withLocation(Location location) {
            this.location = location;
            return this;
        }

        public static class Location{
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

            public Location withLat(String lat) {
                this.lat = lat;
                return this;
            }

            public Location withLng(String lng) {
                this.lng = lng;
                return this;
            }
        }
    }

    public static class Currency{
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

        public Currency withCode(String code) {
            this.code = code;
            return this;
        }

        public Currency withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }
    }
}
