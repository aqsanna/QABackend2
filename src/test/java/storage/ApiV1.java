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
    STORES_LIST("rest/v1/partner/stores"),
    TAX_CREATE("api"),
    TAXES_LIST("rest/v1/partner/taxes?limit=-1&offset=0"),
    TAGS_LIST("rest/v1/partner/tags?limit=100&offset=0"),
    TAGS("rest/v1/partner/tags"),
    TAGS_EDIT("rest/v2/tags/"),
    TAGS_DELETE("rest/v2/tags/"),
    GIFT_CARD_CREATE("rest/v2/gift-card/create"),
    GIFT_CARD_LIST("rest/v2/gift-card/list?perPage=10&page=0"),
    GIFT_CARD("rest/v2/gift-card/"),
    DISCOUNT_LIST("rest/v1/partner/discounts?limit=-1&offset=0");

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
