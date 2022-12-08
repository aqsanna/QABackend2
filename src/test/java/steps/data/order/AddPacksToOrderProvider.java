package steps.data.order;

import requests.AddPack;
import requests.OrderConfirm;
import storage.CollectingOrderValues;
import storage.USER;

import java.util.ArrayList;

public class AddPacksToOrderProvider {
    public static ArrayList<AddPack> addPack(USER email, String id, String qty) {
        AddPack pack = new AddPack(id,qty);
        ArrayList<AddPack> packs = new ArrayList<>();
        packs.add(pack);
//        switch (email) {
//            case EMAIL_INFO :
//                AddPack pack = new AddPack(id,qty);
//                ArrayList<AddPack> packList =  new ArrayList<AddPack>();
//                packList.add(pack);
//                packs = packList;
//            default -> null;
//        };
//        return packs;
        return packs;
    }
}
