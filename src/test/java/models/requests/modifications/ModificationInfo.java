package models.requests.modifications;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ModificationInfo {
    @SerializedName("filterType")
    public String filterType;
    public ModificationInfo(String filterType){
        this.filterType=filterType;
    }
}
