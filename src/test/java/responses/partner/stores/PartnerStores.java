package responses.partner.stores;

import Utile.Store;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PartnerStores {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private ArrayList<Store> data;

    public Integer getCode() {
        return code;
    }

    public PartnerStores withCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public PartnerStores withResult(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }

    public PartnerStores withError(String error) {
        this.error = error;
        return this;
    }

    public ArrayList<Store> getData() {
        return data;
    }

    public PartnerStores withData(ArrayList<Store> data) {
        this.data = data;
        return this;
    }


}
