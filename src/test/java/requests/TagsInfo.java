package requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TagsInfo {
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
}
