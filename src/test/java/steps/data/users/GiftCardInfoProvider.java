package steps.data.users;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.giftCard.GiftCardCreate;
import requests.giftCard.GiftCardDisable;
import responses.giftCard.GiftCardList;
import storage.ApiV1;
import storage.ApiV2;
import storage.User;

import java.util.ArrayList;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class GiftCardInfoProvider {

public static GiftCardCreate createGift(User email){
    return switch (email){
        case EMAIL_INFO -> new GiftCardCreate(
                 User.CURRENCY.getUserData()
                ,User.EXPIRATIONDATE.getUserData()
                ,random()
                ,randomString(5)
                ,User.EMAIL_CLIENT.getUserData()
                ,User.PHONE.getUserData());
        default -> null;
    };
}

    public static GiftCardList giftCardList(User email){
             return switch (email){
                 case EMAIL_INFO -> new GiftCardList(
                        );
                 default -> null;
             };
    }

    public static GiftCardDisable disableGift(User email){
        return switch (email){
            case EMAIL_INFO -> new GiftCardDisable(
                    User.GIFTCARDSTATUS.getUserData());
            default -> null;
        };
    }
    public static String getGiftCard() {
        Gson gson = new Gson();
        GiftCardList giftCardList = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((GiftCardInfoProvider.giftCardList(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV2.GIFT_CARD_LIST.getApi())
                .then()
                .extract().as(GiftCardList.class);
        ArrayList<GiftCardList.Result> giftList = giftCardList.data.getResult();
        return giftList.get(0).id;
    }

    public static Integer random() {
        Random ran = new Random();
        int x = ran.nextInt(9)+1;
        return x;
    }
    public static String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }


}
