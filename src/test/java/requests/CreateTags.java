package requests;

import lombok.With;

import java.io.Serializable;

@With
public class CreateTags implements Serializable{
    public Params params;

    public CreateTags(Params params) {
        super();
        this.params = params;
    }

    @With
    public static class Params implements Serializable {
        public String title;

        public Params(String title){
            super();
            this.title=title;
        }
    }
}
