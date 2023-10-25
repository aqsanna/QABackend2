package models.requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class ChangeTagShowOnProductCard {

        @SerializedName("show_icon_on_product")
        public Integer show_icon_on_product;


        public ChangeTagShowOnProductCard(Integer show_icon_on_product) {
            super();
            this.show_icon_on_product=show_icon_on_product;
        }
    }
