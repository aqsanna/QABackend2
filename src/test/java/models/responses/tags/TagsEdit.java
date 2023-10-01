package models.responses.tags;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TagsEdit {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;
    @Getter
    public static class Data {
        @SerializedName("partner_id")
        public String partnerId;
        @SerializedName("icon")
        public String icon;
        @SerializedName("status")
        public Integer status;
        @SerializedName("priority")
        public String priority;
        @SerializedName("visible")
        public Integer visible;
        @SerializedName("show_icon_on_product")
        public Integer showIconOnProduct;
        @SerializedName("id")
        public String id;
        @SerializedName("title")
        public String title;
        @SerializedName("products")
        public Integer products;
    }

}
