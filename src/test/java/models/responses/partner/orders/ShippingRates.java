package models.responses.partner.orders;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;
@Getter
public class ShippingRates {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public ArrayList<Datum> data;
    public static class Datum{
        @SerializedName("id")
        public String id;
        @SerializedName("name")
        public String name;
        @SerializedName("token")
        public String token;
        @SerializedName("provider")
        public String provider;
        @SerializedName("price")
        public double price;
        @SerializedName("currency")
        public String currency;
        @SerializedName("attributes")
        public ArrayList<String> attributes;
        @SerializedName("icon")
        public Icon icon;
        @SerializedName("parentObjectIds")
        public ArrayList<String> parentObjectIds;
        @SerializedName("objectId")
        public String objectId;
        @SerializedName("estimatedDeliveryPeriod")
        public String estimatedDeliveryPeriod;
        public static class Icon{
            @SerializedName("small")
            public String small;
            @SerializedName("large")
            public String large;
        }
    }
}
