package requests;

import com.google.gson.annotations.SerializedName;
import lombok.With;

import java.io.Serializable;
import java.util.List;

@With
public class TaxesUpdate implements Serializable {
    private String sequence;
    private String applicationKey;
    private String action;
    private Params params;
    private String command;

    public TaxesUpdate(){

    }

    public TaxesUpdate(String sequence, String applicationKey, String action, Params params, String command) {
        super();
        this.sequence = sequence;
        this.applicationKey = applicationKey;
        this.action = action;
        this.params = params;
        this.command = command;

    }


    @With
    public static class Params implements Serializable {
        public String id;
        @SerializedName("is_active")
        public String isActive;
        public String title;
        @SerializedName("visible_title")
        public String visibleTitle;
        @SerializedName("store_id")
        public String storeId;
        public String description;
        @SerializedName("per_unit")
        public String perUnit;
        @SerializedName("is_crv")
        public String isCrv;
        public String value;
        public String type;
        @SerializedName("apply_to_all_products")
        public String applyToAllProducts;
        public String token;
        public String language;
        public String contentLang;


        public Params(){
        }

        public Params(String id, String isActive, String title, String visibleTitle, String storeId, String description, String perUnit,
                      String isCrv, String value, String type, String applyToAllProducts,  String token, String language, String contentLang) {
            super();
            this.id=id;
            this.isActive = isActive;
            this.title = title;
            this.visibleTitle = visibleTitle;
            this.storeId = storeId;
            this.description = description;
            this.perUnit = perUnit;
            this.isCrv = isCrv;
            this.value = value;
            this.type = type;
            this.applyToAllProducts = applyToAllProducts;
            this.token=token;
            this.language=language;
            this.contentLang=contentLang;
        }
    }

}
