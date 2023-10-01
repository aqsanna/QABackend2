package models.responses.productDataType;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import models.requests.productDadaType.ProductDataTypeInfo;

import java.util.ArrayList;

@Getter
public class ProductDataType {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private ArrayList<ProductDataTypeInfo> data;

}
