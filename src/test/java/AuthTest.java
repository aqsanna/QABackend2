import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.Specifications;
import storage.APIV2;

public class AuthTest {
    @Test
    @DisplayName("Check success user login")
    public void UserLoginV2Test() {
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());
    }
}
