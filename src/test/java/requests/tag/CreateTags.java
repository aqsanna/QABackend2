package requests.tag;

import lombok.With;

import java.io.Serializable;

@With
public class CreateTags implements Serializable {
    public Params params;

    public CreateTags(Params params) {
        super();
        this.params = params;
    }

    @With
    public static class Params implements Serializable {
        public String title;
        public String icon;
        public String priority;
        public Integer status;
        public Integer visible;
        public Integer show_icon_on_product;

        public Params(String title, String icon, String priority, Integer status, Integer visible, Integer show_icon_on_product) {
            super();
            this.title = title;
            this.icon = icon;
            this.priority = priority;
            this.status=status;
            this.show_icon_on_product=show_icon_on_product;
        }
    }
}
