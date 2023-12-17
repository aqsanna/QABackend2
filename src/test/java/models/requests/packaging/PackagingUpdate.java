package models.requests.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.With;
import java.io.Serializable;
import java.util.List;

@With
@Getter
public class PackagingUpdate {
        @SerializedName("boxes")
        public List<Box> boxes;
        @SerializedName("packs")
        public List<Pack> packs;
        @SerializedName("pickupByDriver")
        public Boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Boolean advancedCollectingFlow;

        public PackagingUpdate(List<Box> boxes, List<Pack> packs, Boolean pickupByDriver, Boolean advancedCollectingFlow) {
            super();
            this.boxes = boxes;
            this.packs = packs;
            this.pickupByDriver = pickupByDriver;
            this.advancedCollectingFlow = advancedCollectingFlow;
        }

        @With
        @Getter
        public static class Box implements Serializable {
            @SerializedName("id")
            public Integer id;
            @SerializedName("store_id")
            public String store_id;
            @SerializedName("name")
            public String name;
            @SerializedName("length")
            public String length;
            @SerializedName("width")
            public String width;
            @SerializedName("height")
            public String height;
            @SerializedName("weight")
            public String weight;
            @SerializedName("free_volume_reserve")
            public String freeVolumeReserve;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("storeId")
            public String storeId;
            public Box(Integer id, String store_id, String name, String length, String width, String height,
                       String weight, String freeVolumeReserve, String specialEntityTypeId, String storeId) {
                this.id = id;
                this.store_id = store_id;
                this.name = name;
                this.length = length;
                this.width = width;
                this.height = height;
                this.weight = weight;
                this.freeVolumeReserve = freeVolumeReserve;
                this.specialEntityTypeId = specialEntityTypeId;
                this.storeId = storeId;
            }
        }
        @With
        @Getter
        public static class Pack implements Serializable {
            @SerializedName("id")
            public String id;
            @SerializedName("name")
            public String name;
            @SerializedName("price")
            public Double price;
            @SerializedName("free_count")
            public Integer freeCount;
            @SerializedName("upc")
            public String upc;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("storeId")
            public String storeId;
            public Pack(){
            }
            public Pack(String id, String name, Double price, Integer freeCount, String upc, String specialEntityTypeId, String storeId) {
                super();
                this.id= id;
                this.name = name;
                this.price = price;
                this.freeCount = freeCount;
                this.upc = upc;
                this.specialEntityTypeId = specialEntityTypeId;
                this.storeId = storeId;
            }
        }
}

