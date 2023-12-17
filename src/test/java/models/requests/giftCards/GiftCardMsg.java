package models.requests.giftCards;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class GiftCardMsg {
    @SerializedName("currency")
    public String currency;
    @SerializedName("expirationDate")
    public String expirationDate;
    @SerializedName("sendGiftCard")
    public Boolean sendGiftCard;

    public GiftCardMsg(String currency, String expirationDate, Boolean sendGiftCard){
        this.currency=currency;
        this.expirationDate=expirationDate;
        this.sendGiftCard=sendGiftCard;
    }
}
