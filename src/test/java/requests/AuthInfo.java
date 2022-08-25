package requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class AuthInfo implements Serializable {

    @Serial
    private final static long serialVersionUID = 4850255736179712594L;
    @SerializedName("params")
    @Expose
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

        @Serial
        private final static long serialVersionUID = -1195708863342171343L;
        @SerializedName("app")
        @Expose
        public App app;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("password")
        @Expose
        public String password;
        @SerializedName("device")
        @Expose
        public Device device;
        @SerializedName("application_key")
        @Expose
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

            @Serial
            private final static long serialVersionUID = 6061346270223219326L;
            @SerializedName("version")
            @Expose
            public String version;
            @SerializedName("os")
            @Expose
            public String os;
            @SerializedName("push_token")
            @Expose
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

            @Serial
            private final static long serialVersionUID = -3129480098619973051L;
            @SerializedName("bundle_id")
            @Expose
            public String bundleId;
            @SerializedName("version")
            @Expose
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