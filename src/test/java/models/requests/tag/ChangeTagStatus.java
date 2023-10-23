package models.requests.tag;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class ChangeTagStatus {

        @SerializedName("status")
        public Integer status;


        public ChangeTagStatus(Integer status) {
            super();
            this.status=status;
        }
    }
