package steps.data.order;

import org.apache.commons.lang3.RandomStringUtils;
import requests.order.AddPack;
import requests.order.PackLocation;
import storage.USER;

import java.util.ArrayList;

public class AddPacksToOrderProvider {
    public static ArrayList<AddPack> addPack(USER email, String id, String qty) {
        AddPack pack = new AddPack(id,qty);
        ArrayList<AddPack> packs = new ArrayList<>();
        packs.add(pack);
        return  switch (email) {
            case EMAIL_INFO -> packs;
            default -> null;
        };
    }
    public static ArrayList<PackLocation> packLocations(USER email, String id, String packId, String placementId) {
        PackLocation location = new PackLocation(id, packId, RandomStringUtils.randomAlphanumeric(4), placementId);
        ArrayList<PackLocation> locationArrayList = new ArrayList<>();
        locationArrayList.add(location);
        System.out.println(locationArrayList.get(0).getId());
        System.out.println(locationArrayList.get(0).getPackId());
        System.out.println(locationArrayList.get(0).getPlace());
        System.out.println(locationArrayList.get(0).getPlacementId());
        return  switch (email) {
            case EMAIL_INFO -> locationArrayList;
            default -> null;
        };
    }
}
