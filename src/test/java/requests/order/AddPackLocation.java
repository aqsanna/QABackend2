package requests.order;

import com.google.gson.annotations.SerializedName;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.Getter;

@Getter
public class AddPackLocation {
    @SerializedName("id")
    @Nullable
    public String id;
    @SerializedName("pack_id")
    public String packId;
    @SerializedName("place")
    public String place;
    @SerializedName("placement_id")
    public String placementId;

    public AddPackLocation(String id, String packId, String place, String placementId) {
        this.id = id;
        this.packId = packId;
        this.place = place;
        this.placementId = placementId;
    }
}
