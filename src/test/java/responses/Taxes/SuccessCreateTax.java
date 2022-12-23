package responses.Taxes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import responses.userLogin.SuccessLogin;

import java.util.List;
@Getter
public class SuccessCreateTax {

    public String sequence;
    public String result;
    public Data data;
    public String message;
    public String error;
    public List<String> errors=null;

    public SuccessCreateTax withSequence(String sequence) {
        this.sequence = sequence;
        return this;
    }
    public SuccessCreateTax withResult(String result) {
        this.result = result;
        return this;
    }
    public SuccessCreateTax withData(Data data) {
        this.data = data;
        return this;
    }
    public SuccessCreateTax withMessage(String message) {
        this.message = message;
        return this;
    }
    public SuccessCreateTax withError(String error) {
        this.error = error;
        return this;
    }
    public SuccessCreateTax withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    @Getter
    public static class Data {

        public Result result;
        public String message;


        public SuccessCreateTax.Data withResult(Result result) {
            this.result = result;
            return this;
        }
        public SuccessCreateTax.Data withMessage(String message) {
            this.message = message;
            return this;
        }
    }

    @Getter
    public static class Result{
        public String id;
        @SerializedName("store_id")
        public String storeId;
        @SerializedName("title_old")
        public String titleOld;
        @SerializedName("description_old")
        public String descriptionOld;
        public String type;
        public String value;
        @SerializedName("apply_to_all_products")
        public String applyToAllProducts;
        @SerializedName("per_unit")
        public String perUnit;
        @SerializedName("is_active")
        public String isActive;
        @SerializedName("is_crv")
        public String isCrv;
        public String title;
        @SerializedName("visible_title")
        public String visibleTitle;
        public String description;
    }
}
