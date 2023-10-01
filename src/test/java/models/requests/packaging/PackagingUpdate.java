package models.requests.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.With;
import java.io.Serializable;
import java.util.ArrayList;

@With
public class PackagingUpdate {
        @SerializedName("boxes")
        public ArrayList<Box> boxes;
        @SerializedName("packs")
        public ArrayList<Pack> packs;
        @SerializedName("pickupByDriver")
        public Boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Boolean advancedCollectingFlow;

        public PackagingUpdate(ArrayList<Box> boxes, ArrayList<Pack> packs, Boolean pickupByDriver, Boolean advancedCollectingFlow) {
            super();
            this.boxes = boxes;
            this.packs = packs;
            this.pickupByDriver = pickupByDriver;
            this.advancedCollectingFlow = advancedCollectingFlow;
        }

        @With
        public static class Box implements Serializable {
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

            public Box() {
            }
            public Box(Integer id, String store_id, String name, Integer length, Integer width, Integer height,
                       Integer weight, Integer freeVolumeReserve, String specialEntityTypeId, String storeId) {
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
            public Box build() {
                return this;
            }
        }
        @With
        public static class Pack implements Serializable {
            @SerializedName("id")
            public Integer id;
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
            @SerializedName("storeId")
            public String storeId;
            public Pack(){
            }
            public Pack(Integer id, String name, String price, Integer freeCount, String upc, String specialEntityTypeId, String storeId) {
                super();
                this.id= id;
                this.name = name;
                this.price = price;
                this.freeCount = freeCount;
                this.upc = upc;
                this.specialEntityTypeId = specialEntityTypeId;
                this.storeId = storeId;
            }
            public Pack build() {
                return this;
            }
        }
}

