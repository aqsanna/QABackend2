package responses;

import com.google.gson.annotations.SerializedName;

public class CloudPrinter {

    @SerializedName("message")
    private  String message;
    @SerializedName("code")
    private  String code;
    @SerializedName("data")
    private  String data;

    public String getMessage() {
        return message;
    }

    public CloudPrinter setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CloudPrinter setCode(String code) {
        this.code = code;
        return this;
    }

    public String getData() {
        return data;
    }

    public CloudPrinter setData(String data) {
        this.data = data;
        return this;
    }
}
