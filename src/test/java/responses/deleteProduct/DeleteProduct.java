package responses.deleteProduct;

import com.google.gson.annotations.SerializedName;

public class DeleteProduct {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private boolean data;
    public Integer getCode() {
        return code;
    }
    public String getResult() {
        return result;
    }
    public String getError() {
        return error;
    }
    public boolean isData() {
        return data;
    }
}
