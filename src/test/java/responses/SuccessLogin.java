package responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SuccessLogin {
    @SerializedName("user_id")
    @Expose
    private static String userId;
    private String token;
    private ArrayList<String> roles;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("keep_alive_time")
    @Expose
    private int keepAliveTime;
    @SerializedName("registration_date")
    @Expose
    private String registrationDate;

    public SuccessLogin(String token, ArrayList<String> roles, String userId, String userEmail, int keepAliveTime, String registrationDate) {
        this.token = token;
        this.roles = roles;
        this.userId = userId;
        this.userEmail = userEmail;
        this.keepAliveTime = keepAliveTime;
        this.registrationDate = registrationDate;
    }

    public static String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getKeepAliveTime() {
        return keepAliveTime;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }
}
