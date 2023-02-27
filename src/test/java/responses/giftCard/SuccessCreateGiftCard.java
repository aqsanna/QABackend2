package responses.giftCard;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import responses.tags.TagsEdit;

@Getter
public class SuccessCreateGiftCard {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public String data;

    public SuccessCreateGiftCard withMessage(String message) {
        this.message = message;
        return this;
    }
    public SuccessCreateGiftCard withCode(String code) {
        this.code = code;
        return this;
    }
    public SuccessCreateGiftCard withData(String data) {
        this.data = data;
        return this;
    }
}
