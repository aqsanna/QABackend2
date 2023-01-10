package responses.tags;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TagsEdit {
    private String message;
    private String code;
    private Data data;

    public TagsEdit withMessage(String message) {
        this.message = message;
        return this;
    }

    public TagsEdit withCode(String code) {
        this.code = code;
        return this;
    }

    public TagsEdit withData(Data data) {
        this.data = data;
        return this;
    }

    @Getter
    public static class Data {
        private String id;
        @SerializedName("partner_id")
        private String partnerId;
        private String icon;
        private Integer visible;
        private Integer status;
        @SerializedName("show_icon_on_product")
        private Integer showIconOnProduct;
        private String priority;
        private String title;
        private Integer products;

        public Data withId(String id) {
            this.id = id;
            return this;
        }

        public Data withPartnerId(String partnerId) {
            this.partnerId = partnerId;
            return this;
        }

        public Data withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Data withVisible(Integer visible) {
            this.visible = visible;
            return this;
        }

        public Data withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Data withShowIconOnProduct(Integer showIconOnProduct) {
            this.showIconOnProduct = showIconOnProduct;
            return this;
        }

        public Data withPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public Data withTitle(String title) {
            this.title = title;
            return this;
        }

        public Data withProducts(Integer products) {
            this.products = products;
            return this;
        }
    }

}
