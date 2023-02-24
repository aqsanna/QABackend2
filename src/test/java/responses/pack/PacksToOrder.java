package responses.pack;

import com.google.gson.annotations.SerializedName;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PacksToOrder {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;

    public static class Data {
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
        public double tax;
        @SerializedName("delivery_collecting")
        public int deliveryCollecting;
        @SerializedName("delivery_collecting_charge")
        public int deliveryCollectingCharge;
        @SerializedName("delivery_collecting_distance")
        public int deliveryCollectingDistance;
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
        public double coupon_deduction;
        @SerializedName("bag_price_old")
        public Object bagPriceOld;
        @SerializedName("original_bag_price_old")
        public Object originalBagPriceOld;
        @SerializedName("original_free_bag_count_old")
        public Object originalFreeBagCountOld;
        @SerializedName("total")
        public String total;
        @SerializedName("original_total")
        public String originalTotal;
        @SerializedName("note")
        public Object note;
        @SerializedName("internal_note")
        public String internalNote;
        @SerializedName("packs_old")
        public Object packsOld;
        @SerializedName("operator_id")
        public Object operatoId;
        @SerializedName("driver_id")
        public int driverId;
        @SerializedName("is_driver_manually_assigned")
        public Object isDriverManuallyAssigned;
        @SerializedName("accepted_at")
        public Object acceptedAt;
        @SerializedName("delivered_at")
        public Object deliveredAt;
        @SerializedName("delivery_tariff_id")
        public String deliveryTariffId;
        @SerializedName("delivery_address_first_line")
        public String deliveryAddressFirstLine;
        @SerializedName("delivery_address_second_line")
        public Object deliveryAddressSecondLine;
        @SerializedName("delivery_address_latitude")
        public String deliveryAddressLatitude;
        @SerializedName("delivery_address_longitude")
        public String deliveryAddressLongitude;
        @SerializedName("delivery_address_components")
        public Object deliveryAddressComponents;
        @SerializedName("delivery_instructions")
        public Object deliveryInstructions;
        @SerializedName("delivery_date")
        public String deliveryDate;
        @SerializedName("delivery_time_period")
        public String deliveryTimePeriod;
        @SerializedName("delivery_time_start")
        public Object deliveryTimeStart;
        @SerializedName("delivery_time_end")
        public Object deliveryTimeEnd;
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
        public String customerDateOfBirth;
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
        public Object packEndUserId;
        @SerializedName("pack_start_timestamp")
        public String packStartTimestamp;
        @SerializedName("pack_end_timestamp")
        public Object packEndTimestamp;
        @SerializedName("estimated_pack_start_timestamp")
        public Object estimatedPackStartTimestamp;
        @SerializedName("estimated_pack_end_timestamp")
        public Object estimatedPackEndTimestamp;
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
        public int isUsedEbt;
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
        @Nullable
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

        public static class AppliedTaxis {
            @SerializedName("title")
            public String title;
            @SerializedName("amount")
            public String amount;
        }

        public static class CreatedBy {
            @SerializedName("id")
            public Object id;
            @SerializedName("name")
            public String name;
        }
    }
}
