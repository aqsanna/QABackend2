package models.requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;
import java.io.Serializable;

@With
public class EditTags implements Serializable {
    @SerializedName("icon")
    public String icon;
    @SerializedName("title")
    public String title;
    @SerializedName("priority")
    public String priority;
    @SerializedName("status")
    public Integer status;
    @SerializedName("visible")
    public Integer visible;
    @SerializedName("show_icon_on_product")
    public Integer showIconOnProduct;

    public EditTags(String icon, String title, String priority, Integer status, Integer visible,Integer showIconOnProduct) {
        super();
        this.icon = icon;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.visible = visible;
        this.showIconOnProduct = showIconOnProduct;
    }
}
