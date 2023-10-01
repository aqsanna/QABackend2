package models.responses.store1;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import models.requests.store1.StoreInfo;

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
