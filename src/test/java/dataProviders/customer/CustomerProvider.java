package dataProviders.customer;

import enums.Customer;
import models.requests.customer.AuthCustomer;

public class CustomerProvider {
    public static AuthCustomer getCustomer(Customer customer){
        return switch (customer) {
            case EMAIL_WL -> new AuthCustomer(
                     Customer.EMAIL_WL.getCustomerData()
                    ,Customer.PASSWORD_WL.getCustomerData());

            default -> null;
        };
    }
}