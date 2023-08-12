package requests.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.With;

@With
public class PackagingDelete {
        @SerializedName("pickupByDriver")
        public Boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Boolean advancedCollectingFlow;
        public PackagingDelete(Boolean pickupByDriver, Boolean advancedCollectingFlow) {
            this.pickupByDriver = pickupByDriver;
            this.advancedCollectingFlow = advancedCollectingFlow;
        }
}

