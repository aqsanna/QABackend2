package models.requests.modifications;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class CreateModificationItemInvalidCredential {
    @SerializedName("is_instock")
    public Integer isInstock;
    @SerializedName("type")
    public String type;
    @SerializedName("is_multiline")
    public Integer isMultiline;
    @SerializedName("title")
    public String title;
    @SerializedName("price_change")
    public String price_change;

    public CreateModificationItemInvalidCredential (Integer isInstock, String type, Integer isMultiline,String title,  String price_change){
        super();
        this.isInstock=isInstock;
        this.type=type;
        this.isMultiline=isMultiline;
        this.title=title;
        this.price_change=price_change;

    }
}
