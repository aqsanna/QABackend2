package helpers;

import com.google.gson.Gson;
import config.Configurations;
import enums.ApiV1;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.requests.login.AuthInfo;
import models.responses.product.SuccessCreateProduct;
import models.responses.product.SuccessDeleteProduct;
import models.responses.product.SuccessUpdateProduct;
import dataProviders.ProductInfoProvider;
import dataProviders.UserInfoProvider;
import enums.User;
import models.responses.userLogin.SuccessLogin;

import static io.restassured.RestAssured.given;

public class RequestProduct extends AbstractRequest {
    public SuccessCreateProduct requestCreateProduct(String url){
        return baseAuthorizedRequest()
                .body(ProductInfoProvider.getProduct(User.EMAIL_INFO))
                .post(url)
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
    }

    public SuccessDeleteProduct requestDeleteProduct(String url, String productId){
        return  baseAuthorizedRequest()
                .delete(url + productId)
                .then().log().all()
                .extract().as(SuccessDeleteProduct.class);
    }
    public SuccessUpdateProduct requestUpdateProduct(String url, String productId){
        return  baseAuthorizedRequest()
                .body(ProductInfoProvider.updProduct(User.EMAIL_INFO))
                .put(url + productId)
                .then().log().all()
                .extract().as(SuccessUpdateProduct.class);
    }

    public static String getProductId() {
        Gson gson = new Gson();
        SuccessCreateProduct successCreateProduct = baseAuthorizedRequest()
                .body(gson.toJson(ProductInfoProvider.getProduct(User.EMAIL_INFO)))
                .post(ApiV1.CREATE_PRODUCT.getApi())
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
        return successCreateProduct.getData();
    }
}
