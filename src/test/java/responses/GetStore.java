package responses;

import com.google.gson.annotations.SerializedName;
import utils.StoreInfo;

import java.util.ArrayList;

public class GetStore {

    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private  String result;
    @SerializedName("error")
    private  String error;
    @SerializedName("data")
    private ArrayList<StoreInfo> data;

    public Integer getCode() {
        return code;
    }
    public GetStore setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResults() {
        return result;
    }

    public GetStore setResults(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }
    public GetStore setError(String error) {
        this.error = error;
        return this;
    }

    public ArrayList<StoreInfo> getData() {
        return data;
    }

    public GetStore setData(ArrayList<StoreInfo> data) {
        this.data = data;
        return this;
    }
}
