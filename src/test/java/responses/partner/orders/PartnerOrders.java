package responses.partner.orders;

import com.google.gson.annotations.SerializedName;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.Getter;

import java.util.ArrayList;
@Getter
public class PartnerOrders {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private ArrayList<Order> data;
    @SerializedName("last_order_date")
    private String lastOrderDate;
    @Getter
    public static class Order {
        @SerializedName("id")
        public String id;
        @SerializedName("status")
        public String status;
        @SerializedName("is_confirmed")
        public boolean isConfirmed;
        @SerializedName("creation_date")
        public String creationDate;
        @SerializedName("modification_date")
        public String modificationDate;
        @SerializedName("dropoff")
        public Dropoff dropoff;
        @SerializedName("payment")
        public Payment payment;
        @SerializedName("type")
        public String type;
        @SerializedName("display_type")
        public String displayType;
        @SerializedName("delivery_tariff")
        public String deliveryTariff;
        @SerializedName("has_instore_prepared_products")
        public boolean hasInstorePreparedProducts;
        @SerializedName("order_items_count")
        public int orderItemsCount;
        @SerializedName("client_curbside_pickup_info")
        @Nullable
        public transient ClientCurbsidePickupInfo clientCurbsidePickupInfo;
        @SerializedName("transactions")
        public ArrayList<Transaction> transactions;
        @SerializedName("delivery")
        @Nullable
        public Delivery delivery;
        @Getter
        public static class Transaction {
            @SerializedName("id")
            public String id;
            @SerializedName("type")
            public String type;
            @SerializedName("icon")
            public String icon;
            @SerializedName("cardInfo")
            public Object cardInfo;
            @SerializedName("description")
            public ArrayList<String> description;
            @SerializedName("amount")
            public String amount;
            @SerializedName("refundable")
            public boolean refundable;
            @SerializedName("transactionID")
            @Nullable
            public String transactionID;
            @SerializedName("relatedTransactions")
            public ArrayList<RelatedTransactions> relatedTransactions;
            @SerializedName("refundErrorMessage")
            public String refundErrorMessage;

            public static class CardInfo {
                @SerializedName("cardType")
                public String cardType;
                @SerializedName("cardNumber")
                public String cardNumber;

            }

            public static class RelatedTransactions {
                @SerializedName("id")
                public String id;
                @SerializedName("type")
                public String type;
                @SerializedName("icon")
                public String icon;
                @SerializedName("cardInfo")
                @Nullable
                public Object cardInfo;
                @SerializedName("description")
                public ArrayList<String> description;
                @SerializedName("amount")
                public String amount;
                @SerializedName("refund_reason")
                @Nullable
                public Object refundReason;
                @SerializedName("transactionID")
                public String transactionID;
                @SerializedName("refundErrorMessage")
                public String refundErrorMessage;

                public static class CardInfo {
                    public String cardNumber;
                }
            }
        }
        @Getter
        public static class Dropoff {
            @SerializedName("period")
            public Period period;
            @SerializedName("person")
            public Person person;

            public Person getPerson() {
                return person;
            }
            @Getter
            public static class Person {
                @SerializedName("id")
                public String id;
                @SerializedName("first_name")
                public String firstName;
                @SerializedName("last_name")
                public String lastName;
                @SerializedName("phone")
                public String phone;
                @SerializedName("membership_id")
                public String membershipId;
            }

            public static class Period {
                @SerializedName("start")
                public String start;
                @SerializedName("end")
                public String end;
            }
        }
        @Getter
        public static class Payment {
            @SerializedName("type")
            public ArrayList<String> type;
            @SerializedName("tip")
            public float tip;
            @SerializedName("total")
            public double total;
            @SerializedName("currency")
            public String currency;
            @SerializedName("currency_symbol")
            public String currencySymbol;
            @SerializedName("bag")
            public Bag bag;
            @SerializedName("additional_freeze_percent")
            public int additionalFreezePercent;
            @SerializedName("maximum_excess_amount_percent")
            public int maximumExcessAmountPercent;

            public static class Bag {
                @SerializedName("qty")
                public int qty;
            }
        }

        public static class Delivery {
            @SerializedName("driver")
            @Nullable
            public Driver driver;
            @SerializedName("accepted_at")
            @Nullable
            public String acceptedAt;
            @SerializedName("delivered_at")
            @Nullable
            public String deliveredAt;

            public static class Driver {
                @SerializedName("id")
                public String id;
                @SerializedName("first_name")
                public String firstName;
                @SerializedName("last_name")
                public String lastName;
                @SerializedName("phone")
                public String phone;
                @SerializedName("car")
                @Nullable
                public Object car;
            }
        }

        public static class ClientCurbsidePickupInfo {
            @SerializedName("notes")
            @Nullable
            public String notes;
            @SerializedName("car_brand")
            @Nullable
            public String carBrand;
            @SerializedName("car_model")
            @Nullable
            public String carModel;
            @SerializedName("notes")
            @Nullable
            public String carColor;
            @SerializedName("plate_number")
            @Nullable
            public String plateNumber;
            @SerializedName("user_car")
            @Nullable
            public UserCar userCar;

            public static class UserCar {
                @SerializedName("car_model")
                @Nullable
                public String carModel;
                @SerializedName("car_brand")
                @Nullable
                public String carBrand;
                @SerializedName("car_color")
                @Nullable
                public String carColor;
                @SerializedName("plate_number")
                @Nullable
                public String plateNumber;
            }
        }
    }
}
