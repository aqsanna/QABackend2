package models.responses.modificationItems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
@Getter
public class SuccessCreateModificationItems {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;

    @Getter
    public static class Data {
        @SerializedName("id")
        public String id;
        @SerializedName("store_id")
        public String storeId;
        @SerializedName("price_change")
        public Integer priceChange;
        @SerializedName("upc")
        public String upc;
        @SerializedName("type")
        public String type;
        @SerializedName("image")
        public String image;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        @SerializedName("is_instock")
        public Boolean isInstock;
        @SerializedName("is_multiline")
        public Boolean isMultiline;
        @SerializedName("min_length")
        public String minLength;
        @SerializedName("max_length")
        public Integer maxLength;

    }
}
