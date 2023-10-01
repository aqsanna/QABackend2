package models.responses.product;

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

    public SuccessCreateProduct withCode(Integer code) {
        this.code = code;
        return this;
    }

    public SuccessCreateProduct withResult(String result) {
        this.result = result;
        return this;
    }

    public SuccessCreateProduct withError(String error) {
        this.error = error;
        return this;
    }

    public SuccessCreateProduct withData(String data) {
        this.data = data;
        return this;
    }
}