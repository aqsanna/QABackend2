package helpers;
import config.Configurations;
import dataProviders.UserInfoProvider;
import enums.ApiV1;
import enums.User;
import models.requests.login.AuthInfo;
import models.responses.userLogin.SuccessLogin;

public class RequestAuthorization extends AbstractRequest{
    public SuccessLogin requestPostAuth(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(UserInfoProvider.getUser(User.EMAIL_INFO)))
                .post(url)
                .then().log().all()
                .extract().as(SuccessLogin.class);
    }
}
