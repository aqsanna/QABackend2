package helpers;

import com.google.gson.Gson;
import config.Configurations;
import dataProviders.UserInfoProvider;
import enums.ApiV1;
import enums.ApiV2;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.responses.packaging.PackagingErrorMsg;
import models.responses.packaging.PackagingForStore;
import dataProviders.PackagingProvider;
import enums.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


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
    public static String getPackagingId(){
        Gson gson = new Gson();
        PackagingForStore  packingForStore = baseAuthorizedRequest()
                .body(PackagingProvider.createPack(User.EMAIL_INFO))
                .put(ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);
        ArrayList<PackagingForStore.Data.Pack> packId = packingForStore.data.getPacks();
        return  packId.get(0).id;
    }
    public static Integer getPackagingBoxId(){
        PackagingForStore  packingForStore =baseAuthorizedRequest()
                .body(PackagingProvider.createPack(User.EMAIL_INFO))
                .put(ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);
        ArrayList<PackagingForStore.Data.Box> boxId = packingForStore.data.getBoxes();
        return  boxId.get(0).id;
    }

}
