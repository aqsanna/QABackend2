package responses.product;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class SuccessCreateProduct {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private String data;
}
