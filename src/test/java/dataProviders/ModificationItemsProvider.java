package dataProviders;

import Utils.RandomGenerateMethods;
import enums.ApiV1;
import enums.ApiV2;
import helpers.RequestModificationItems;
import helpers.RequestTags;
import models.requests.modifications.*;
import enums.User;
import models.requests.tag.CreateTagsInvalidCredential;
import models.responses.modificationItems.ModificationItemsList;
import models.responses.tags.TagsList;

import java.util.ArrayList;
import java.util.Arrays;

public class ModificationItemsProvider {
    public static CreateModificationItems createModification(User email,Boolean text, String name, Integer price, String upc) {
        return switch (email) {
            case EMAIL_INFO -> new CreateModificationItems(
                     text
                    , User.REGULARTYPE.getUserData()
                    , text
                    , name
                    , name
                    , price
                    , upc
                    , User.MODIFICATIONIMAGE.getUserData()
                    , User.STORE.getUserData());
            default -> null;
        };
    }

    public static CreateModificationItemsText createModificationText(User email, Boolean text, String name, String description,
                                                                     String minLength,Integer maxLength, Integer number, String upc) {
         return switch (email) {
            case EMAIL_INFO -> new CreateModificationItemsText(
                      text
                    , User.TEXTTYPE.getUserData()
                    , text
                    , name
                    , description
                    , minLength
                    , maxLength
                    , number
                    , upc
                    , User.MODIFICATIONIMAGE.getUserData()
                    , User.STORE.getUserData());
            default -> null;
        };
    }

    public static CreateModificationItemsImage createModificationImage(User email, Boolean text, String title, String description,
                                                                       Integer number, String upc) {
//        ArrayList<String> taxesListForTax = new ArrayList<>(Arrays.asList("268", "11", "10"));
        return switch (email) {
            case EMAIL_INFO -> new CreateModificationItemsImage(
                      text
                    , User.IMAGETYPE.getUserData()
                    , text
                    , title
                    , description
                    , number
                    , upc
                    , User.MODIFICATIONIMAGE.getUserData()
                    , User.STORE.getUserData());
            default -> null;
        };
    }
    public static UpdateModificationItems updateModification(User email, Boolean text, String name, String description,
                                                             String minLength, Integer maxLength,Integer number, String upc) {
        return switch (email) {
            case EMAIL_INFO -> new UpdateModificationItems(
                     RequestModificationItems.modificationItemId()
                    ,User.STORE.getUserData()
                    ,number
                    , upc
                    , User.TEXTTYPE.getUserData()
                    , User.MODIFICATIONIMAGE.getUserData()
                    , name
                    , description
                    , text
                    , text
                    , minLength
                    , maxLength);
            default -> null;
        };
    }
    public static CreateModificationItemInvalidCredential errorMessageModificationItemInvalidCredential(User email, Integer number, String price) {
        return switch (email) {
            case EMAIL_INFO -> new CreateModificationItemInvalidCredential(
                      number
                    , User.REGULARTYPE.getUserData() + RandomGenerateMethods.randomString(5)
                    , number
                    , null
                    , price);
            default -> null;
        };
    }

    public static ModificationInfo listModificationItems(User email) {
        return switch (email) {
            case EMAIL_INFO -> new ModificationInfo(
                    "basic"
                  );
            default -> null;
        };
    }

    public static Integer assertResultsMaxId() {
        RequestModificationItems postRequest =  new RequestModificationItems();
        ModificationItemsList ModList = postRequest.requestPostModList(ApiV2.MODIFICATIONITEM.getApi());
        int maxId = Integer.MIN_VALUE;
        for (ModificationItemsList.Data.Result result : ModList.getData().getResult()) {
            int id = Integer.parseInt(result.getId());
            if (id > maxId) {
                maxId = id;
            }
        }
        System.out.println("Max id: " + maxId);
        return maxId;
    }
}
