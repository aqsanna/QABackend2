package helpers;

import Utils.RandomGenerateMethods;
import com.google.gson.Gson;
import enums.ApiV2;
import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import dataProviders.PackagingProvider;
import enums.User;

import java.util.ArrayList;
import java.util.List;


public class RequestPackaging extends AbstractRequest {

    public static String randomBoxName = RandomGenerateMethods.randomGenerateName(User.BOXNAME.getUserData());
    public static String randomPackName = RandomGenerateMethods.randomGenerateName(User.PACKNAME.getUserData());
    public static Integer randomNumber = RandomGenerateMethods.randomIntegerOneToNine();
    public static String randomUpc = RandomGenerateMethods.randomString(5);
    public static String randomBoxNameUpd = RandomGenerateMethods.randomGenerateName(User.BOXNAME.getUserData());
    public static String randomPackNameUpd = RandomGenerateMethods.randomGenerateName(User.PACKNAME.getUserData());
    public static Integer randomNumberUpd = RandomGenerateMethods.randomIntegerOneToNine();
    public static String randomUpcUpd = RandomGenerateMethods.randomString(6);
    public static String randomStringPrice = RandomGenerateMethods.randomOneToNine();
    public PackagingForStore requestCreate( String url) {

        return baseAuthorizedRequest()
                .body((PackagingProvider.createPack(User.EMAIL_INFO,randomBoxName, randomPackName, randomNumber, randomUpc)))
                .put(url)
                .then().log().all()
                .extract().as(PackagingForStore.class);
    }

    public PackagingForStore requestUpdate(String url) {

        return  baseAuthorizedRequest()
                .body((PackagingProvider.updatePacking(User.EMAIL_INFO, randomBoxNameUpd,randomPackNameUpd, randomNumberUpd,randomUpcUpd )))
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
    public static String getPackagingId(){
        Gson gson = new Gson();
        PackagingForStore  packingForStore = baseAuthorizedRequest()
                .body(PackagingProvider.createPack(User.EMAIL_INFO, randomBoxName, randomPackName, randomNumber, randomUpc))
                .put(ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);
        List<PackagingForStore.Data.Pack> packId = packingForStore.data.getPacks();
        return  packId.get(0).id;
    }
    public static Integer getPackagingBoxId(){
        PackagingForStore  packingForStore =baseAuthorizedRequest()
                .body(PackagingProvider.createPack(User.EMAIL_INFO, randomBoxName, randomPackName, randomNumber, randomUpc))
                .put(ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);
        List<PackagingForStore.Data.Box> boxId = packingForStore.data.getBoxes();
        return  boxId.get(0).id;
    }

}
