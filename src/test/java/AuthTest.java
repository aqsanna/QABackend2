import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import registretion.Register;
import registretion.SuccessReg;
import spec.Specifications;
import storage.APIV2;
import storage.USER;

import static io.restassured.RestAssured.given;

public class AuthTest {
    @Test
    @DisplayName("Check success user login")
    public void UserLoginV2Test() {
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());
    }

    @Test
    @DisplayName("authorized")
    public void authorize(){
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());
        Register user = new Register(
                USER.APP_VERSION.getUserData(),
                USER.BUNDLE_ID.getUserData(),
                USER.EMAIL.getUserData(),
                USER.PASSWORD.getUserData(),
                USER.APPLICATION_KEY.getUserData());
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post(APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessReg.class);

//        Assertions.assertEquals(id, successReg.getId());
//        Assertions.assertEquals(token, successReg.getToken());
    }
}
