package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.CloudPrinter;
import responses.GetStore;
import storage.APIV2;

public class CloudPrinterTest {

    @Test
    @DisplayName("Check cloud printer")
    public void  getCloudPrinter(){

        CloudPrinter cloudPrinter = RestAssured.given()
                .get(APIV2.CLOUDPRINT.getApi() )
                .then().log().all()
                .extract().as(CloudPrinter.class);

        Assertions.assertEquals("Ok", cloudPrinter.getMessage());
        Assertions.assertEquals("OK", cloudPrinter.getCode());
        Assertions.assertFalse(cloudPrinter.getData().isEmpty());


    }

}
