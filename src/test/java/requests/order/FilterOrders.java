package requests.order;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilterOrders {
    @SerializedName("filter")
    public Filter filter;
    @SerializedName("filterType")
    public String filterType;
    public static class Filter{
        @SerializedName("status")
        public ArrayList<String> status;
        @SerializedName("mode")
        public ArrayList<String> mode;

        public Filter(ArrayList<String> status, ArrayList<String> mode) {
            this.status = status;
            this.mode = mode;
        }
    }

    public FilterOrders(Filter filter, String filterType) {
        this.filter = filter;
        this.filterType = filterType;
    }
}
