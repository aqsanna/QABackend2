package httpRequest;

import com.google.gson.Gson;
import responses.CloudPrinter;
import storage.ApiV1;

import static io.restassured.RestAssured.given;

public class RequestCloudPrinter {
    public CloudPrinter request(){
        return given()
                .get(ApiV1.CLOUD_PRINT.getApi())
                .then().log().all()
                .extract().as(CloudPrinter.class);
    }
}
