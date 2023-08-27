package httpRequest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import responses.product.SuccessCreateProduct;
import responses.product.SuccessDeleteProduct;
import responses.product.SuccessUpdateProduct;
import steps.data.users.ProductInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.User;

import static io.restassured.RestAssured.given;

public class RequestProduct {
    public SuccessCreateProduct requestCreateProduct(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(ProductInfoProvider.getProduct(User.EMAIL_INFO))
                .post(path + url)
                .then().log().all()
                .extract().as(SuccessCreateProduct.class);
    }

    public SuccessDeleteProduct requestDeleteProduct(String path, String url, String productId){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .delete(path + url + productId)
                .then().log().all()
                .extract().as(SuccessDeleteProduct.class);
    }
    public SuccessUpdateProduct requestUpdateProduct(String path, String url, String productId){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(ProductInfoProvider.updProduct(User.EMAIL_INFO))
                .put(path + url + productId)
                .then().log().all()
                .extract().as(SuccessUpdateProduct.class);
    }


}
