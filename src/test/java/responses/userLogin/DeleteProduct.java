package responses.userLogin;
import com.google.gson.annotations.SerializedName;

public class DeleteProduct {

    @SerializedName("code")
    private  Integer code;
    @SerializedName("result")
    private  String result;
    @SerializedName("error")
    private  String error;
    @SerializedName("data")
    private  boolean data;

    public Integer getCode() {
        return code;
    }

    public DeleteProduct setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public DeleteProduct setResult(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }

    public DeleteProduct setError(String error) {
        this.error = error;
        return this;
    }

    public boolean isData() {
        return data;
    }

    public DeleteProduct setData(boolean data) {
        this.data = data;
        return this;
    }
}
