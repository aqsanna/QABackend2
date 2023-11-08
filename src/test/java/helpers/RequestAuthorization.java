package helpers;
import dataProviders.UserInfoProvider;
import enums.User;
import models.responses.userLogin.SuccessLogin;


public class RequestAuthorization extends AbstractRequest{
    public SuccessLogin requestPostAuth(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(UserInfoProvider.getUser(User.EMAIL_INFO)))
                .post(url)
                .then().log().all()
                .extract().as(SuccessLogin.class);
    }
    public SuccessLogin requestPostAuthEmail(String url){
        return baseAuthorizedRequest()
                .body(gson.toJson(UserInfoProvider.getUserClient(User.EMAIL_CLIENT)))
                .post(url)
                .then().log().all()
                .extract().as(SuccessLogin.class);
    }
  }
