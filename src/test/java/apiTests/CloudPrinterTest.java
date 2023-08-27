package apiTests;

import assertions.AssertionForMessages;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.CloudPrinter;
import storage.ApiV1;

public class CloudPrinterTest {
    AssertionForMessages assertionForMessages = new AssertionForMessages();
    @Test
    @DisplayName("Check cloud printer")
    public void successCloudPrinterTest() {

        CloudPrinter cloudPrinter = RestAssured.given()
                .get(ApiV1.CLOUD_PRINT.getApi())
                .then().log().all()
                .extract().as(CloudPrinter.class);
        assertionForMessages.assertRequestMessageAndCode(cloudPrinter.getMessage(),cloudPrinter.getCode());
        Assertions.assertFalse(cloudPrinter.getData().isEmpty(), "data  is empty");
    }
}
