package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class DiscountInfo {

    private String id;
    private String title;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("end_date")
    private String endDate;
    private String type;
    private String description;
}
