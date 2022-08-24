import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import registretion.Registretion;
import spec.Specifications;
import storage.APIV2;

public class AuthTest {
    @Test
    @DisplayName("Check success user login")
    public void UserLoginV2Test() {
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());
    }

    @Test
    @DisplayName("authorized")
    public void authorize(){
        Specifications.installSpecification(Specifications.requestSpec("https://dev.local.express/" + APIV2.LOGIN.getApi()), Specifications.responseOK200());
        Registretion user = new Registretion(USER.);
        ValidatableResponse r = Specifications.post( APIV2.DOMAIN_DEV.getApi(), "", body);
        r.extract().response().prettyPrint();
    }
}
