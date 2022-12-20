package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.CreateTags;
import responses.product.SuccessCreateProduct;
import responses.tags.SuccessCreateTags;
import storage.APIV1;
import storage.USER;

public class TagsInfoProvider {
    public static CreateTags getTags(USER email){
        return  switch (email){
            case EMAIL_INFO -> new CreateTags(
                    new CreateTags.Params(
                            USER.TITLE.getUserData() + ProductInfoProvider.random()));
            default -> null;
        };
    }
    public static String getTagsId() {
        Gson gson = new Gson();
        SuccessCreateTags successCreateTags = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(getTags(USER.EMAIL_INFO)))
                .post(APIV1.STAGE.getApi() + APIV1.TAGS.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTags.class);
        return successCreateTags.getData().getId();
    }
}
