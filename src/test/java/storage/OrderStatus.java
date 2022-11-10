package storage;

public enum OrderStatus {
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
    private final String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

}
