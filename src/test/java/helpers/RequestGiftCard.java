package helpers;

import Utils.RandomGenerateMethods;
import config.Configurations;
import dataProviders.UserInfoProvider;
import enums.ApiV2;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.giftCard.*;
import dataProviders.GiftCardInfoProvider;
import enums.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RequestGiftCard extends AbstractRequest {

    public static Integer randomNumber = RandomGenerateMethods.randomIntegerOneToNine();
    public static String randomHolder = RandomGenerateMethods.randomString(5);
    public SuccessCreateGiftCard putRequestCreateGiftCard(String url){
        return baseAuthorizedRequest()
                .body(GiftCardInfoProvider.createGift(User.EMAIL_INFO, randomNumber, randomHolder))
                .put(url)
                .then()
                .extract().as(SuccessCreateGiftCard.class);
    }

    public GiftCardErrorMsg  putRequestCreateGiftCardMsg (String url){
        return baseAuthorizedRequest()
                .body(GiftCardInfoProvider.giftCardMsg(User.EMAIL_INFO))
                .put(url)
                .then()
                .extract().as(GiftCardErrorMsg.class);
    }
    public GiftCardList postRequestListGiftCard(String url){
        return  baseAuthorizedRequest()
                .body((GiftCardInfoProvider.giftCardList(User.EMAIL_INFO)))
                .post(url)
                .then()
                .extract().as(GiftCardList.class);
    }
    public GiftCardDetails requestGiftCardDetails(String url, String giftCard){
        return baseAuthorizedRequest()
                .get(url + giftCard)
                .then().log().all()
                .extract().as(GiftCardDetails.class);
    }
    public GiftCardDisable requestGiftCardDisable(String url, String giftCard){
        return baseAuthorizedRequest()
                .body(GiftCardInfoProvider.disableGift(User.EMAIL_INFO))
                .put(url + giftCard)
                .then()
                .extract().as(GiftCardDisable.class);
    }

    public static String requestGiftCard(){
        GiftCardList giftCardList = baseAuthorizedRequest()
                .body((GiftCardInfoProvider.giftCardList(User.EMAIL_INFO)))
                .post(ApiV2.GIFT_CARD_LIST.getApi())
                .then()
                .extract().as(GiftCardList.class);
        ArrayList<GiftCardList.Result> giftList = giftCardList.data.getResult();
        return giftList.get(0).id;
    }
    public static String getGiftCard() {
        GiftCardList giftCardList = baseAuthorizedRequest()
                .body((GiftCardInfoProvider.giftCardList(User.EMAIL_INFO)))
                .post(ApiV2.GIFT_CARD_LIST.getApi())
                .then()
                .extract().as(GiftCardList.class);
        ArrayList<GiftCardList.Result> giftList = giftCardList.data.getResult();
        return giftList.get(0).id;
    }
}
