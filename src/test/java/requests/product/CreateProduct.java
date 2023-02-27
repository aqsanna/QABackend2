package requests.product;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class CreateProduct implements Serializable {
    public Params params;

    public CreateProduct(Params params) {
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

        public Params(String name, String upc, String category_id, Double price, String price_units) {
            super();
            this.name = name;
            this.upc = upc;
            this.categoryId = category_id;
            this.price = price;
            this.priceUnits = price_units;
        }
    }
}