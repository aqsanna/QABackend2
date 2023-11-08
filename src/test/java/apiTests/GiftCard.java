package apiTests;

import assertions.AssertionForGiftCard;
import assertions.AssertionForMessages;
import helpers.RequestGiftCard;
import org.junit.jupiter.api.*;
import models.responses.giftCard.GiftCardDetails;
import models.responses.giftCard.GiftCardDisable;
import models.responses.giftCard.GiftCardList;
import models.responses.giftCard.SuccessCreateGiftCard;
import dataProviders.GiftCardInfoProvider;
import enums.ApiV2;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GiftCard {
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    RequestGiftCard requestGiftCard = new RequestGiftCard();
    AssertionForGiftCard assertionForGiftCard = new AssertionForGiftCard();

    @Test
    @Order(1)
    @DisplayName("Check create gift-card")
    public void CreateGiftCard() {

        SuccessCreateGiftCard successCreateGiftCard = requestGiftCard.putRequestCreateGiftCard(ApiV2.GIFT_CARD_CREATE.getApi());
        assertionForMessages.assertRequestMessageAndCode(successCreateGiftCard.getMessage(), successCreateGiftCard.getCode());
        Assertions.assertFalse(successCreateGiftCard.getData().isEmpty());
    }
    @Test
    @Order(2)
    @DisplayName("Check list gift-card")
    public void GiftCardList() {

        GiftCardList giftCardList = requestGiftCard.postRequestListGiftCard(ApiV2.GIFT_CARD_LIST.getApi());
        assertionForMessages.assertRequestMessageAndCode(giftCardList.getMessage(), giftCardList.getCode());
        assertionForGiftCard.assertCheckGiftCardList(giftCardList.data.getResult());
    }

    @Test
    @Order(3)
    @DisplayName("Check details gift-card")
    public void GiftCardDetails() {

        GiftCardDetails giftCardDetails = requestGiftCard.requestGiftCardDetails(ApiV2.GIFT_CARD.getApi(),RequestGiftCard.requestGiftCard());
        assertionForMessages.assertRequestMessageAndCode(giftCardDetails.getMessage(), giftCardDetails.getCode());
        assertionForGiftCard.assertGiftCardDetails(giftCardDetails);
        assertionForGiftCard.assertGiftCardDetailsTransaction(giftCardDetails.data.getTransactions());
    }


    @Test
    @Order(4)
    @DisplayName("Check disable gift-card")
    public void GiftCardDisable() {
        GiftCardDisable giftCardDisable = requestGiftCard.requestGiftCardDisable(ApiV2.GIFT_CARD.getApi(), RequestGiftCard.requestGiftCard());
        assertionForMessages.assertRequestMessageAndCode(giftCardDisable.getMessage(), giftCardDisable.getCode());
        Assertions.assertTrue(giftCardDisable.isData());
    }
}
