package responses.tags;

import lombok.Getter;
import requests.TagsInfo;

import java.util.ArrayList;

@Getter
public class TagsList {
    private Integer code;
    private String result;
    private String error;
    private ArrayList<TagsInfo> data;
}
