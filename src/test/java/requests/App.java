package requests;

import com.google.gson.annotations.SerializedName;

public class App {
    @SerializedName("BUNDLE_ID")
    private final String bundleID;
    private final String version;

    public App(String bundleID, String version) {
        this.bundleID = bundleID;
        this.version = version;
    }

    public String getBundleId() {
        return bundleID;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "{" +
                "bundle_id='" + bundleID + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

