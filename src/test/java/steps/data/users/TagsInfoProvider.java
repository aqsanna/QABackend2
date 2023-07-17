package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.tag.CreateTags;
import requests.tag.EditTags;
import responses.tags.SuccessCreateTags;
import storage.ApiV1;
import storage.User;

public class TagsInfoProvider {
    public static CreateTags getTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateTags(
                    new CreateTags.Params(
                            User.TITLE_TAG.getUserData() + ProductInfoProvider.random()
                                , User.ICON.getUserData()
                                , User.PRIORITY.getUserData()
                                ,1
                                , 1
                                , 1));
            default -> null;
        };
    }

    public static EditTags editTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new EditTags(
                    User.ICON.getUserData()
                    , User.TITLE_TAG.getUserData() + ProductInfoProvider.random()
                    , "1"
                    ,0
                    ,0
                    , 0);


            default -> null;
        };
    }

    public static Integer getTagsId() {
        Gson gson = new Gson();
        SuccessCreateTags successCreateTags = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(getTags(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAGS.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTags.class);
        return Integer.valueOf(successCreateTags.getData().getId());
    }
}
