package storage;

public enum APIV2 {
    STAGE("https://stage-old.local.express/"),
    STORE("rest/v1/partner/stores"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login"),
    CLOUDPRINT("https://api.localexpress.io/rest/v2/cloud-printer/kiosk/3915408");


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
