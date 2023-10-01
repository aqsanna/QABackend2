package models.responses.companySettings;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class SettingsCompany {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;

    @Getter
    public static class Data{
        @SerializedName("adminSettings")
        public AdminSettings adminSettings;
    }

    @Getter
    public static class AdminSettings{
        @SerializedName("guest_checkout_mobile")
        public String guestCheckoutMobile;
        @SerializedName("guest_checkout_web")
        public String guestCheckoutWeb;
        @SerializedName("collecting_out_of_stock_confirmations_count")
        public Integer collectingOutOfStockConfirmationsCount;
        @SerializedName("print_upc_in_internal_receipts")
        public Integer printUpcInInternalReceipts;
        @SerializedName("print_upc_in_external_receipts")
        public Integer printUpcInExternalReceipts;
        @SerializedName("sign_up_mobile")
        public String signUpMobile;
        @SerializedName("sign_up_web")
        public String signUpWeb;
    }
}
