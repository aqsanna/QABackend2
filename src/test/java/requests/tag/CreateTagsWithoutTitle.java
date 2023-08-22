package requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class CreateTagsWithoutTitle {

        @SerializedName("title")
        public String title;


        public CreateTagsWithoutTitle(String title) {
            super();
            this.title=title;
        }
    }
