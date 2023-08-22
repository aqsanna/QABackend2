package requests.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;
import java.util.ArrayList;

@With
public class PackagingErrorMessagesForInvalidCredential {
        @SerializedName("boxes")
        public ArrayList<Box> boxes;
        @SerializedName("packs")
        public ArrayList<Pack> packs;
        @SerializedName("pickupByDriver")
        public Integer pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Integer advancedCollectingFlow;

        public PackagingErrorMessagesForInvalidCredential(ArrayList<Box> boxes, ArrayList<Pack> packs, Integer pickupByDriver, Integer advancedCollectingFlow) {
            super();
            this.boxes = boxes;
            this.packs = packs;
            this.pickupByDriver = pickupByDriver;
            this.advancedCollectingFlow = advancedCollectingFlow;
        }
        @With
        public static class Box implements Serializable {
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


            public Box() {
            }
            public Box(Integer length, Integer width, Integer height,  Integer weight,  Integer freeVolumeReserve, String specialEntityTypeId) {
                this.freeVolumeReserve = freeVolumeReserve;
                this.specialEntityTypeId = specialEntityTypeId;
                this.weight = weight;
                this.length = length;
                this.width = width;
                this.height = height;
            }

            public Box build() {
                return this;
            }
        }

        @With
        public static class Pack implements Serializable {
            @SerializedName("price")
            public String price;
            @SerializedName("free_count")
            public Integer freeCount;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;



            public Pack(){
            }
            public Pack( String price, Integer freeCount, String specialEntityTypeId ) {
                this.price = price;
                this.freeCount= freeCount;
                this.specialEntityTypeId = specialEntityTypeId;

            }
            public Pack build() {
                return this;
            }
        }
}

