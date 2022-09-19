package responses.deleteProduct;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class DeleteProduct {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private boolean data;

}
