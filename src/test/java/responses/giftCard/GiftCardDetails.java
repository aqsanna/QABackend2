package responses.giftCard;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GiftCardDetails {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;

    @Getter
    public static class Card{
        @SerializedName("app_id")
        public String appId;
        @SerializedName("client_id")
        public String clientId;
        @SerializedName("created_at")
        public String createdAt;
        public String currency;
        @SerializedName("current_balance")
        public Integer currentBalance;
        public String email;
        @SerializedName("expiration_date")
        public String expirationDate;
        public ArrayList<Object> extra;
        public String fdigit;
        public String hash;
        public String holder;
        public String id;
        public Integer length;
        public String phone;
        public String status;
        public Integer value;
    }

    @Getter
    public static class Data{
        public Card card;
        public ArrayList<Transaction> transactions;
    }
    @Getter
    public static class Transaction{
        public String id;
        @SerializedName("owner_id")
        public String ownerId;
        @SerializedName("card_id")
        public String cardId;
        @SerializedName("session_id")
        public String sessionId;
        @SerializedName("tokenization_id")
        public String tokenizationId;
        public String action;
        public Integer amount;
        public String date;
        @SerializedName("order_id")
        public String orderId;
    }
}
