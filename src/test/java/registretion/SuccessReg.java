package registretion;

import java.util.ArrayList;

public class SuccessReg {
    public String token;
    public ArrayList<String> roles;
    public String user_id;
    public String user_email;
    public int keep_alive_time;
    public String registration_date;

    public String getToken() {
        return token;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public int getKeep_alive_time() {
        return keep_alive_time;
    }

    public String getRegistration_date() {
        return registration_date;
    }
}
