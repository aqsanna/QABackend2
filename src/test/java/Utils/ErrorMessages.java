package Utils;

public class ErrorMessages {
    public static String messageOk = "Ok";
    public static String codeOK = "OK";
    public static String codeUnprocessableEntity = "UNPROCESSABLE_ENTITY";
    public static  String messageForTags = "Please fix the following errors: Title cannot be blank., Partner Id must be either \"1\" or \"0\".," +
            " Status must be either \"1\" or \"0\"., Show Icon On Product must be either \"1\" or \"0\".";
    public static String messageForTagsTitle = "Please fix the following errors: Title cannot be blank.";
    public static String messageForPack = "Please fix the following errors: Box Name cannot be blank., Length cannot be blank., Width cannot be blank., " +
            "Height cannot be blank., Pack name cannot be blank., Price cannot be blank., Free pack quantity cannot be blank.";
    public static  String messageForPackInvalidCred = "Please fix the following errors: Box Name cannot be blank., Reserve (%) must be no less than 0., " +
            "Length must be no less than 9.0E-5., Width must be no less than 9.0E-5., Height must be no less than 9.0E-5., " +
            "Weight must be greater than or equal to \"0\"., Special Type must be no less than 0., Pack name cannot be blank., Price must be no less than 0., Free pack quantity must be no less than 0.";
    public static  String messageForModificationTitle = "Please fix the following errors: Type is invalid., Price Change must be a number., Is Instock must be either \"1\" or \"0\"., Is Multiline must be either \"1\" or \"0\"., Title cannot be blank.";
    public static String successMsg ="success";
    public static Integer successCode =200;
}
