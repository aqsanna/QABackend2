package steps.data.users;

import Utils.RandomGenerateMethods;
import requests.modificationItems.CreateModificationItems;
import requests.modificationItems.CreateModificationItemsText;
import storage.User;

import java.util.ArrayList;
import java.util.Arrays;

public class ModificationItemsProvider {
    public static CreateModificationItems createModification(User email) {
        ArrayList<String> taxesList = new ArrayList<>(Arrays.asList("268", "11", "10"));
        return switch (email) {
            case EMAIL_INFO -> new CreateModificationItems(
                     1
                    , User.REGULARTYPE.getUserData()
                    , 1
                    , RandomGenerateMethods.randomString(10)
                    , RandomGenerateMethods.randomString(10)
                    , RandomGenerateMethods.randomIntegerOneToNine()
                    , taxesList
                    , RandomGenerateMethods.randomString(5)
                    , User.MODIFICATIONIMAGE.getUserData()
                    , User.STORE_ID.getUserData());
            default -> null;
        };
    }

    public static CreateModificationItemsText createModificationText(User email) {
        ArrayList<String> taxesListForTax = new ArrayList<>(Arrays.asList("268", "11", "10"));
        return switch (email) {
            case EMAIL_INFO -> new CreateModificationItemsText(
                    1
                    , User.TEXTTYPE.getUserData()
                    , 1
                    , RandomGenerateMethods.randomString(10)
                    , RandomGenerateMethods.randomString(10)
                    , RandomGenerateMethods.randomOneToNine()
                    , RandomGenerateMethods.randomInteger()
                    , RandomGenerateMethods.randomIntegerOneToNine()
                    , taxesListForTax
                    , RandomGenerateMethods.randomString(5)
                    , User.MODIFICATIONIMAGE.getUserData()
                    , User.STORE_ID.getUserData());
            default -> null;
        };
    }
}
