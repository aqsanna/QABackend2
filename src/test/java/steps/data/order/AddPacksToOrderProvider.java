package steps.data.order;

import org.apache.commons.lang3.RandomStringUtils;
import requests.order.AddPack;
import requests.order.AddPackLocation;
import requests.order.PrintPackLocation;
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
    public static ArrayList<AddPackLocation> addPackLocations(USER email, String id, String packId, String placementId) {
        AddPackLocation location = new AddPackLocation(id, packId, RandomStringUtils.randomAlphanumeric(4), placementId);
        ArrayList<AddPackLocation> locationArrayList = new ArrayList<>();
        locationArrayList.add(location);
        return  switch (email) {
            case EMAIL_INFO -> locationArrayList;
            default -> null;
        };
    }

    public static PrintPackLocation printPackLocation(USER email, String cloudPrinterId){
        return switch (email) {
            case EMAIL_INFO -> new PrintPackLocation(cloudPrinterId);
            default -> null;
        };
    }
}
