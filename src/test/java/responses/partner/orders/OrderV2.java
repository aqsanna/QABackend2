package responses.partner.orders;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;
@Getter
public class OrderV2 {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;
@Getter
    public static class Data{
        @SerializedName("id")
        public String id;
        @SerializedName("uniqid")
        public String uniqid;
        @SerializedName("type")
        public String type;
        @SerializedName("user_id")
        public String userId;
        @SerializedName("guest_id")
        public Object guestId;
        @SerializedName("store_id")
        public String storeId;
        @SerializedName("created_by")
        public Object created_by;
        @SerializedName("creation_date")
        public String creation_date;
        @SerializedName("modification_date")
        public String modificationDate;
        @SerializedName("status")
        public String status;
        @SerializedName("is_deleted")
        public int isDeleted;
        @SerializedName("timezone")
        public String timezone;
        @SerializedName("subtotal")
        public String subtotal;
        @SerializedName("tax")
        public String tax;
        @SerializedName("delivery_collecting")
        public String deliveryCollecting;
        @SerializedName("delivery_collecting_charge")
        public String deliveryCollectingCharge;
        @SerializedName("delivery_collecting_distance")
        public String deliveryCollectingDistance;
        @SerializedName("delivery_price")
        public String deliveryPrice;
        @SerializedName("delivery_fee")
        public String deliveryFee;
        @SerializedName("destination_charge")
        public String destinationCharge;
        @SerializedName("displayed_delivery_price")
        public String displayedDeliveryPrice;
        @SerializedName("tips")
        public String tips;
        @SerializedName("tips_percent")
        public int tipsPercent;
        @SerializedName("coupon_deduction")
        public String coupon_deduction;
        @SerializedName("bag_price_old")
        public String bagPriceOld;
        @SerializedName("original_bag_price_old")
        public double originalBagPriceOld;
        @SerializedName("original_free_bag_count_old")
        public int originalFreeBagCountOld;
        @SerializedName("total")
        public String total;
        @SerializedName("original_total")
        public String originalTotal;
        @SerializedName("note")
        public Object note;
        @SerializedName("internal_note")
        public Object internalNote;
        @SerializedName("packs_old")
        public int packsOld;
        @SerializedName("operator_id")
        public Object operatorId;
        @SerializedName("driver_id")
        public Object driverId;
        @SerializedName("is_driver_manually_assigned")
        public int isDriverManuallyAssigned;
        @SerializedName("accepted_at")
        public Object acceptedAt;
        @SerializedName("delivered_at")
        public Object deliveredAt;
        @SerializedName("delivery_tariff_id")
        public String deliveryTariffId;
        @SerializedName("delivery_address_first_line")
        public String deliveryAddressFirstLine;
        @SerializedName("delivery_address_second_line")
        public String deliveryAddressSecondLine;
        @SerializedName("delivery_address_latitude")
        public String deliveryAddressLatitude;
        @SerializedName("delivery_address_longitude")
        public String deliveryAddressLongitude;
        @SerializedName("delivery_address_components")
        public String deliveryAddressComponents;
        @SerializedName("delivery_instructions")
        public Object deliveryInstructions;
        @SerializedName("delivery_date")
        public String deliveryDate;
        @SerializedName("delivery_time_period")
        public String deliveryTimePeriod;
        @SerializedName("delivery_time_start")
        public int deliveryTimeStart;
        @SerializedName("delivery_time_end")
        public int deliveryTimeEnd;
        @SerializedName("customer_first_name")
        public String customerFirstName;
        @SerializedName("customer_last_name")
        public String customerLastName;
        @SerializedName("customer_notification_methods")
        public ArrayList<String> customerNotificationMethods;
        @SerializedName("customer_phone_number")
        public String customerPhoneNumber;
        @SerializedName("customer_email")
        public String customerEmail;
        @SerializedName("customer_signature")
        public Object customerSignature;
        @SerializedName("customer_approve_message")
        public Object customerApproveMessage;
        @SerializedName("customer_approve_image_url")
        public Object customerApproveImageUrl;
        @SerializedName("customer_date_of_birth")
        public Object customerDateOfBirth;
        @SerializedName("payment_method")
        public String paymentMethod;
        @SerializedName("payee")
        public String payee;
        @SerializedName("has_manual_delivery_tariff")
        public int hasManualDeliveryTariff;
        @SerializedName("device")
        public String device;
        @SerializedName("os")
        public String os;
        @SerializedName("app_version")
        public String appVersion;
        @SerializedName("is_archived")
        public Object isArchived;
        @SerializedName("payment_from_driver")
        public int paymentFromDriver;
        @SerializedName("ready_time")
        public String readyTime;
        @SerializedName("is_whitelabel")
        public int isWhitelabel;
        @SerializedName("preparation_time")
        public int preparation_time;
        @SerializedName("is_confirmed")
        public int isConfirmed;
        @SerializedName("is_corrupted")
        public Object isCorrupted;
        @SerializedName("shipping_address")
        public Object shippingAddress;
        @SerializedName("push_subscription")
        public Object pushSubscription;
        @SerializedName("row_version")
        public int rowVersion;
        @SerializedName("pack_start_user_id")
        public String packStartUserId;
        @SerializedName("pack_end_user_id")
        public String packEndUserid;
        @SerializedName("pack_start_timestamp")
        public String packStartTimestamp;
        @SerializedName("pack_end_timestamp")
        public String packEndTimestamp;
        @SerializedName("estimated_pack_start_timestamp")
        public Object estimatedPackStartTimestamp;
        @SerializedName("estimatedPackEndTimestamp")
        public Object estimated_pack_end_timestamp;
        @SerializedName("initial_shipping_service_slug")
        public Object initialShippingServiceSlug;
        @SerializedName("customer_membership_id")
        public Object customerMembershipId;
        @SerializedName("signature_photo")
        public Object signaturePhoto;
        @SerializedName("order_photo")
        public Object orderPhoto;
        @SerializedName("id_card_photo")
        public Object idCardPhoto;
        @SerializedName("related_order_id")
        public Object relatedOrderId;
        @SerializedName("is_used_ebt")
        public Object isUsedEbt;
        @SerializedName("marketing_sync_status")
        public String marketingSyncStatus;
        @SerializedName("storeTitle")
        public String storeTitle;
        @SerializedName("paymentLink")
        public String paymentLink;
        @SerializedName("createdBy")
        public CreatedBy createdBy;
        @SerializedName("deliveryDateTimePeriod")
        public String deliveryDateTimePeriod;
        @SerializedName("creationDate")
        public String creationDate;
        @SerializedName("assembledBy")
        public String assembledBy;
        @SerializedName("appliedTaxes")
        public ArrayList<AppliedTaxis> appliedTaxes;
        @SerializedName("couponDeduction")
        public String couponDeduction;
        @SerializedName("assemblingTime")
        public String assemblingTime;
        @SerializedName("mode")
        public String mode;
        @SerializedName("isCurbside")
        public boolean isCurbside;
        @SerializedName("preparationTime")
        public int preparationTime;
        @SerializedName("additionalFees")
        public ArrayList<AdditionalFee> additionalFees;
        @SerializedName("packs")
        public ArrayList<Pack> packs;
        @SerializedName("curbsidePickupInfo")
        public Object curbsidePickupInfo;
        @SerializedName("products")
        public ArrayList<Product> products;
        @SerializedName("wrapping")
        public Wrapping wrapping;
        @SerializedName("transactions")
        public ArrayList<Transaction> transactions;
        @SerializedName("productShippingPackagingBoxes")
        public ArrayList<Object> productShippingPackagingBoxes;
        @SerializedName("shippingTransactions")
        public ArrayList<Object> shippingTransactions;
        @SerializedName("preSelectedShippingMessage")
        public String preSelectedShippingMessage;
        @SerializedName("isAgeVerificationRequired")
        public boolean isAgeVerificationRequired;
        @SerializedName("isAgeVerified")
        public boolean isAgeVerified;
        @SerializedName("excludeFromCollectingThrottling")
        public int excludeFromCollectingThrottling;
        @SerializedName("shippingRate")
        public String shippingRate;
        public static class CreatedBy{
            @SerializedName("id")
            public Object id;
            @SerializedName("name")
            public String name;
        }
        public static class AppliedTaxis{
            @SerializedName("title")
            public String title;
            @SerializedName("amount")
            public String amount;
        }
        public static class AdditionalFee{
            @SerializedName("id")
            public String id;
            @SerializedName("title")
            public String title;
            @SerializedName("amount")
            public String amount;
        }
        public static class Pack{
            @SerializedName("id")
            public String id;
            @SerializedName("pack_id")
            public String packId;
            @SerializedName("title")
            public String title;
            @SerializedName("type")
            public String type;
            @SerializedName("free_qty")
            public String freeQty;
            @SerializedName("qty")
            public String qty;
            @SerializedName("price")
            public String price;
            @SerializedName("upc")
            public Object upc;
            @SerializedName("status")
            public String status;
            @SerializedName("total")
            public double total;
            @SerializedName("price_formatted")
            public String priceFormatted;
            @SerializedName("total_formatted")
            public String totalFormatted;
            @SerializedName("total_free_formatted")
            public String totalFreeFormatted;
        }
        @Getter
        public static class Product{
            @SerializedName("id")
            public int id;
            @SerializedName("orderId")
            public int orderId;
            @SerializedName("storeProductId")
            public int storeProductId;
            @SerializedName("title")
            public String title;
            @SerializedName("quantity")
            public int quantity;
            @SerializedName("freeQuantity")
            public int freeQuantity;
            @SerializedName("currencyCode")
            public String currencyCode;
            @SerializedName("departmentTitle")
            public String departmentTitle;
            @SerializedName("image")
            public String image;
            @SerializedName("price")
            public String price;
            @SerializedName("originalPrice")
            public String originalPrice;
            @SerializedName("status")
            public String status;
            @SerializedName("total")
            public String total;
            @SerializedName("replacedTo")
            public ArrayList<Object> replacedTo;
            @SerializedName("replacement")
            public Replacement replacement;
            @SerializedName("upc")
            public String upc;
            @SerializedName("isGift")
            public boolean isGift;
            @SerializedName("shippingPackagingBoxId")
            public int shippingPackagingBoxId;
            @SerializedName("product_price_units")
            public String product_price_units;
            @SerializedName("isInStock")
            public int isInStock;
            @SerializedName("in_stock")
            public int inStock;
            @SerializedName("discountPrice")
            public String discountPrice;
            @SerializedName("discounts")
            public ArrayList<Discounts> discounts;
            @SerializedName("additionalDiscount")
            public Object additionalDiscount;
            @SerializedName("discount")
            public Discount discount;
            @SerializedName("modification")
            public ArrayList<Object> modification;
            @SerializedName("productPriceUnits")
            public String productPriceUnits;
            public static class Replacement{
                @SerializedName("type")
                public String type;
                @SerializedName("product")
                public Object product;
            }
            public static class Discounts{
                @SerializedName("id")
                public int id;
                @SerializedName("title")
                public String title;
            }
            public static class Discount{
                @SerializedName("type")
                public String type;
                @SerializedName("info")
                public String info;
                @SerializedName("gifts")
                public ArrayList<Gift> gifts;
                public static class Gift{
                    @SerializedName("title")
                    public String title;
                    @SerializedName("image")
                    public String image;
                }
            }
        }
        public static class Wrapping{
            @SerializedName("packs")
            public ArrayList<Pack> packs;
            @SerializedName("hasAdvancedCollectingFlow")
            public boolean hasAdvancedCollectingFlow;
        }

