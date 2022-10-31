package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ProductDataTypeInfo {
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
}
