package storage;

public enum APIV2 {
    STAGE("https://stage-old.local.express/"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login");


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
