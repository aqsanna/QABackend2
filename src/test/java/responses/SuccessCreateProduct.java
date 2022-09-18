package responses;

import com.google.gson.annotations.SerializedName;

public class SuccessCreateProduct {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private String data;

    public Integer getCode() {
        return code;
    }

    public SuccessCreateProduct withCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public SuccessCreateProduct withResult(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }

    public SuccessCreateProduct withError(String error) {
        this.error = error;
        return this;
    }

    public String getData() {
        return data;
    }

    public SuccessCreateProduct withData(String data) {
        this.data = data;
        return this;
    }
}
