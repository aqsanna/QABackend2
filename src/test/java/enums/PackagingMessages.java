package enums;

import java.util.ArrayList;
import java.util.List;
public enum PackagingMessages {
    FIELD("boxes_0_name"),
    FIELD1("boxes_0_length"),
    FIELD2("boxes_0_width"),
    FIELD3("boxes_0_height"),
    FIELD4("packs_0_name"),
    FIELD5("packs_0_price"),
    FIELD6("packs_0_free_count"),
    MESSAGE("Box Name cannot be blank."),
    MESSAGE1("Length cannot be blank."),
    MESSAGE2("Width cannot be blank."),
    MESSAGE3("Height cannot be blank."),
    MESSAGE4("Pack name cannot be blank."),
    MESSAGE5("Price cannot be blank."),
    MESSAGE6("Free pack quantity cannot be blank.");
    private final String validationError;
    PackagingMessages(String validationError) {
        this.validationError=validationError;
    }
    public String getValidationError(){
        return  validationError;
    }
    public static List<String> getMessages(){
        List<String> ListMessages = new ArrayList<>();
        for(PackagingMessages l : PackagingMessages.values()){
            ListMessages.add(l.getValidationError());
        }
        return ListMessages;
    }
    public String toString() {
        return "PackagingMessagesEnum{" +
                "PackagingMessagesEnum='" + validationError + '\'' +
                '}';
    }
}
