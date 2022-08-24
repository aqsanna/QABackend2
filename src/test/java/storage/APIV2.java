package storage;

public enum APIV2 {
    DOMAIN_DEV("https://dev.local.express/api"),
    LOGIN("/rest/v1/auth/login");


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
