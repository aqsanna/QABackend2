package requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class CreateTagsWithoutTitle {

        @SerializedName("status")
        public Integer status;
        @SerializedName("visible")
        public Integer visible;
        @SerializedName("show_icon_on_product")
        public Integer showIconOnProduct;

        public CreateTagsWithoutTitle(Integer status, Integer visible, Integer showIconOnProduct) {
            super();
            this.status=status;
            this.visible=visible;
            this.showIconOnProduct=showIconOnProduct;
        }
    }
