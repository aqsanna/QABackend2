package apiTests;

import assertions.AssertionForGiftCard;
import assertions.AssertionForMessages;
import httpRequest.RequestGiftCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.giftCard.GiftCardDetails;
import responses.giftCard.GiftCardDisable;
import responses.giftCard.GiftCardList;
import responses.giftCard.SuccessCreateGiftCard;
import steps.data.users.GiftCardInfoProvider;
import storage.ApiV1;
import storage.ApiV2;

public class GiftCard {
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    RequestGiftCard requestGiftCard = new RequestGiftCard();
    AssertionForGiftCard assertionForGiftCard = new AssertionForGiftCard();

    @Test
    @DisplayName("Check create gift-card")
    public void CreateGiftCard() {

        SuccessCreateGiftCard successCreateGiftCard = requestGiftCard.putRequestCreateGiftCard(ApiV1.STAGE.getApi(), ApiV2.GIFT_CARD_CREATE.getApi());
        assertionForMessages.assertRequestMessageAndCode(successCreateGiftCard.getMessage(), successCreateGiftCard.getCode());
        Assertions.assertFalse(successCreateGiftCard.getData().isEmpty());
    }
    @Test
    @DisplayName("Check list gift-card")
    public void GiftCardList() {

        GiftCardList giftCardList = requestGiftCard.postRequestListGiftCard(ApiV1.STAGE.getApi() , ApiV2.GIFT_CARD_LIST.getApi());
        assertionForMessages.assertRequestMessageAndCode(giftCardList.getMessage(), giftCardList.getCode());
        assertionForGiftCard.assertCheckGiftCardList(giftCardList.data.getResult());
    }

    @Test
    @DisplayName("Check details gift-card")
    public void GiftCardDetails() {

        GiftCardDetails giftCardDetails = requestGiftCard.requestGiftCardDetails(ApiV1.STAGE.getApi(), ApiV2.GIFT_CARD.getApi(), GiftCardInfoProvider.getGiftCard());
        assertionForMessages.assertRequestMessageAndCode(giftCardDetails.getMessage(), giftCardDetails.getCode());
        assertionForGiftCard.assertGiftCardDetails(giftCardDetails);
        assertionForGiftCard.assertGiftCardDetailsTransaction(giftCardDetails.data.getTransactions());
    }

    @Test
    @DisplayName("Check disable gift-card")
    public void GiftCardDisable() {
        GiftCardDisable giftCardDisable = requestGiftCard.requestGiftCardDisable(ApiV1.STAGE.getApi(), ApiV2.GIFT_CARD.getApi() ,GiftCardInfoProvider.getGiftCard());
        assertionForMessages.assertRequestMessageAndCode(giftCardDisable.getMessage(), giftCardDisable.getCode());
        Assertions.assertTrue(giftCardDisable.isData());
    }
}
