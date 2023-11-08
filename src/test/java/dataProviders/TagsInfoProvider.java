package dataProviders;

import Utils.RandomGenerateMethods;
import com.google.gson.Gson;
import config.Configurations;
import helpers.RequestTags;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.requests.tag.*;
import models.responses.tags.SuccessCreateTags;
import models.responses.tags.TagsList;
import enums.ApiV1;
import enums.User;

public class TagsInfoProvider {
    public static CreateTags getTags(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CreateTags(
                            User.TITLE_TAG.getUserData() + RandomGenerateMethods.random()
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
    public static ChangeTagStatus changeStatus(User email) {
        return switch (email) {
            case EMAIL_INFO -> new ChangeTagStatus(
                    0
                    );
            default -> null;
        };
    }

    public static ChangeTagVisible changeVisible(User email) {
        return switch (email) {
            case EMAIL_INFO -> new ChangeTagVisible(
                    0
            );
            default -> null;
        };
    }
    public static ChangeTagShowOnProductCard changeShowOnProductCard(User email) {
        return switch (email) {
            case EMAIL_INFO -> new ChangeTagShowOnProductCard(
                    0
            );
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
                    , User.TITLE_TAG.getUserData() + RandomGenerateMethods.random()
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
    public static Integer assertResultsMaxId() {
        RequestTags postRequest =  new RequestTags();
        TagsList tagsList = postRequest.requestPostTagsList(ApiV1.TAGS_LIST.getApi());
        int maxId = Integer.MIN_VALUE;
        for (TagsList.Data.Result result : tagsList.getData().getResult()) {
            int id = Integer.parseInt(result.getId());
            if (id > maxId) {
                maxId = id;
            }
        }
        System.out.println("Max id: " + maxId);
        return maxId;
    }
}
