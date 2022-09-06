package requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

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

    public CreateProduct withParams(Params params) {
        this.params = params;
        return this;
    }

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

        public Params withName(String name) {
            this.name = name;
            return this;
        }

        public Params withUpc(String upc) {
            this.upc = upc;
            return this;
        }

        public Params withCategoryId(String category_id) {
            this.category_id = category_id;
            return this;
        }

        public Params withPrice(Double price) {
            this.price = price;
            return this;
        }

        public Params withPriceUnits(String price_units) {
            this.price_units = price_units;
            return this;
        }
    }
}