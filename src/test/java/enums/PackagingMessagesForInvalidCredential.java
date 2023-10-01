package enums;

import java.util.ArrayList;
import java.util.List;

public enum PackagingMessagesForInvalidCredential {

    FIELD("boxes_0_name"),
    FIELD1("boxes_0_free_volume_reserve"),
    FIELD2("boxes_0_length"),
    FIELD3("boxes_0_width"),
    FIELD4("boxes_0_height"),
    FIELD5("boxes_0_weight"),
    FIELD6("boxes_0_special_entity_type_id"),
    FIELD7("packs_0_name"),
    FIELD8("packs_0_price"),
    FIELD9("packs_0_free_count"),
    MESSAGE("Box Name cannot be blank."),
    MESSAGE1("Reserve (%) must be no less than 0."),
    MESSAGE2("Length must be no less than 9.0E-5."),
    MESSAGE3("Width must be no less than 9.0E-5."),
    MESSAGE4("Height must be no less than 9.0E-5."),
    MESSAGE5("Weight must be greater than or equal to \"0\"."),
    MESSAGE6("Special Type must be no less than 0."),
    MESSAGE7("Pack name cannot be blank."),
    MESSAGE8("Price must be no less than 0."),
    MESSAGE9("Free pack quantity must be no less than 0.");
    private final String validationErrorInvalidCredential;
    PackagingMessagesForInvalidCredential(String validationErrorInvalidCredential) {
        this.validationErrorInvalidCredential=validationErrorInvalidCredential;
    }
    public String getValidationError(){
        return  validationErrorInvalidCredential;
    }
    public static List<String> getMessages(){
        List<String> ListMessages = new ArrayList<>();
        for(PackagingMessagesForInvalidCredential l : PackagingMessagesForInvalidCredential.values()){
            ListMessages.add(l.getValidationError());
        }
        return ListMessages;
    }
    public String toString() {
        return "PackagingMessagesEnum{" +
                "PackagingMessagesEnum='" + validationErrorInvalidCredential + '\'' +
                '}';
    }
}
