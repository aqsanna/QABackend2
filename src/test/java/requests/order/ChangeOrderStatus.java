package requests.order;

import com.google.gson.annotations.SerializedName;

public class ChangeOrderStatus {
    @SerializedName("status")
    String status;

    public ChangeOrderStatus(String status) {
        this.status = status;
    }
}
