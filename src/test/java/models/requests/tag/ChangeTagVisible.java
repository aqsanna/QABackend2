package models.requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class ChangeTagVisible {

        @SerializedName("visible")
        public Integer visible;


        public ChangeTagVisible(Integer visible) {
            super();
            this.visible=visible;
        }
    }
