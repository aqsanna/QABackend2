package models.responses.modificationItems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ModificationItemsList {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;

    @Getter
    public static class Data{
        @SerializedName("result")
        public ArrayList<Result> result;
        @SerializedName("_links")
        public Links _links;
        @SerializedName("_meta")
        public Meta _meta;
        @Getter
        public static class Result{
            @SerializedName("id")
            public String id;
            @SerializedName("store_id")
            public String storeId;
            @SerializedName("price_change")
            public Integer priceChange;
            @SerializedName("upc")
            public String upc;
            @SerializedName("type")
            public String type;
            @SerializedName("image")
            public String image;
            @SerializedName("title")
            public String title;
            @SerializedName("description")
            public String description;
            @SerializedName("is_instock")
            public Integer isInstock;
            @SerializedName("is_multiline")
            public Integer isMultiline;
            @SerializedName("min_length")
            public Integer minLength;
            @SerializedName("max_length")
            public Integer maxLength;
            @SerializedName("taxes")
            public ArrayList<Taxes> taxes;
        }
        @Getter
        public static class Taxes{
            @SerializedName("id")
            public String id;
            @SerializedName("store_id")
            public String storeId;

        }
        @Getter
        public static class Links{
            @SerializedName("self")
            public Self self;
            @SerializedName("next")
            public Next next;
            @SerializedName("last")
            public Last last;
            @Getter
            public static class Self{
                @SerializedName("href")
                public String href;
            }
            @Getter
            public static class Next{
                @SerializedName("href")
                public String href;
            }
            @Getter
            public static class Last{
                @SerializedName("href")
                public String href;
            }
        }
        @Getter
        public static class Meta{
            @SerializedName("totalCount")
            public Integer totalCount;
            @SerializedName("pageCount")
            public Integer pageCount;
            @SerializedName("currentPage")
            public Integer currentPage;
            @SerializedName("perPage")
            public Integer perPage;
        }
    }
}
