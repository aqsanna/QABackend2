package models.requests.giftCards;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class GiftCardCreate {
    @SerializedName("currency")
    public String currency;
    @SerializedName("expirationDate")
    public String expirationDate;
    @SerializedName("initialBalance")
    public Integer initialBalance;
    @SerializedName("holder")
    public String holder;
    @SerializedName("email")
    public String email;
    @SerializedName("phone")
    public String phone;
    @SerializedName("sendGiftCard")
    public Boolean sendGiftCard;

    public GiftCardCreate(String currency, String expirationDate, Integer initialBalance, String holder, String email, String phone, Boolean sendGiftCard){
        this.currency=currency;
        this.expirationDate=expirationDate;
        this.initialBalance=initialBalance;
        this.holder=holder;
        this.email=email;
        this.phone=phone;
        this.sendGiftCard=sendGiftCard;
    }
}
