package models.responses.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import java.util.List;

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
        public List<SpecialType> specialTypes;
        @SerializedName("boxes")
        public List<Box> boxes;
        @SerializedName("packs")
        public List<Pack> packs;
        @SerializedName("pickupByDriver")
        public Boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Boolean advancedCollectingFlow;
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
            public Integer id;
            @SerializedName("store_id")
            public String store_id;
            @SerializedName("name")
            public String name;
            @SerializedName("length")
            public Integer length;
            @SerializedName("width")
            public Integer width;
            @SerializedName("height")
            public Integer height;
            @SerializedName("weight")
            public Integer weight;
            @SerializedName("free_volume_reserve")
            public Integer freeVolumeReserve;
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
            public Integer freeCount;
            @SerializedName("upc")
            public String upc;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("store_id")
            public String storeId;
        }
    }
}
