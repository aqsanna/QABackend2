package storage;

import lombok.Getter;

@Getter
public enum APIV1 {
    STAGE("https://stage-old.local.express/"),
    LOGIN("api/rest/v1/auth/login"),
    REGISTER("rest/v1/auth/login");


    private String api;

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
