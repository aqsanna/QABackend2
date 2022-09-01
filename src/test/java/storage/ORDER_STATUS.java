package storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public enum ORDER_STATUS {
    NEW("new"),
    ASSEMBLING("assembling"),
    ASSEMBLED("assembled"),
    DELIVERING("delivering"),
    DELIVERED("delivered"),
    PENDING("pending"),
    TRANSFER_TO_DRIVER("transfer_to_driver"),
    REACHED_THE_STORE("reached_the_store"),
    CHECKED_BY_DRIVER("checked_by_driver"),
    ARRIVED("arrived"),
    SIGNED("signed");

    private String orderStatus;

    ORDER_STATUS(String orderStatus) {this.orderStatus = orderStatus; }

    public String getOrderStatus() {
        return orderStatus;
    }

}
