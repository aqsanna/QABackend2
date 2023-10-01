package models.requests.tax;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TaxesInfo {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("is_active")
    private Boolean isActive;
    @SerializedName("apply_to_all_products")
    private Boolean applyToAllProducts;
}
