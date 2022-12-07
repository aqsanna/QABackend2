package requests;

import com.google.gson.annotations.SerializedName;

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
    }
}
