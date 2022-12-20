package responses.tags;

import requests.TagsInfo;
import responses.tags.SuccessCreateTags;
import lombok.Getter;

import java.util.ArrayList;
@Getter
public class TagsList {
    private Integer code;
    private String result;
    private String error;
    private ArrayList<TagsInfo> data;
}
