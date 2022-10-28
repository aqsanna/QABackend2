package requests;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class AuthInfo implements Serializable {

    @SerializedName("params")
    public Params params;

    public AuthInfo(Params params) {
        super();
        this.params = params;
    }

    @With
    public static class Params implements Serializable {

        @SerializedName("app")
        public App app;
        @SerializedName("email")
        public String email;
        @SerializedName("password")
        public String password;
        @SerializedName("device")
        public Device device;
        @SerializedName("application_key")
        public String applicationKey;

        public Params(App app, String email, String password, Device device, String applicationKey) {
            super();
            this.app = app;
            this.email = email;
            this.password = password;
            this.device = device;
            this.applicationKey = applicationKey;
        }

        @With
        public static class Device implements Serializable {

            @SerializedName("version")
            public String version;
            @SerializedName("os")
            public String os;
            @SerializedName("push_token")
            public String pushToken;

            public Device() {
            }

            public Device(String version, String os, String pushToken) {
                super();
                this.version = version;
                this.os = os;
                this.pushToken = pushToken;
            }
        }

        @With
        public static class App implements Serializable {

            @SerializedName("bundle_id")
            public String bundleId;
            @SerializedName("version")
            public String version;

            public App() {
            }

            public App(String bundleId, String version) {
                super();
                this.bundleId = bundleId;
                this.version = version;
            }
        }
    }
}
