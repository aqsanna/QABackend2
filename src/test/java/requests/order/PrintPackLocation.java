package requests.order;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class PrintPackLocation {
    @SerializedName("cloud_printer_id")
    public String cloudPrinterId;

    public PrintPackLocation(String cloudPrinterId) {
        this.cloudPrinterId = cloudPrinterId;
    }
}
