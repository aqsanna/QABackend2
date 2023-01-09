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
        public String id;
        @SerializedName("store_id")
        public String storeId;
        @SerializedName("title_old")
        public String titleOld;
        @SerializedName("visible_title_old")
        public String visibleTitleOld;
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
