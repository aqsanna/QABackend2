package enums;

import lombok.Getter;

@Getter
public enum OrderMode {
//    "shipping", "delivery", "pickup", "curbside_pickup"
    SHIPPING("shipping"),
    DELIVERY("delivery"),
    PICKUP("pickup"),
    CURBSIDE_PICKUP("curbside_pickup");

    private final String orderMode;

    OrderMode(String orderMode) {
        this.orderMode = orderMode;
    }
}
