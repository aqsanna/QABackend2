package requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class App {
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

    public App(String bundleID, String version) {
        this.bundleID = bundleID;
        this.version = version;
    }
}

