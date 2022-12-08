package steps.data.users;

import requests.CreateTags;
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
}
