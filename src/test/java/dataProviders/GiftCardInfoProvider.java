package dataProviders;

import Utils.RandomGenerateMethods;
import models.requests.giftCards.GiftCardCreate;
import models.requests.giftCards.GiftCardDisable;
import models.requests.giftCards.GiftCardMsg;
import models.responses.giftCard.GiftCardList;
import enums.User;

public class GiftCardInfoProvider {

public static GiftCardCreate createGift(User email, Integer number, String holder){
    return switch (email){
        case EMAIL_INFO -> new GiftCardCreate(
                 User.CURRENCY.getUserData()
                ,User.EXPIRATIONDATE.getUserData()
                ,number
                ,holder
                ,User.EMAIL_CLIENT.getUserData()
                ,User.PHONE.getUserData()
                ,true);
        default -> null;
    };
}

public static GiftCardMsg giftCardMsg(User email){
    return switch (email){
        case EMAIL_INFO -> new GiftCardMsg(
                User.CURRENCY.getUserData()
                ,User.EXPIRATIONDATE.getUserData()
                , false);
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
