package requests;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class CompanySettingsEdit implements Serializable {
    public AdminSettings adminSettings;

    public CompanySettingsEdit(AdminSettings adminSettings){
        super();
        this.adminSettings=adminSettings;

    }
    @With
    public static class AdminSettings implements Serializable{
        @SerializedName("guest_checkout_mobile")
        public String guestCheckoutMobile;
        @SerializedName("guest_checkout_web")
        public String guestCheckoutWeb;
        @SerializedName("collecting_out_of_stock_confirmations_count")
        public Integer collectingOutOfStockConfirmationsCount;
        @SerializedName("print_upc_in_internal_receipts")
        public Boolean printUpcInInternalReceipts;
        @SerializedName("print_upc_in_external_receipts")
        public Boolean printUpcInExternalReceipts;
        @SerializedName("sign_up_mobile")
        public String signUpMobile;
        @SerializedName("sign_up_web")
        public String signUpWeb;

        public AdminSettings(String guestCheckoutMobile, String guestCheckoutWeb, Integer collectingOutOfStockConfirmationsCount,
                                   Boolean printUpcInInternalReceipts, Boolean printUpcInExternalReceipts, String signUpMobile, String signUpWeb){
            super();
            this.guestCheckoutMobile=guestCheckoutMobile;
            this.guestCheckoutWeb = guestCheckoutWeb;
            this.collectingOutOfStockConfirmationsCount = collectingOutOfStockConfirmationsCount;
            this.printUpcInInternalReceipts = printUpcInInternalReceipts;
            this.printUpcInExternalReceipts = printUpcInExternalReceipts;
            this.signUpMobile = signUpMobile;
            this.signUpWeb = signUpWeb;

        }
    }
}
