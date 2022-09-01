package requests;

import com.google.gson.annotations.SerializedName;

public class Device {
    @SerializedName("DEVICE_VERSION")
    private final String version;
    private final String os;
    @SerializedName("PUSH_TOKEN")
    private final String pushToken;

    public Device(String version, String os, String pushToken) {
        this.version = version;
        this.os = os;
        this.pushToken = pushToken;
    }

    public String getVersion() {
        return version;
    }

    public String getOs() {
        return os;
    }

    public String getPushToken() {
        return pushToken;
    }

    @Override
    public String toString() {
        return "{" +
                "version='" + version + '\'' +
                ", os='" + os + '\'' +
                "pushToken='" + pushToken + '\'' +
                '}';
    }
}

