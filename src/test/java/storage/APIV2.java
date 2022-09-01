package storage;

public enum APIV2 {
    STAGE("https://stage-old.local.express/"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login"),
    ORDERS("rest/v1/partner/stores/87/orders"),
    STORES_LIST("rest/v1/partner/stores");

    private String api;

    APIV2(String api) {
        this.api = api;
    }

    public String getApi() {
        return api;
    }

    @Override
    public String toString() {
        return "API{" +
                "api='" + api + '\'' +
                '}';
    }
}
