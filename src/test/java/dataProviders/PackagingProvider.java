package dataProviders;
import Utils.RandomGenerateMethods;
import helpers.RequestPackaging;
import lombok.Getter;
import models.requests.packaging.*;
import enums.User;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PackagingProvider {

    public static PackagingCreate createPack(User email, String boxName, String packName, Integer number, Double price, String weight, String upc) {
        PackagingCreate.Box box = new PackagingCreate.Box(
               "1",
                number,
                weight,
                boxName,
                weight,
                weight,
                weight);
        PackagingCreate.Pack pack = new PackagingCreate.Pack(
                "2",
                packName,
                price,
                number,
                upc);
        return new PackagingCreate(List.of(box), List.of(pack), Boolean.parseBoolean(User.PICKUPBYDRIVER.getUserData()),
                Boolean.parseBoolean(User.ADVENCEDCOLLECTINGFLOW.getUserData()));
    }

    public static PackagingUpdate updatePacking(User email,String boxName, String packName,  String weight, Double price, Integer number, String upc){

        PackagingUpdate.Box boxUpdate = new PackagingUpdate.Box(
                RequestPackaging.getPackagingBoxId(),
                User.STORE.getUserData(),
                boxName,
                weight,
                weight,
                weight,
                weight,
                weight,
               "2",
                User.STORE.getUserData());
        PackagingUpdate.Pack packUpdate = new PackagingUpdate.Pack(
                RequestPackaging.getPackagingId(),
                packName,
                price,
                number,
                upc,
                 "8",
                User.STORE.getUserData());
        return new PackagingUpdate(List.of(boxUpdate), List.of(packUpdate), false, false);
    }

    public static PackagingDelete deletePacking(User email){
        return new PackagingDelete( false, false);
    }

    public static PackagingErrorMessages checkErrorMessages(User email) {
        ArrayList<PackagingErrorMessages.Box> boxesMessages = new ArrayList<>();
        boxesMessages.add(new PackagingErrorMessages.Box()
                .withFreeVolumeReserve(RandomGenerateMethods.randomIntegerOneToNine())
                .withSpecialEntityTypeId("1")
                .withWeight(RandomGenerateMethods.randomIntegerOneToNine())
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
                        .withLength(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withWidth(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withHeight(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withWeight(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withFreeVolumeReserve(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withSpecialEntityTypeId("-1")
                        .build());
        ArrayList<PackagingErrorMessagesForInvalidCredential.Pack> packsMessages = new ArrayList<>();
        packsMessages.add(new PackagingErrorMessagesForInvalidCredential.Pack()
                        .withFreeCount(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withPrice("-5")
                        .withSpecialEntityTypeId("-2")
                        .build());
        return new PackagingErrorMessagesForInvalidCredential(boxesMessages, packsMessages, 3, 4);
    }
}
