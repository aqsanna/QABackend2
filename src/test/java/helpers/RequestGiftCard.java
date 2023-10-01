package helpers;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.giftCard.GiftCardDetails;
import models.responses.giftCard.GiftCardDisable;
import models.responses.giftCard.GiftCardList;
import models.responses.giftCard.SuccessCreateGiftCard;
import dataProviders.GiftCardInfoProvider;
import dataProviders.UserInfoProvider;
import enums.User;

import static io.restassured.RestAssured.given;

public class RequestGiftCard {
    public SuccessCreateGiftCard putRequestCreateGiftCard(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(GiftCardInfoProvider.createGift(User.EMAIL_INFO))
                .put(path + url)
                .then()
                .extract().as(SuccessCreateGiftCard.class);
    }
    public GiftCardList postRequestListGiftCard(String path, String url){
        return  given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((GiftCardInfoProvider.giftCardList(User.EMAIL_INFO)))
                .post(path + url)
                .then()
                .extract().as(GiftCardList.class);
    }
    public GiftCardDetails requestGiftCardDetails(String path, String url, String giftCard){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(path + url + giftCard)
                .then().log().all()
                .extract().as(GiftCardDetails.class);
    }
    public GiftCardDisable requestGiftCardDisable(String path, String url, String giftCard){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(GiftCardInfoProvider.disableGift(User.EMAIL_INFO))
                .put(path + url + giftCard)
                .then()
                .extract().as(GiftCardDisable.class);
    }
}
