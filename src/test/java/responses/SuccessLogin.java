package responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuccessLogin {

    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private Data data;

    public Integer getCode() {
        return code;
    }

    public SuccessLogin withCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public SuccessLogin withResult(String result) {
        this.result = result;
        return this;
    }

    public String getError() {
        return error;
    }

    public SuccessLogin withError(String error) {
        this.error = error;
        return this;
    }

    public Data getData() {
        return data;
    }

    public SuccessLogin withData(Data data) {
        this.data = data;
        return this;
    }

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

        public String getToken() {
            return token;
        }

        public Data withToken(String token) {
            this.token = token;
            return this;
        }

        public List<String> getRoles() {
            return roles;
        }

        public Data withRoles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Data withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public Data withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Integer getKeepAliveTime() {
            return keepAliveTime;
        }

        public Data withKeepAliveTime(Integer keepAliveTime) {
            this.keepAliveTime = keepAliveTime;
            return this;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public Data withRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }
    }
}
