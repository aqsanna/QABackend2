package helpers.customer;
import com.google.gson.Gson;
import dataProviders.customer.CustomerProvider;
import enums.Customer;
import helpers.AbstractRequest;
import models.responses.customer.SuccessLoginWL;


public class RequestAuthorizationWL extends AbstractRequest {
    private final Gson gson = new Gson();

    public SuccessLoginWL requestPostAuthWL(String url) {
        return baseAuthorizedRequestWL()
                .body(gson.toJson(CustomerProvider.getCustomer(Customer.EMAIL_WL)))
                .post(url)
                .then().log().all()
                .extract().as(SuccessLoginWL.class);
    }
}
