package apiTests;

import assertions.AssertionForMessages;
import httpRequest.RequestCloudPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.CloudPrinter;

public class CloudPrinterTest {
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    @Test
    @DisplayName("Check cloud printer")
    public void successCloudPrinterTest() {
        RequestCloudPrinter requestCloudPrinter = new RequestCloudPrinter();
        CloudPrinter cloudPrinter = requestCloudPrinter.request();
        assertionForMessages.assertRequestMessageAndCode(cloudPrinter.getMessage(),cloudPrinter.getCode());
        Assertions.assertFalse(cloudPrinter.getData().isEmpty(), "data  is empty");
    }
}
