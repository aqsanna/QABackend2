package models.requests.productDadaType;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ProductDataTypeInfo {
    @SerializedName("id")
    public String Id;
    @SerializedName("name")
    public String name;
}
