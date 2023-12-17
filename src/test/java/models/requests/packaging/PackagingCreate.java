package models.requests.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.With;
import java.io.Serializable;
import java.util.List;

@With
@Getter
public class PackagingCreate {
        @SerializedName("boxes")
        public List<Box> boxes;
        @SerializedName("packs")
        public List<Pack> packs;
        @SerializedName("pickupByDriver")
        public Boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Boolean advancedCollectingFlow;


        public PackagingCreate(List<Box> boxes, List<Pack> packs, Boolean pickupByDriver, Boolean advancedCollectingFlow) {
            super();
            this.boxes = boxes;
            this.packs = packs;
            this.pickupByDriver = pickupByDriver;
            this.advancedCollectingFlow = advancedCollectingFlow;
        }

        @With
        @Getter
        public static class Box implements Serializable {
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("free_volume_reserve")
            public Integer freeVolumeReserve;
            @SerializedName("weight")
            public String weight;
            @SerializedName("name")
            public String name;
            @SerializedName("length")
            public String length;
            @SerializedName("width")
            public String width;
            @SerializedName("height")
            public String height;


            public Box(String specialEntityTypeId, Integer freeVolumeReserve, String weight, String name, String length, String width, String height) {
                super();
                this.specialEntityTypeId = specialEntityTypeId;
                this.freeVolumeReserve = freeVolumeReserve;
                this.weight = weight;
                this.name = name;
                this.length = length;
                this.width = width;
                this.height = height;
            }
        }

        @With
        @Getter
        public static class Pack implements Serializable {
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("name")
            public String name;
            @SerializedName("price")
            public Double price;
            @SerializedName("free_count")
            public Integer freeCount;
            @SerializedName("upc")
            public String upc;

            public Pack(String specialEntityTypeId, String name, Double price, Integer freeCount, String upc) {
                super();
                this.specialEntityTypeId = specialEntityTypeId;
                this.name = name;
                this.price = price;
                this.freeCount = freeCount;
                this.upc = upc;
            }
        }
}

