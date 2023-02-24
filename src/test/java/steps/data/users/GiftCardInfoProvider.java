package steps.data.users;

import requests.GiftCardCreate;
import storage.User;

import java.util.Random;

public class GiftCardInfoProvider {

public static GiftCardCreate createGift(User email){
    return switch (email){
        case EMAIL_INFO -> new GiftCardCreate(
                User.CURRENCY.getUserData()
                , User.EXPIRATIONDATE.getUserData()
                ,random()
                ,randomString(10)
                ,User.EMAIL_CLIENT.getUserData()
                ,User.PHONE.getUserData());
        default -> null;
    };
}

    public static Integer random() {
        Random ran = new Random();
        int x = ran.nextInt(10);
        return x;
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
