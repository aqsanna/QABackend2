package requests.packaging;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;
import java.util.ArrayList;

@With
public class PackagingErrorMessages {
        @SerializedName("boxes")
        public ArrayList<Box> boxes;
        @SerializedName("packs")
        public ArrayList<Pack> packs;
        @SerializedName("pickupByDriver")
        public Boolean pickupByDriver;
        @SerializedName("advancedCollectingFlow")
        public Boolean advancedCollectingFlow;

        public PackagingErrorMessages(ArrayList<Box> boxes, ArrayList<Pack> packs, Boolean pickupByDriver, Boolean advancedCollectingFlow) {
            super();
            this.boxes = boxes;
            this.packs = packs;
            this.pickupByDriver = pickupByDriver;
            this.advancedCollectingFlow = advancedCollectingFlow;
        }
        @With
        public static class Box implements Serializable {
            @SerializedName("free_volume_reserve")
            public Integer freeVolumeReserve;
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;
            @SerializedName("weight")
            public Integer weight;

            public Box() {
            }
            public Box(Integer freeVolumeReserve, String specialEntityTypeId, Integer weight) {
                this.freeVolumeReserve = freeVolumeReserve;
                this.specialEntityTypeId = specialEntityTypeId;
                this.weight = weight;
            }

            public Box build() {
                return this;
            }
        }

        @With
        public static class Pack implements Serializable {
            @SerializedName("special_entity_type_id")
            public String specialEntityTypeId;

            public Pack(){
            }
            public Pack(String specialEntityTypeId) {
                this.specialEntityTypeId = specialEntityTypeId;
            }
            public Pack build() {
                return this;
            }
        }
}

