package helpers;

import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import dataProviders.PackagingProvider;
import enums.User;


public class RequestPackaging extends AbstractRequest {

    public PackagingForStore requestCreate( String url) {

        return baseAuthorizedRequest()
                .body((PackagingProvider.createPack(User.EMAIL_INFO)))
                .put(url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }

    public PackagingForStore requestUpdate(String url) {

        return  baseAuthorizedRequest()
                .body((PackagingProvider.updatePacking(User.EMAIL_INFO)))
                .put(url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }
    public PackagingErrorMsg requestPutErrorMsg(String url) {

        return  baseAuthorizedRequest()
                .body((PackagingProvider.checkErrorMessages(User.EMAIL_INFO)))
                .put(url)
                .then().log().all()
                .extract().as(PackagingErrorMsg.class);
    }
    public PackagingErrorMsg requestPutErrorMsgForInvalidCredential(String url) {

        return  baseAuthorizedRequest()
                .body((PackagingProvider.checkErrorMessagesForInvalidCredential(User.EMAIL_INFO)))
                .put(url)
                .then().log().all()
                .extract().as(PackagingErrorMsg.class);
    }

    public PackagingForStore requestDel(String url) {

        return  baseAuthorizedRequest()
                .body((PackagingProvider.deletePacking(User.EMAIL_INFO)))
                .put(url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }
}
