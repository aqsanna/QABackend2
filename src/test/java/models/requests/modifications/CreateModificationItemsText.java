package models.requests.modifications;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.util.ArrayList;

@With
public class CreateModificationItemsText {
        @SerializedName("is_instock")
        public Integer isInstock;
        @SerializedName("type")
        public String type;
        @SerializedName("is_multiline")
        public Integer isMultiline;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        @SerializedName("min_length")
        public String minLength;
        @SerializedName("max_length")
        public Integer maxLength;
        @SerializedName("price_change")
        public Integer priceChange;
        @SerializedName("taxes")
        public ArrayList<String> taxes;
        @SerializedName("upc")
        public String upc;
        @SerializedName("image")
        public String image;
        @SerializedName("store_id")
        public String storeId;

        public CreateModificationItemsText(Integer isInstock, String type, Integer isMultiline, String title, String description,
                                           String minLength,  Integer maxLength,  Integer priceChange, ArrayList<String> taxes, String upc, String image, String storeId) {
            this.isInstock = isInstock;
            this.type = type;
            this.isMultiline = isMultiline;
            this.title=title;
            this.description=description;
            this.minLength = minLength;
            this.maxLength = maxLength;
            this.priceChange=priceChange;
            this.taxes = taxes;
            this.upc=upc;
            this.image=image;
            this.storeId=storeId;
        }
}

