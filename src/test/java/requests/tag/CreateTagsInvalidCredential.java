package requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class CreateTagsInvalidCredential {

        @SerializedName("status")
        public Integer status;
       @SerializedName("priority")
        public String priority;
       @SerializedName("visible")
       public Integer visible;
       @SerializedName("show_icon_on_product")
       public Integer showIconOnProduct;

        public CreateTagsInvalidCredential(Integer status, String priority, Integer visible, Integer showIconOnProduct) {
            super();
            this.status=status;
            this.priority=priority;
            this.visible=visible;
            this.showIconOnProduct=showIconOnProduct;
        }
    }
