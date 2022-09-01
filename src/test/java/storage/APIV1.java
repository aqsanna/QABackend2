package storage;

import lombok.Getter;

@Getter
public enum APIV1 {
    STAGE("https://stage-old.local.express/"),
    STORE("rest/v1/partner/stores"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login"),
    CLOUDPRINT("https://api.localexpress.io/rest/v2/cloud-printer/kiosk/3915408"),
    ORDERS("rest/v1/partner/stores/87/orders"),
    STORES_LIST("rest/v1/partner/stores");

    private final String api;

    APIV1(String api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "API{" +
                "api='" + api + '\'' +
                '}';
    }
}
