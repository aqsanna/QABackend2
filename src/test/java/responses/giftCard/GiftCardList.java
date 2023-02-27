package responses.giftCard;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GiftCardList {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;

    @Getter
    public static class Data {
        @SerializedName("result")
        public ArrayList<Result> result;
        @SerializedName("_meta")
        public Meta meta;
    }

    @Getter
    public static class Meta {
        public Integer totalCount;
    }

    @Getter
    public static class Result {
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
}



