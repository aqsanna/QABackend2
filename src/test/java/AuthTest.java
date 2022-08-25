import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.AuthInfo;
import responses.userLogin.SuccessLogin;
import spec.Specifications;
import storage.APIV2;
import storage.USER;

import static io.restassured.RestAssured.given;

public class AuthTest {
    @Test
    @DisplayName("Check success user login")
    public void successLoginTest() {
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());

        //TODO Преобразовать JSON в нормальный вид :) сделать констуктор для сбора JSON.
        String json = "{\n" +
                "    \"params\": {\n" +
                "        \"app\": {\n" +
                "            \"bundle_id\": \"com.worldappsystem.LEPartners\",\n" +
                "            \"version\": \"5.7.2\"\n" +
                "        },\n" +
                "        \"email\": \"info@local.express\",\n" +
                "        \"password\": \"123456\",\n" +
                "        \"device\": {\n" +
                "            \"version\": \"15.0.2\",\n" +
                "            \"os\": \"ios\",\n" +
                "            \"push_token\": \"f8EbEjHLT0RGqX1jnJGxRj:APA91bHlnkZAGhcjNzfAuJ-ZB7A8-u3K5-lG-dQXfW3gT8A-d-KTmEap1lNHvd7B1wuhc8vVR0IqIKVH5zH3HfsbvfL5F9SCPnrUJfV24lKWJLz997zZv5ba5ksDhiL0DbuyM_PemsJr\"\n" +
                "        },\n" +
                "        \"application_key\": \"partnersapp2031f94af9829c64d321d3a210acaad611f76e072ba21a8a6bebb\"\n" +
                "    }\n" +
                "}";


        SuccessLogin successLogin = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertEquals("success", successLogin.getResult());
        Assertions.assertEquals("info@local.express", successLogin.getData().getUserEmail());
        Assertions.assertEquals("13546", successLogin.getData().getUserId());
    }
}
