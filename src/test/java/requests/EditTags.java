package requests;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;

@With
public class EditTags implements Serializable {
    public String icon;
    public String title;
    public String  priority;


    public EditTags(String icon, String title, String  priority ){
        super();
        this.icon=icon;
        this.title=title;
        this.priority=priority;
    }

}
