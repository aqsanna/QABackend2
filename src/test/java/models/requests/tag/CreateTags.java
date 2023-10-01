package models.requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class CreateTags {
        @SerializedName("title")
        public String title;
        @SerializedName("icon")
        public String icon;
        @SerializedName("priority")
        public String priority;
        @SerializedName("status")
        public Integer status;
        @SerializedName("visible")
        public Integer visible;
        @SerializedName("show_icon_on_product")
        public Integer showIconOnProduct;

        public CreateTags(String title, String icon, String priority, Integer status, Integer visible, Integer showIconOnProduct) {
            this.title = title;
            this.icon = icon;
            this.priority = priority;
            this.visible=visible;
            this.status=status;
            this.showIconOnProduct=showIconOnProduct;
        }
}

