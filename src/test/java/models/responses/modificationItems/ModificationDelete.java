package models.responses.modificationItems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ModificationDelete {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
}
