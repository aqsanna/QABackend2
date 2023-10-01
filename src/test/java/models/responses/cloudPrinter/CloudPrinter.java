package models.responses.cloudPrinter;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CloudPrinter {
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private String code;
    @SerializedName("data")
    private String data;
}
