package httpRequest;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import responses.modificationItems.SuccessCreateModificationItems;
import steps.data.users.ModificationItemsProvider;
import steps.data.users.UserInfoProvider;
import storage.User;


import static io.restassured.RestAssured.given;

public class RequestModificationItems {

    Gson gson = new Gson();

    public SuccessCreateModificationItems requestPost(String path, String url){
        return given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(ModificationItemsProvider.createModification(User.EMAIL_INFO)))
                .put(path + url)
                .then()
                .extract().as(SuccessCreateModificationItems.class);
    }
}
