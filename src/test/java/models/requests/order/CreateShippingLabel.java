package models.requests.order;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CreateShippingLabel {
    @SerializedName("transaction_ids")
    public ArrayList<String> transactionIds;
    @SerializedName("object_id")
    public String objectId;
}
