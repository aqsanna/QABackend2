package responses;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import requests.ProductDataTypeInfo;

import java.util.ArrayList;

@Getter
public class ProductDataType {
    @SerializedName("code")
    private  Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private ArrayList<ProductDataTypeInfo> data;
}
