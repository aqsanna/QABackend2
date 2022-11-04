package requests;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class UpdateProduct implements Serializable {
    public Params params;

    public UpdateProduct(Params params) {
        super();
        this.params = params;
    }

    @With
    public static class Params implements Serializable {

        public String name;
        public String upc;
        @SerializedName("category_id")
        public String categoryId;
        public Double price;
        @SerializedName("price_units")
        public String priceUnits;
        public Integer volume;
        @SerializedName("volume_units")
        public String volumeUnits;
        @SerializedName("quantity_in_pack")
        public Integer quantityInPack;
        @SerializedName("displayed_value_for_price")
        public Integer displayedValueForPrice;
        public String description;
        public String ingredients;
        @SerializedName("tag_ids")
        public Integer tagIds;
        @SerializedName("is_foodstamp")
        public Boolean isFoodstamp;
        @SerializedName("is_shippable")
        public Boolean isShippable;
        @SerializedName("has_availability_schedule")
        public Boolean hasAvailabilitysSchedule;


        public Params(String name, String upc, String category_id, Double price, String price_units, Integer volume, String volume_units, Integer quantity_in_pack,
                      Integer displayed_value_for_price, String description, String ingredients, Integer tag_ids, Boolean is_foodstamp, Boolean is_shippable,
                      Boolean has_availability_schedule) {
            super();
            this.name = name;
            this.upc = upc;
            this.categoryId = category_id;
            this.price = price;
            this.priceUnits = price_units;
            this.volume = volume;
            this.volumeUnits = volume_units;
            this.quantityInPack = quantity_in_pack;
            this.displayedValueForPrice = displayed_value_for_price;
            this.description = description;
            this.ingredients = ingredients;
            this.tagIds = tag_ids;
            this.isFoodstamp = is_foodstamp;
            this.isShippable = is_shippable;
            this.hasAvailabilitysSchedule = has_availability_schedule;
        }
    }
}