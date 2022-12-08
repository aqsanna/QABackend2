package storage;

import lombok.Getter;

@Getter
public enum APIV2 {
    ADD_PACKS("/add-packs"),
    ADD_PACKS_URL("rest/v2/store/87/order/"),
    PACK_LOCATION_URL("rest/v2/partner/store/87/order/"),
    PACK_LOCATION("/pack-locations");
    private final String api;

    APIV2(String api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "API{" +
                "api='" + api + '\'' +
                '}';
    }
}
