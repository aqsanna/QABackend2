package storage;

import lombok.Getter;

@Getter
public enum ApiV1 {
    STAGE("https://stage-old.local.express/"),
    STORE("rest/v1/partner/stores"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login"),
    CLOUD_PRINT("https://api.localexpress.io/rest/v2/cloud-printer/kiosk/3915408"),
    CREATE_PRODUCT("rest/v1/partner/stores/87/products"),
    DELETE_PRODUCT_ID("rest/v1/partner/stores/87/products/"),
    UPDATE_PRODUCT("rest/v1/partner/stores/87/products/"),
    ORDERS("rest/v1/partner/stores/87/orders"),
    PRODUCT_DATA_TYPE("rest/v1/partner/service/available-products-data-types"),
    ORDERS_TO("rest/v1/partner/orders/"),
    CONFIRM("/confirm"),
    ORDER_START("/start"),
    FINISH("/finish"),
    ORDER_ITEMS("rest/v1/partner/order-items/"),
    STORES_LIST("rest/v1/partner/stores");

    private final String api;

    ApiV1(String api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "API{" +
                "api='" + api + '\'' +
                '}';
    }
}
