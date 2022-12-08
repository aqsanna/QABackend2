package requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderConfirm {
    @SerializedName("params")
    public Params params;
    @SerializedName("_response")
    public String Response;
    @SerializedName("_group_by")
    public String groupBy;
    public static class Params{
        @SerializedName("preparation_time")
        public String preparationTime;
        public Params(String preparationTime) {
            this.preparationTime = preparationTime;
        }
    }
    public OrderConfirm(Params params, String response, String groupBy) {
        this.params = params;
        this.Response = response;
        this.groupBy = groupBy;
    }
}
