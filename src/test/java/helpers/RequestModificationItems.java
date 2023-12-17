package helpers;

import Utils.RandomGenerateMethods;
import com.google.gson.Gson;
import dataProviders.GiftCardInfoProvider;
import enums.ApiV2;
import models.requests.modifications.UpdateModificationItems;
import models.responses.giftCard.GiftCardList;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.modificationItems.ModificationItemsList;
import models.responses.modificationItems.SuccessCreateModificationItems;
import dataProviders.ModificationItemsProvider;
import enums.User;

import java.util.ArrayList;


public class RequestModificationItems extends AbstractRequest {

    Gson gson = new Gson();
    public static String randomText = RandomGenerateMethods.randomString(5);
    public static Integer randomPrice = RandomGenerateMethods.randomIntegerOneToNine();
    public static  String randomUpc = RandomGenerateMethods.randomString(20);
    public static Boolean randomBool = RandomGenerateMethods.generateRandomBoolean();
    public static String randomDescription = RandomGenerateMethods.randomString(20);
    public static String randomMinLength = RandomGenerateMethods.randomOneToNine();

    public SuccessCreateModificationItems requestPost(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.createModification(User.EMAIL_INFO, randomBool, randomText, randomPrice, randomUpc)))
                .put(url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public SuccessCreateModificationItems requestPostText(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.createModificationText(User.EMAIL_INFO, randomBool, randomText,randomDescription, randomMinLength, randomPrice, randomUpc)))
                .put(url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public SuccessCreateModificationItems requestPostImage(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.createModificationImage(User.EMAIL_INFO, randomBool, randomText,randomDescription, randomPrice, randomUpc)))
                .put(url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public SuccessCreateModificationItems updateItems(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.updateModification(User.EMAIL_INFO, randomBool, randomText,randomDescription,randomMinLength, randomPrice, randomUpc)))
                .put(url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public ModificationItemErrorMsg requestPutErrorMsgInvalidCredential(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.errorMessageModificationItemInvalidCredential(User.EMAIL_INFO, randomPrice,randomText )))
                .put(url)
                .then()
                .extract().as(ModificationItemErrorMsg.class);
    }
    public ModificationItemsList modificationItemsList(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.listModificationItems(User.EMAIL_INFO)))
                .post(url)
                .then()
                .extract().as(ModificationItemsList.class);
    }

    public static String modificationItemId(){
        ModificationItemsList itemsList = baseAuthorizedRequest()
                .body((ModificationItemsProvider.listModificationItems(User.EMAIL_INFO)))
                .post(ApiV2.MODIFICATIONITEM.getApi())
                .then()
                .extract().as(ModificationItemsList.class);
        ModificationItemsList.Data.Result list = itemsList.getData().getResult().get(0);
        return list.id;
    }
}
