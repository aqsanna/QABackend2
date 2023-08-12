package responses.tags;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TagsDelete {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
}
