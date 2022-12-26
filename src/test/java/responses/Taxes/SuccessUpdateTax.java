package responses.Taxes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
@Getter
public class SuccessUpdateTax {
    public String sequence;
    public Integer result;
    public Data data;
    public String message;
    public String error;
    public List<String> errors=null;

    @Getter
    public static class Data {

        public Result result;
        public String message;
    }
    @Getter
    public static  class Result{
        public Store store;
    }
    @Getter
    public static class Store{
        public String id;
        @SerializedName("partner_id")
        public String partnerId;
        @SerializedName("import_pack_template_id")
        public Integer importPackTemplateId;
        @SerializedName("store_account_type_id")
        public Integer storeAccountTypeId;
        public String slug;
        public String logo;
        @SerializedName("card_background")
        public String cardBackground;
        @SerializedName("header_background")
        public String headerBackground;
        public String representative;
        public String template;
        public List<String> phones;
        public String email;
        public String latitude;
        public String longitude;
        @SerializedName("zip_code")
        public String zipCode;
        public String status;
        public String timezone;
        @SerializedName("activation_date")
        public String activationDate;
        @SerializedName("is_test")
        public Integer isTest;
        @SerializedName("is_virtual")
        public Integer isVirtual;
        @SerializedName("is_manual_tariff")
        public Integer isManualTariff;
        @SerializedName("custom_delivery_enable")
        public Integer customDeliveryEnable;
        @SerializedName("is_restrict_by_area")
        public Integer isRestrictByArea;
        public String notes;
        @SerializedName("service_fee_percent")
        public Integer serviceFeePercent;
        public String payee;
        @SerializedName("payment_from_driver")
        public Integer paymentFromDriver;
        @SerializedName("country_id")
        public String countryId;
        @SerializedName("state_id")
        public String stateId;
        @SerializedName("address_form_tag")
        public String addressFormTag;
        @SerializedName("order_dispatcher")
        public String orderDispatcher;
        @SerializedName("mark_up")
        public String markUp;

    }
}
