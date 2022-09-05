package requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthInfo implements Serializable {

    @SerializedName("params")
    public Params params;

    public AuthInfo() {
    }

    public AuthInfo(Params params) {
        super();
        this.params = params;
    }

    public AuthInfo withParams(Params params) {
        this.params = params;
        return this;
    }

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

        public Params() {
        }

        public Params(App app, String email, String password, Device device, String applicationKey) {
            super();
            this.app = app;
            this.email = email;
            this.password = password;
            this.device = device;
            this.applicationKey = applicationKey;
        }

        public Params withApp(App app) {
            this.app = app;
            return this;
        }

        public Params withEmail(String email) {
            this.email = email;
            return this;
        }

        public Params withPassword(String password) {
            this.password = password;
            return this;
        }

        public Params withDevice(Device device) {
            this.device = device;
            return this;
        }

        public Params withApplicationKey(String applicationKey) {
            this.applicationKey = applicationKey;
            return this;
        }

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

            public Device withVersion(String version) {
                this.version = version;
                return this;
            }

            public Device withOs(String os) {
                this.os = os;
                return this;
            }

            public Device withPushToken(String pushToken) {
                this.pushToken = pushToken;
                return this;
            }

        }

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

            public App withBundleId(String bundleId) {
                this.bundleId = bundleId;
                return this;
            }

            public App withVersion(String version) {
                this.version = version;
                return this;
            }
        }
    }
}
