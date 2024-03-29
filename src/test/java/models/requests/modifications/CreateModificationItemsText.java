package models.requests.modifications;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.With;

import java.util.ArrayList;

@With
@Getter
public class CreateModificationItemsText {
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
        @SerializedName("min_length")
        public String minLength;
        @SerializedName("max_length")
        public Integer maxLength;
        @SerializedName("price_change")
        public Integer priceChange;
        @SerializedName("upc")
        public String upc;
        @SerializedName("image")
        public String image;
        @SerializedName("store_id")
        public String storeId;

        public CreateModificationItemsText(Boolean isInstock, String type, Boolean isMultiline, String title, String description,
                                           String minLength,  Integer maxLength,  Integer priceChange, String upc, String image, String storeId) {
            this.isInstock = isInstock;
            this.type = type;
            this.isMultiline = isMultiline;
            this.title=title;
            this.description=description;
            this.minLength = minLength;
            this.maxLength = maxLength;
            this.priceChange=priceChange;
            this.upc=upc;
            this.image=image;
            this.storeId=storeId;
        }
}

