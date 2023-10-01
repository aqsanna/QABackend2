package models.requests.discount;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class DiscountInfo {

    public String id;
    public String title;
    @SerializedName("start_date")
    public String startDate;
    @SerializedName("end_date")
    public String endDate;
    public String type;
    public String description;
}
