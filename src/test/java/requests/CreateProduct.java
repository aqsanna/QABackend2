package requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class CreateProduct implements Serializable {
    @SerializedName("params")
    @Expose
    public Params params;

    public CreateProduct() {
    }

    public CreateProduct(Params params) {
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

        public Params() {
        }

        public Params(String name, String upc, String category_id, Double price, String price_units) {
            super();
            this.name = name;
            this.upc = upc;
            this.category_id = category_id;
            this.price = price;
            this.price_units = price_units;
        }
    }
}