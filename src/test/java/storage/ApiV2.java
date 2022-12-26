package storage;

import lombok.Getter;

@Getter
public enum ApiV2 {
    ADD_PACKS("/add-packs"),
    STORE_ORDER("rest/v2/store/87/order"),
    PACK_LOCATION_URL("rest/v2/partner/store/87/order/"),
    PACK_LOCATION("/pack-locations"),
    PACK_LOCATION_PRINT("/pack-locations/print"),
    CHANGE_STATUS("/change-status"),
    ORDER_DETAILS("/details"),
    PACKAGING("rest/v2/store/87/packaging"),
    SHIPPING_PACKAGING_BOX("/shipping-packaging-box"),
    SHIPPING_RATES("/shipping-rates"),
    SHIPPING_LABEL("/shipping-label");
    private final String api;

    ApiV2(String api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "API{" +
                "api='" + api + '\'' +
                '}';
    }
}
