package requests;

import com.google.gson.annotations.SerializedName;

public class AddPack {
    @SerializedName("id")
    public String id;
    @SerializedName("qty")
    public String qty;

    public AddPack(String id, String qty) {
        this.id = id;
        this.qty = qty;
    }
}
