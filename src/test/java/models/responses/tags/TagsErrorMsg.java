package models.responses.tags;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class TagsErrorMsg {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("validation")
    public ArrayList<Validation> validation;
    @Getter
    public static class Validation {
        @SerializedName("field")
        public String field;
        @SerializedName("message")
        public String message;
    }
}
