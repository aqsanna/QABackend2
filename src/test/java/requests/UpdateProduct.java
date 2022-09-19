package requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class UpdateProduct implements Serializable {
    @SerializedName("params")
    @Expose
    public Params params;

    public UpdateProduct() {
    }

    public UpdateProduct(Params params) {
        super();
        this.params = params;
    }

    @With
    public static class Params implements Serializable {
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("upc")
        @Expose
        public String upc;
        @SerializedName("category_id")
        @Expose
        public String category_id;
        @SerializedName("price")
        @Expose
        public Double price;
        @SerializedName("price_units")
        @Expose
        public String price_units;
        @SerializedName("volume")
        @Expose
        public Integer volume;
        @SerializedName("volume_units")
        @Expose
        public String volume_units;
        @SerializedName("quantity_in_pack")
        @Expose
        public Integer quantity_in_pack;
        @SerializedName("displayed_value_for_price")
        @Expose
        public Integer displayed_value_for_price;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("ingredients")
        @Expose
        public String ingredients;
        @SerializedName("tag_ids")
        @Expose
        public Integer tag_ids;
        @SerializedName("is_foodstamp")
        @Expose
        public Boolean is_foodstamp;
        @SerializedName("is_shippable")
        @Expose
        public Boolean is_shippable;
        @SerializedName("has_availability_schedule")
        @Expose
        public Boolean has_availability_schedule;

        public Params() {
        }

        public Params(String name, String upc, String category_id, Double price, String price_units, Integer volume, String volume_units, Integer quantity_in_pack,
                      Integer displayed_value_for_price, String description, String ingredients, Integer tag_ids, Boolean is_foodstamp, Boolean is_shippable,
                      Boolean has_availability_schedule) {
            super();
            this.name = name;
            this.upc = upc;
            this.category_id = category_id;
            this.price = price;
            this.price_units = price_units;
            this.volume = volume;
            this.volume_units = volume_units;
            this.quantity_in_pack = quantity_in_pack;
            this.displayed_value_for_price = displayed_value_for_price;
            this.description = description;
            this.ingredients = ingredients;
            this.tag_ids = tag_ids;
            this.is_foodstamp = is_foodstamp;
            this.is_shippable = is_shippable;
            this.has_availability_schedule = has_availability_schedule;
        }
    }
}