package enums;

import java.util.ArrayList;
import java.util.List;

public enum ModificationItemMessagesInvalidCredential {
    FIELD("type"),
    FIELD1("price_change"),
    FIELD2("is_instock"),
    FIELD3("is_multiline"),
    FIELD4("title"),
    MESSAGE("Type is invalid."),
    MESSAGE1("Price Change must be a number."),
    MESSAGE2("Is Instock must be either \"1\" or \"0\"."),
    MESSAGE3("Is Multiline must be either \"1\" or \"0\"."),
    MESSAGE4("Title cannot be blank.");
    private final String validationError;
    ModificationItemMessagesInvalidCredential(String validationError) {
        this.validationError=validationError;
    }
    public String getValidationErrorInvalidCredential(){
        return  validationError;
    }
    public static List<String> getMessages(){
        List<String> ListMessages = new ArrayList<>();
        for(ModificationItemMessagesInvalidCredential l : ModificationItemMessagesInvalidCredential.values()){
            ListMessages.add(l.getValidationErrorInvalidCredential());
        }
        return ListMessages;
    }
    public String toString() {
        return "ModificationItemMessagesInvalidCredentialEnum{" +
                "ModificationItemMessagesInvalidCredentialEnum='" + validationError + '\'' +
                '}';
    }

}
