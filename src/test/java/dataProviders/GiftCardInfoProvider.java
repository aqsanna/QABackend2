package dataProviders;

import Utils.RandomGenerateMethods;
import models.requests.giftCards.GiftCardCreate;
import models.requests.giftCards.GiftCardDisable;
import models.responses.giftCard.GiftCardList;
import enums.User;

public class GiftCardInfoProvider {

public static GiftCardCreate createGift(User email){
    return switch (email){
        case EMAIL_INFO -> new GiftCardCreate(
                 User.CURRENCY.getUserData()
                ,User.EXPIRATIONDATE.getUserData()
                ,RandomGenerateMethods.randomIntegerOneToNine()
                ,RandomGenerateMethods.randomString(5)
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
}
