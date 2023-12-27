package models.responses.customer;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class SuccessLoginWL {
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private Integer result;
    @SerializedName("data")
    private Data data;



    public SuccessLoginWL withResult(Integer result) {
        this.result = result;
        return this;
    }

    public SuccessLoginWL withMessage(String message) {
        this.message = message;
        return this;
    }



    public SuccessLoginWL withData(Data data) {
        this.data = data;
        return this;
    }

    @Getter
    public static class Data {

        @SerializedName("token")
        private String token;


        public Data withToken(String token) {
            this.token = token;
            return this;
        }
    }
}
