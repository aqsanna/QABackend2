package enums;

import lombok.Getter;

@Getter
public enum Customer {
    EMAIL_WL("oqsannas@localexpress.io"),
    PASSWORD_WL("Local@123");


    private final String customer;

    Customer(String customer) {
        this.customer = customer;
    }

    public String getCustomerData() {
        return customer;
    }

    @Override
    public String toString() {
        return "API_CUSTOMER{" +
                "api='" + customer + '\'' +
                '}';
    }
}
