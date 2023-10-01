package models.requests.order;

import com.google.gson.annotations.SerializedName;

public class CollectOrderProduct {
    @SerializedName("params")
    public Params params;
    @SerializedName("_response")
    public String Response;
    @SerializedName("_group_by")
    public String groupBy;

    public CollectOrderProduct(CollectOrderProduct.Params params, String response, String groupBy) {
        this.params = params;
        this.Response = response;
        this.groupBy = groupBy;
    }

    public static class Params {
        @SerializedName("status")
        public String status;

        public Params(String status) {
            this.status = status;
        }
    }
}
