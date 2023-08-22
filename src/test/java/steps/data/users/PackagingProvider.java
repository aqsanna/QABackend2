package steps.data.users;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.packaging.*;
import responses.packaging.PackagingForStore;
import storage.ApiV1;
import storage.ApiV2;
import storage.User;
import java.util.ArrayList;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PackagingProvider {
    public static PackagingCreate createPack(User email) {
        ArrayList<PackagingCreate.Box> boxes = new ArrayList<>();
        boxes.add(new PackagingCreate.Box()
                .withStore_id(User.STORE.getUserData())
                .withName(User.BOXNAME.getUserData() + randomString(5))
                .withLength(random())
                .withWidth(random())
                .withHeight(random())
                .withWeight(random())
                .withFreeVolumeReserve(random())
                .withSpecialEntityTypeId("1")
                .withStoreId(User.STORE.getUserData())
                .build());
        ArrayList<PackagingCreate.Pack> packs = new ArrayList<>();
        packs.add(new PackagingCreate.Pack()
                .withName(User.PACKNAME.getUserData() + randomString(5))
                .withPrice(User.VALUE.getUserData())
                .withFreeCount(random())
                .withUpc(randomString(5))
                .withSpecialEntityTypeId("2")
                .withStoreId(User.STORE.getUserData())
                .build());


        return new PackagingCreate(boxes, packs, Boolean.parseBoolean(User.PICKUPBYDRIVER.getUserData()),
                Boolean.parseBoolean(User.ADVENCEDCOLLECTINGFLOW.getUserData()));
    }

    public static PackagingUpdate updatePacking(User email){
        ArrayList<PackagingUpdate.Box> boxesUpdate = new ArrayList<>();
        boxesUpdate.add(new PackagingUpdate.Box()
                .withId(Integer.parseInt(getPackagingId()))
                .withStore_id(User.STORE.getUserData())
                .withName(User.BOXNAME.getUserData()+ randomString(6))
                .withLength(random())
                .withWidth(random())
                .withHeight(random())
                .withWeight(random())
                .withFreeVolumeReserve(random())
                .withSpecialEntityTypeId("2")
                .withStoreId(User.STORE.getUserData())
                .build());
        ArrayList<PackagingUpdate.Pack> packingUpdate = new ArrayList<>();
        packingUpdate.add(new PackagingUpdate.Pack()
                .withId(Integer.parseInt(getPackagingId()))
                .withName(User.PACKNAME.getUserData() + randomString(6))
                .withPrice(User.VALUE.getUserData())
                .withFreeCount(random())
                .withUpc(randomString(3))
                .withSpecialEntityTypeId("3")
                .withStoreId(User.STORE.getUserData())
                .build());

        return new PackagingUpdate(boxesUpdate, packingUpdate, false, false);

    }

    public static PackagingDelete deletePacking(User email){
        return new PackagingDelete( false, false);
    }

    public static PackagingErrorMessages checkErrorMessages(User email) {
        ArrayList<PackagingErrorMessages.Box> boxesMessages = new ArrayList<>();
        boxesMessages.add(new PackagingErrorMessages.Box()
                .withFreeVolumeReserve(random())
                .withSpecialEntityTypeId("1")
                .withWeight(random())
                .build());
        ArrayList<PackagingErrorMessages.Pack> packsMessages = new ArrayList<>();
        packsMessages.add(new PackagingErrorMessages.Pack()
                .withSpecialEntityTypeId("2")
                .build());


        return new PackagingErrorMessages(boxesMessages, packsMessages, Boolean.parseBoolean(User.PICKUPBYDRIVER.getUserData()),
                Boolean.parseBoolean(User.ADVENCEDCOLLECTINGFLOW.getUserData()));
    }

    public static PackagingErrorMessagesForInvalidCredential checkErrorMessagesForInvalidCredential(User email) {
        ArrayList<PackagingErrorMessagesForInvalidCredential.Box> boxesMessages = new ArrayList<>();
        boxesMessages.add(new PackagingErrorMessagesForInvalidCredential.Box()
                        .withLength(randomMinus())
                        .withWidth(randomMinus())
                        .withHeight(randomMinus())
                        .withWeight(randomMinus())
                        .withFreeVolumeReserve(randomMinus())
                        .withSpecialEntityTypeId("-1")
                        .build());
        ArrayList<PackagingErrorMessagesForInvalidCredential.Pack> packsMessages = new ArrayList<>();
        packsMessages.add(new PackagingErrorMessagesForInvalidCredential.Pack()
                        .withFreeCount(randomMinus())
                        .withPrice("-5")
                        .withSpecialEntityTypeId("-2")
                        .build());
        return new PackagingErrorMessagesForInvalidCredential(boxesMessages, packsMessages, 3, 4);
    }


    public static Integer random() {
        Random ran = new Random();
        int x = ran.nextInt(9) + 1;
        return x;
    }

    public static Integer randomMinus() {
        Random ran = new Random();
        int x = ran.nextInt(9) + 1;
        return -x;
    }
    public static String getPackagingId(){
        Gson gson = new Gson();
        PackagingForStore  packingForStore = given()
                .header(new Header("Authorization",  "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(PackagingProvider.createPack(User.EMAIL_INFO))
                .put(ApiV1.STAGE.getApi() + ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);
        ArrayList<PackagingForStore.Data.Pack> packId = packingForStore.data.getPacks();
        return  packId.get(0).id;
    }
    public static String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
