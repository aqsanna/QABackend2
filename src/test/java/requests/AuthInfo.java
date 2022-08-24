package requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthInfo {
    private App app;
    private String email;
    private String password;
    private Device device;
    @SerializedName("APPLICATION_KEY")
    @Expose
    private String applicationKey;

    public App getApp() {
        return app;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Device getDevice() {
        return device;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public static class App{
        @SerializedName("BUNDLE_ID")
        @Expose
        private String bundleID;
        private String version;

        public String getBundleId() {
            return bundleID;
        }

        public String getVersion() {
            return version;
        }
    }

    public static class Device{
        private String version;
        private String os;
        @SerializedName("push_token")
        @Expose
        private String pushToken;

        public String getVersion() {
            return version;
        }

        public String getOs() {
            return os;
        }

        public String getPushToken() {
            return pushToken;
        }
    }

    public AuthInfo(App app, String email, String password, Device device, String applicationKey) {
        this.app = app;
        this.email = email;
        this.password = password;
        this.device = device;
        this.applicationKey = applicationKey;
    }
}
