package models.requests.modifications;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.With;

@With
@Getter
public class UpdateModificationItems {
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




        public UpdateModificationItems(String id, String storeId,Integer priceChange, String upc, String type, String image,String title,
                                       String description, Boolean isInstock, Boolean isMultiline, String minLength, Integer maxLength) {
            this.id = id;
            this.storeId = storeId;
            this.priceChange = priceChange;
            this.upc=upc;
            this.type=type;
            this.image=image;
            this.title=title;
            this.description=description;
            this.isInstock=isInstock;
            this.isMultiline=isMultiline;
            this.minLength=minLength;
            this.maxLength=maxLength;
        }
}

