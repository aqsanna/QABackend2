package requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TagsInfo {
    @SerializedName("filterType")
    public String filterType;
    public TagsInfo(String filterType){
        this.filterType=filterType;
    }
}
