package storage;

import java.util.ArrayList;
import java.util.List;

public enum TagMessagesInvalidCredential {
    FIELD("title"),
    FIELD1("visible"),
    FIELD2("status"),
    FIELD3("show_icon_on_product"),
    MESSAGE("Title cannot be blank."),
    MESSAGE1("Partner Id must be either \"1\" or \"0\"."),
    MESSAGE2("Status must be either \"1\" or \"0\"."),
    MESSAGE3("Show Icon On Product must be either \"1\" or \"0\".");
    private final String validationError;
    TagMessagesInvalidCredential(String validationError) {
        this.validationError=validationError;
    }
    public String getValidationErrorInvalidCredential(){
        return  validationError;
    }
    public static List<String> getMessages(){
        List<String> ListMessages = new ArrayList<>();
        for(TagMessagesInvalidCredential l : TagMessagesInvalidCredential.values()){
            ListMessages.add(l.getValidationErrorInvalidCredential());
        }
        return ListMessages;
    }
    public String toString() {
        return "TagMessagesInvalidCredentialEnum{" +
                "TagMessagesInvalidCredentialEnum='" + validationError + '\'' +
                '}';
    }

}