        public static class Transaction{
            @SerializedName("id")
            public String id;
            @SerializedName("order_id")
            public String order_id;
            @SerializedName("parent_id")
            public Object parent_id;
            @SerializedName("gateway")
            public String gateway;
            @SerializedName("gateway_transaction_id")
            public String gateway_transaction_id;
            @SerializedName("creation_date")
            public String creation_date;
            @SerializedName("modification_date")
            public String modification_date;
            @SerializedName("amount")
            public String amount;
            @SerializedName("packs")
            public String packs;
            @SerializedName("status")
            public String status;
            @SerializedName("order_iteration")
            public int order_iteration;
            @SerializedName("payment_params")
            public String payment_params;
            @SerializedName("info")
            public String info;
            @SerializedName("type")
            public String type;
            @SerializedName("icon")
            public String icon;
            @SerializedName("cardInfo")
            public CardInfo cardInfo;
            @SerializedName("description")
            public ArrayList<String> description;
            @SerializedName("refundable")
            public boolean refundable;
            @SerializedName("transactionID")
            public String transactionID;
            @SerializedName("refundErrorMessage")
            public String refundErrorMessage;
            @SerializedName("relatedTransactions")
            public ArrayList<Object> relatedTransactions;

            public static class CardInfo{
                @SerializedName("cardType")
                public String cardType;
                @SerializedName("cardNumber")
                public String cardNumber;
            }
        }
    }

}
