package apiTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.tags.SuccessCreateTags;
import steps.data.users.TagsInfoProvider;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.USER;

public class TagsTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check create tags")
    public void CreateTags() {
        SuccessCreateTags successCreateTags = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(TagsInfoProvider.getTags(USER.EMAIL_INFO)))
                .post(APIV1.STAGE.getApi() + APIV1.TAGS.getApi())
                .then().log().all()
                .extract().as(SuccessCreateTags.class);

        Assertions.assertEquals("success", successCreateTags.getResult());
        Assertions.assertEquals(200, successCreateTags.getCode());
        Assertions.assertFalse(successCreateTags.getData().getId().isEmpty(), "is  is empty");
        Assertions.assertFalse(successCreateTags.getData().getTitle().isEmpty(), "title  is empty");
    }
}
