package responses;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import requests.StoreInfo;

import java.util.ArrayList;

@Getter
public class Store {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private ArrayList<StoreInfo> data;

}
