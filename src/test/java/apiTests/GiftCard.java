package apiTests;

import assertions.AssertionForMessages;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.giftCard.GiftCardDetails;
import responses.giftCard.GiftCardDisable;
import responses.giftCard.GiftCardList;
import responses.giftCard.SuccessCreateGiftCard;
import steps.data.users.GiftCardInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;
import storage.ApiV2;
import storage.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GiftCard {
    Gson gson = new Gson();
    AssertionForMessages assertionForMessages = new AssertionForMessages();

    @Test
    @DisplayName("Check create gift-card")
    public void CreateGiftCard() {

        SuccessCreateGiftCard successCreateGiftCard = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(GiftCardInfoProvider.createGift(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.GIFT_CARD_CREATE.getApi())
                .then()
                .extract().as(SuccessCreateGiftCard.class);
        assertionForMessages.assertRequestMessageAndCode(successCreateGiftCard.getMessage(), successCreateGiftCard.getCode());
        Assertions.assertFalse(successCreateGiftCard.getData().isEmpty());
    }

    @Test
    @DisplayName("Check list gift-card")
    public void GiftCardList() {

        GiftCardList giftCardList = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((GiftCardInfoProvider.giftCardList(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV2.GIFT_CARD_LIST.getApi())
                .then()
                .extract().as(GiftCardList.class);
        assertionForMessages.assertRequestMessageAndCode(giftCardList.getMessage(), giftCardList.getCode());

        ArrayList<GiftCardList.Result> giftList = giftCardList.data.getResult();
        for (GiftCardList.Result result : giftList) {
            Assertions.assertFalse(result.appId.isEmpty(), "app_id is empty");
            Assertions.assertFalse(result.clientId.isEmpty(), "client_id is empty");
            Assertions.assertFalse(result.createdAt.toString().isEmpty(), "created_at is empty");
            Assertions.assertEquals("usd", result.currency);
            Assertions.assertFalse(result.currentBalance.toString().isEmpty(), "Balance is empty");
            Assertions.assertFalse(result.fdigit.isEmpty(), "fdigit is empty");
            Assertions.assertFalse(result.hash.isEmpty(), "hash is empty");
            Assertions.assertFalse(result.holder.isEmpty(), "holder is empty");
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertEquals(16, result.length);
            Assertions.assertFalse(result.phone.isEmpty(), "phone is empty");
            Assertions.assertFalse(result.value.toString().isEmpty(), "value is empty");

        }

    }

    @Test
    @DisplayName("Check details gift-card")
    public void GiftCardDetails() {

        GiftCardDetails giftCardDetails = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV2.GIFT_CARD.getApi() + GiftCardInfoProvider.getGiftCard())
                .then().log().all()
                .extract().as(GiftCardDetails.class);
        Assertions.assertEquals("Ok", giftCardDetails.getMessage());
        Assertions.assertEquals("OK", giftCardDetails.getCode());
        Assertions.assertFalse(giftCardDetails.data.card.appId.isEmpty(), "app_id is empty");
        Assertions.assertFalse(giftCardDetails.data.card.clientId.isEmpty(), "client_id is empty");
        Assertions.assertFalse(giftCardDetails.data.card.createdAt.isEmpty(), "createAt is empty");
        Assertions.assertEquals("usd", giftCardDetails.data.card.currency);
        Assertions.assertFalse(giftCardDetails.data.card.currentBalance.toString().isEmpty(), "balance is empty");
        Assertions.assertFalse(giftCardDetails.data.card.fdigit.isEmpty(), "fdigit is empty");
        Assertions.assertFalse(giftCardDetails.data.card.hash.isEmpty(), "hash is empty");
        Assertions.assertFalse(giftCardDetails.data.card.holder.isEmpty(), "holder is empty");
        Assertions.assertFalse(giftCardDetails.data.card.id.isEmpty(), "id is empty");
        Assertions.assertEquals(16, giftCardDetails.data.card.length);
        Assertions.assertFalse(giftCardDetails.data.card.phone.isEmpty(), "phone is empty");
        Assertions.assertFalse(giftCardDetails.data.card.value.toString().isEmpty(), "value is empty");

        ArrayList<GiftCardDetails.Transaction> transactions = giftCardDetails.data.getTransactions();
        for (GiftCardDetails.Transaction tran : transactions) {
            Assertions.assertFalse(tran.id.isEmpty(), "id is empty");
            Assertions.assertFalse(tran.ownerId.isEmpty(), "ownerId is empty");
            Assertions.assertFalse(tran.cardId.isEmpty(), "cardId is empty");
            Assertions.assertEquals("insert", tran.action);
            Assertions.assertFalse(tran.amount.toString().isEmpty(), "amount is empty");
            Assertions.assertFalse(tran.date.toString().isEmpty(), "date is empty");

        }
    }

    @Test
    @DisplayName("Check disable gift-card")
    public void GiftCardDisable() {
        GiftCardDisable giftCardDisable = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(GiftCardInfoProvider.disableGift(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.GIFT_CARD.getApi() + GiftCardInfoProvider.getGiftCard())
                .then()
                .extract().as(GiftCardDisable.class);

        Assertions.assertEquals("Ok", giftCardDisable.getMessage());
        Assertions.assertEquals("OK", giftCardDisable.getCode());
        Assertions.assertTrue(giftCardDisable.isData());
    }
}
