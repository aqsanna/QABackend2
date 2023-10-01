package assertions;

import org.junit.jupiter.api.Assertions;
import models.responses.giftCard.GiftCardDetails;
import models.responses.giftCard.GiftCardList;

import java.util.ArrayList;

public class AssertionForGiftCard {
    public void assertCheckGiftCardList(ArrayList<GiftCardList.Result> giftList){
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
    public void assertGiftCardDetails(GiftCardDetails giftCardDetails){
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
    }
    public void assertGiftCardDetailsTransaction( ArrayList<GiftCardDetails.Transaction> transactions ){
        for (GiftCardDetails.Transaction tran : transactions) {
            Assertions.assertFalse(tran.id.isEmpty(), "id is empty");
            Assertions.assertFalse(tran.ownerId.isEmpty(), "ownerId is empty");
            Assertions.assertFalse(tran.cardId.isEmpty(), "cardId is empty");
            Assertions.assertEquals("insert", tran.action);
            Assertions.assertFalse(tran.amount.toString().isEmpty(), "amount is empty");
            Assertions.assertFalse(tran.date.toString().isEmpty(), "date is empty");
        }
    }
}
