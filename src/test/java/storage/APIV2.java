package storage;

public enum APIV2 {
    DOMAIN_DEV("https://stage-old.local.express/api"),
    LOGIN("https://stage-old.local.express/api/rest/v1/auth/login"),
    REGISTER("https://stage-old.local.express/rest/v1/auth/login");


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
