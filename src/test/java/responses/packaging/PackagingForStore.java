package responses.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;
@Getter
public class PackagingForStore {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;
    @Getter
    public static class Data{
        @SerializedName("specialTypes")
        public ArrayList<SpecialType> specialTypes;
        @SerializedName("boxes")
        public ArrayList<Box> boxes;
        @SerializedName("packs")
        public ArrayList<Pack> packs;
        @SerializedName("pickupByDriver")
        public boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public boolean advancedCollectingFlow;
        @Getter
        public static class SpecialType{
            @SerializedName("id")
            public String id;
            @SerializedName("type")
            public String type;
            @SerializedName("is_special")
            public String isSpecial;
            @SerializedName("can_mix")
            public String canMix;
            @SerializedName("for_shipping")
            public String forShipping;
            @SerializedName("for_pack")
            public String forPack;
            @SerializedName("for_product")
            public String forProduct;
        }
        @Getter
        public static class Box{
            @SerializedName("id")
            public int id;
            @SerializedName("store_id")
            public String store_id;
            @SerializedName("name")
            public String name;
            @SerializedName("length")
            public int length;
            @SerializedName("width")
            public int width;
            @SerializedName("height")
            public int height;
            @SerializedName("weight")
            public int weight;
            @SerializedName("free_volume_reserve")
            public int freeVolumeReserve;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("storeId")
            public String storeId;
        }
        @Getter
        public static class Pack{
            @SerializedName("id")
            public String id;
            @SerializedName("name")
            public String name;
            @SerializedName("price")
            public String price;
            @SerializedName("free_count")
            public int freeCount;
            @SerializedName("upc")
            public String upc;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("store_id")
            public String storeId;
        }
    }
}
