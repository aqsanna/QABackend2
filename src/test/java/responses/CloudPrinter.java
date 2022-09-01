package responses;
import com.google.gson.annotations.SerializedName;

public class CloudPrinter {
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private String code;
    @SerializedName("data")
    private String data;

    public String getMessage() {
        return message;
    }
    public String getCode() {
        return code;
    }
    public String getData() {
        return data;
    }
}
