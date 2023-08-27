package assertions;

import Utils.ErrorMessages;
import org.junit.jupiter.api.Assertions;

public class AssertionForMessages {
    public void assertRequestMessageAndCode(Object message, Object code){
        Assertions.assertEquals(ErrorMessages.messageOk, message);
        Assertions.assertEquals(ErrorMessages.codeOK, code);
    }
}
