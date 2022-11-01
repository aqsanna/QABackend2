package specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    public static ResponseSpecification responseOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseError400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}
