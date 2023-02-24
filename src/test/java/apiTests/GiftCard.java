package apiTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.giftCard.SuccessCreateGiftCard;
import steps.data.users.GiftCardInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.User;

public class GiftCard {


    @Test
    @DisplayName("Check create giftcard")
    public void CreateGiftCard(){
        Gson gson= new Gson();

        SuccessCreateGiftCard successCreateGiftCard = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(GiftCardInfoProvider.createGift(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV1.GIFT_CARD_CREATE)
                .then()
                .extract().as(SuccessCreateGiftCard.class);

        Assertions.assertEquals( "Ok", successCreateGiftCard.getMessage());
    }
}
