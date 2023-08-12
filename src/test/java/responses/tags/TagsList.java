package responses.tags;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class TagsList {
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
            @SerializedName("partner_id")
            public String partnerId;
            @SerializedName("icon")
            public String icon;
            @SerializedName("visible")
            public Integer visible;
            @SerializedName("status")
            public Integer status;
            @SerializedName("show_icon_on_product")
            public Integer showIconOnProduct;
            @SerializedName("priority")
            public Integer priority;
            @SerializedName("title")
            public String title;
            @SerializedName("products")
            public Integer products;
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
