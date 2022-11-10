package apiTests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.CloudPrinter;
import storage.APIV1;

public class CloudPrinterTest {
    @Test
    @DisplayName("Check cloud printer")
    public void successCloudPrinterTest() {

        CloudPrinter cloudPrinter = RestAssured.given()
                .get(APIV1.CLOUD_PRINT.getApi())
                .then().log().all()
                .extract().as(CloudPrinter.class);

        Assertions.assertEquals("Ok", cloudPrinter.getMessage(), "Message status not OK");
        Assertions.assertEquals("OK", cloudPrinter.getCode(), "Status not OK");
        Assertions.assertFalse(cloudPrinter.getData().isEmpty(), "data  is empty");
    }
}
