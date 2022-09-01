package responses.partner.orders;

import Utile.Order;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PartnerOrders {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private ArrayList<Order> data;
    @SerializedName("last_order_date")
    private String lastOrderDate;

    public Integer getCode() {
        return code;
    }

    public PartnerOrders withCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public PartnerOrders withResult(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }

    public PartnerOrders withError(String error) {
        this.error = error;
        return this;
    }

    public ArrayList<Order> getData() {
        return data;
    }

    public PartnerOrders withData(ArrayList<Order> data) {
        this.data = data;
        return this;
    }

    public String getLastOrderDate() {
        return lastOrderDate;
    }

    public PartnerOrders withLastOrderDate(String lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
        return this;
    }
}
