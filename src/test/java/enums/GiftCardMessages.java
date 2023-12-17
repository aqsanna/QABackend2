package enums;

import java.util.ArrayList;
import java.util.List;

public enum GiftCardMessages {
    FIELD("initialBalance"),
    MESSAGE("Initial Balance must be no less than 1.");

    private final String validationError;
    GiftCardMessages(String validationError) {
        this.validationError=validationError;
    }
    public String getValidationError(){
        return  validationError;
    }
    public static List<String> getMessages(){
        List<String> ListMessages = new ArrayList<>();
        for(GiftCardMessages l : GiftCardMessages.values()){
            ListMessages.add(l.getValidationError());
        }
        return ListMessages;
    }
    public String toString() {
        return "GiftCardMessagesEnum{" +
                "GiftCardMessagesEnum='" + validationError + '\'' +
                '}';
    }
}
