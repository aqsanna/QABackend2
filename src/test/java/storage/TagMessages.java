package storage;

import java.util.ArrayList;
import java.util.List;

public enum TagMessages {
    FIELD("title"),
    MESSAGE("Title cannot be blank.");
    private final String validationError;
    TagMessages(String validationError) {
        this.validationError=validationError;
    }
    public String getValidationError(){
        return  validationError;
    }
    public static List<String> getMessages(){
        List<String> ListMessages = new ArrayList<>();
        for(TagMessages l : TagMessages.values()){
            ListMessages.add(l.getValidationError());
        }
        return ListMessages;
    }
    public String toString() {
        return "TagMessagesEnum{" +
                "TagMessagesEnum='" + validationError + '\'' +
                '}';
    }

}
