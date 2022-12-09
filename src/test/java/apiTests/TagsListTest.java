package apiTests;

import com.google.gson.Gson;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.TagsInfo;
import responses.tags.SuccessCreateTags;
import responses.tags.TagsList;
import steps.data.users.UserInfoProvider;
import storage.APIV1;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TagsListTest {
    @Test
    @DisplayName("check tags list")
    public void getTagsListTest(){
        Gson gson = new Gson();

        TagsList tagsList = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(APIV1.STAGE.getApi() + APIV1.TAGSLIST.getApi())
                .then().log().all()
                .extract().as(TagsList.class);
        Assertions.assertEquals("success", tagsList.getResult());
        Assertions.assertEquals("", tagsList.getError());
        Assertions.assertEquals(200, tagsList.getCode());
        ArrayList<TagsInfo> tagsData = tagsList.getData();
        for(TagsInfo data : tagsData){
            Assertions.assertFalse(data.title.isEmpty(), "title  is empty");
            Assertions.assertFalse(data.id.isEmpty(), "id  is empty");
            Assertions.assertEquals(tagsData.size(), 100);
        }
    }
}
