package storage;

public enum APIV1 {
    STAGE("https://stage-old.local.express/"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login"),
    CREATEPRODUCT("rest/v1/partner/stores/87/products"),
    DELETE_PRODUCT_ID("rest/v1/partner/stores/87/products/");


    private final String api;

    APIV1(String api) {
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
