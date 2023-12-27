package models.requests.customer;

import com.google.gson.annotations.SerializedName;
import io.restassured.response.Validatable;
import lombok.With;
import java.io.Serializable;

@With
public  class AuthCustomer implements Serializable {
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;

    public AuthCustomer(String email, String password){
        super();
        this.email=email;
        this.password=password;

    }
    public AuthCustomer(){
    }
}
