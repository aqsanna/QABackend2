package dataProviders;
import Utils.RandomGenerateMethods;
import helpers.RequestPackaging;
import models.requests.packaging.*;
import enums.User;
import java.util.ArrayList;


public class PackagingProvider {
    public static PackagingCreate createPack(User email) {
        ArrayList<PackagingCreate.Box> boxes = new ArrayList<>();
        boxes.add(new PackagingCreate.Box()
                .withStore_id(User.STORE.getUserData())
                .withName(User.BOXNAME.getUserData() + RandomGenerateMethods.randomString(5))
                .withLength(RandomGenerateMethods.randomIntegerOneToNine())
                .withWidth(RandomGenerateMethods.randomIntegerOneToNine())
                .withHeight(RandomGenerateMethods.randomIntegerOneToNine())
                .withWeight(RandomGenerateMethods.randomIntegerOneToNine())
                .withFreeVolumeReserve(RandomGenerateMethods.randomIntegerOneToNine())
                .withSpecialEntityTypeId("1")
                .withStoreId(User.STORE.getUserData())
                .build());
        ArrayList<PackagingCreate.Pack> packs = new ArrayList<>();
        packs.add(new PackagingCreate.Pack()
                .withName(User.PACKNAME.getUserData() + RandomGenerateMethods.randomString(5))
                .withPrice(User.VALUE.getUserData())
                .withFreeCount(RandomGenerateMethods.randomIntegerOneToNine())
                .withUpc(RandomGenerateMethods.randomString(5))
                .withSpecialEntityTypeId("2")
                .withStoreId(User.STORE.getUserData())
                .build());
        return new PackagingCreate(boxes, packs, Boolean.parseBoolean(User.PICKUPBYDRIVER.getUserData()),
                Boolean.parseBoolean(User.ADVENCEDCOLLECTINGFLOW.getUserData()));
    }

    public static PackagingUpdate updatePacking(User email){
        ArrayList<PackagingUpdate.Box> boxesUpdate = new ArrayList<>();
        boxesUpdate.add(new PackagingUpdate.Box()
                .withId((RequestPackaging.getPackagingBoxId()))
                .withStore_id(User.STORE.getUserData())
                .withName(User.BOXNAME.getUserData()+ RandomGenerateMethods.randomString(6))
                .withLength(RandomGenerateMethods.randomIntegerOneToNine())
                .withWidth(RandomGenerateMethods.randomIntegerOneToNine())
                .withHeight(RandomGenerateMethods.randomIntegerOneToNine())
                .withWeight(RandomGenerateMethods.randomIntegerOneToNine())
                .withFreeVolumeReserve(RandomGenerateMethods.randomIntegerOneToNine())
                .withSpecialEntityTypeId("2")
                .withStoreId(User.STORE.getUserData())
                .build());
        ArrayList<PackagingUpdate.Pack> packingUpdate = new ArrayList<>();
        packingUpdate.add(new PackagingUpdate.Pack()
                .withId(RequestPackaging.getPackagingId())
                .withName(User.PACKNAME.getUserData() + RandomGenerateMethods.randomString(6))
                .withPrice(User.VALUE.getUserData())
                .withFreeCount(RandomGenerateMethods.randomIntegerOneToNine())
                .withUpc(RandomGenerateMethods.randomString(3))
                .withSpecialEntityTypeId("8")
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
