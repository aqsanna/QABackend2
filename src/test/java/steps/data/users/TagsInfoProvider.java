package steps.data.users;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import requests.CreateTags;
import requests.EditTags;
import responses.tags.SuccessCreateTags;
import storage.ApiV1;
import storage.User;

public class TagsInfoProvider {
    public static CreateTags getTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateTags(
                    new CreateTags.Params(
                            User.TITLE_TAG.getUserData() + ProductInfoProvider.random()));
            default -> null;
        };
    }

    public static EditTags editTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new EditTags(
                    User.ICON.getUserData()
                    , User.TITLE_TAG.getUserData() + ProductInfoProvider.random()
                    , User.PRIORITY.getUserData());

            default -> null;
        };
    }

    public static String getTagsId() {
        Gson gson = new Gson();
        SuccessCreateTags successCreateTags = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(getTags(User.EMAIL_INFO)))
                .post(ApiV1.STAGE.getApi() + ApiV1.TAGS.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTags.class);
        return successCreateTags.getData().getId();
    }
}
