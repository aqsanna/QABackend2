package models.requests.order;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductAddBox {
    @SerializedName("color")
    public String color;
    @SerializedName("store_shipping_packaging_box_id")
    public int storeShippingPackagingBoxId;
    @SerializedName("order_product_ids")
    public ArrayList<Integer> orderProductIds;

    public ProductAddBox(String color, int storeShippingPackagingBoxId, ArrayList<Integer> orderProductIds) {
        this.color = color;
        this.storeShippingPackagingBoxId = storeShippingPackagingBoxId;
        this.orderProductIds = orderProductIds;
    }
}
