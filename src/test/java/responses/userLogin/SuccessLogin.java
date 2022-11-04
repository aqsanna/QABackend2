package responses.userLogin;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class SuccessLogin {
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private Data data;

    public SuccessLogin withCode(Integer code) {
        this.code = code;
        return this;
    }

    public SuccessLogin withResult(String result) {
        this.result = result;
        return this;
    }

    public SuccessLogin withError(String error) {
        this.error = error;
        return this;
    }

    public SuccessLogin withData(Data data) {
        this.data = data;
        return this;
    }

    @Getter
    public static class Data {

        @SerializedName("token")
        private String token;
        @SerializedName("roles")
        private List<String> roles = null;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("user_email")
        private String userEmail;
        @SerializedName("keep_alive_time")
        private Integer keepAliveTime;
        @SerializedName("registration_date")
        private String registrationDate;

        public Data withToken(String token) {
            this.token = token;
            return this;
        }

        public Data withRoles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public Data withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Data withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Data withKeepAliveTime(Integer keepAliveTime) {
            this.keepAliveTime = keepAliveTime;
            return this;
        }

        public Data withRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }
    }
}
