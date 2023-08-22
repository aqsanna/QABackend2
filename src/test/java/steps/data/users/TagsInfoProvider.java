package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.tag.*;
import responses.tags.SuccessCreateTags;
import storage.ApiV1;
import storage.ApiV2;
import storage.User;

import java.util.Random;

public class TagsInfoProvider {
    public static CreateTags getTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateTags(
                            User.TITLE_TAG.getUserData() + ProductInfoProvider.random()
                                , User.ICON.getUserData()
                                , User.PRIORITY.getUserData()
                                ,1
                                ,1
                                ,1);
            default -> null;
        };
    }
    public static CreateTagsWithoutTitle errorMessageTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateTagsWithoutTitle(
                           "");
            default -> null;
        };
    }

    public static CreateTagsInvalidCredential errorMessageTagsInvalidCredential(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateTagsInvalidCredential(
                     3
                   , ""
                   , 4
                   , 5);
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
    public static TagsInfo listTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new TagsInfo(
                   "basic"
                   );
            default -> null;
        };
    }

    public static Integer getTagsId() {
        Gson gson = new Gson();
        SuccessCreateTags successCreateTags = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((getTags(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV1.TAGS.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTags.class);
        return Integer.valueOf(successCreateTags.getData().id);
    }

    public static Integer random() {
        Random ran = new Random();
        int x = ran.nextInt(9) + 1;
        return x;
    }
}
