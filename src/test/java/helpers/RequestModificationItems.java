package helpers;

import com.google.gson.Gson;
import models.responses.modificationItems.ModificationItemErrorMsg;
import models.responses.modificationItems.SuccessCreateModificationItems;
import dataProviders.ModificationItemsProvider;
import enums.User;



public class RequestModificationItems extends AbstractRequest {

    Gson gson = new Gson();

    public SuccessCreateModificationItems requestPost(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.createModification(User.EMAIL_INFO)))
                .put(url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public SuccessCreateModificationItems requestPostText(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.createModificationText(User.EMAIL_INFO)))
                .put(url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
    public ModificationItemErrorMsg requestPutErrorMsgInvalidCredential(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(ModificationItemsProvider.errorMessageModificationItemInvalidCredential(User.EMAIL_INFO)))
                .put(url)
                .then()
                .extract().as(ModificationItemErrorMsg.class);
    }
}
