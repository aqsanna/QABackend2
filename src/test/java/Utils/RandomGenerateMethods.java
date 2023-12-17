package Utils;

import java.util.Random;

public class RandomGenerateMethods {

    public static Integer randomIntegerOneToNine() {
        Random ran = new Random();
        int x = ran.nextInt(9) + 1;
        return x;
    }
    public static Double randomDoubleOneToNine() {
        Random ran = new Random();
        double x = ran.nextDouble(9) + 1;
        return x;
    }
    public static Integer randomInteger() {
        Random ran = new Random();
        int x = ran.nextInt(99999) + 1;
        return x;
    }
    public static String randomOneToNine() {
        Random ran = new Random();
        int x = ran.nextInt(9);
        return Integer.toString(x);
    }
    public static String random() {
        Random ran = new Random();
        int x = ran.nextInt(999999999);
        return Integer.toString(x);
    }
    public static Integer randomMinusIntegerOneToNine() {
        Random ran = new Random();
        int x = ran.nextInt(9) + 1;
        return -x;
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
    public static String randomGenerateName(String baseName) {
        return baseName + RandomGenerateMethods.randomString(5);
    }
    public static Boolean generateRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
