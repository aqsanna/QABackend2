package models.requests.modifications;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.With;

import java.util.ArrayList;

@With
@Getter
public class CreateModificationItems {
        @SerializedName("is_instock")
        public Boolean isInstock;
        @SerializedName("type")
        public String type;
        @SerializedName("is_multiline")
        public Boolean isMultiline;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        @SerializedName("price_change")
        public Integer priceChange;
        @SerializedName("upc")
        public String upc;
        @SerializedName("image")
        public String image;
        @SerializedName("store_id")
        public String storeId;

        public CreateModificationItems(Boolean isInstock, String type, Boolean isMultiline, String title, String description,
                                       Integer priceChange, String upc, String image, String storeId) {
            this.isInstock = isInstock;
            this.type = type;
            this.isMultiline = isMultiline;
            this.title=title;
            this.description=description;
            this.priceChange=priceChange;
            this.upc=upc;
            this.image=image;
            this.storeId=storeId;
        }
}

