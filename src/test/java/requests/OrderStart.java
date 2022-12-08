package requests;

import com.google.gson.annotations.SerializedName;

public class OrderStart {
    @SerializedName("_response")
    public String Response;
    @SerializedName("_group_by")
    public String groupBy;

    public OrderStart(String response, String groupBy) {
        this.Response = response;
        this.groupBy = groupBy;
    }
}
