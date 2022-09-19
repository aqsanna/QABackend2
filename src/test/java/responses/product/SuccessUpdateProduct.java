package responses.product;

import com.google.gson.annotations.SerializedName;

public class SuccessUpdateProduct {
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

    public SuccessUpdateProduct setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public SuccessUpdateProduct setResult(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }

    public SuccessUpdateProduct setError(String error) {
        this.error = error;
        return this;
    }

    public String getData() {
        return data;
    }

    public SuccessUpdateProduct setData(String data) {
        this.data = data;
        return this;
    }
}