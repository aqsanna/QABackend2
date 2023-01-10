package responses.tags;

import lombok.Getter;

@Getter
public class SuccessCreateTags {
    private Integer code;
    private String result;
    private String error;
    private Data data;

    public SuccessCreateTags whitCode(Integer code) {
        this.code = code;
        return this;
    }

    public SuccessCreateTags whitResult(String result) {
        this.result = result;
        return this;
    }

    public SuccessCreateTags whitError(String error) {
        this.error = error;
        return this;
    }

    public SuccessCreateTags withData(Data data) {
        this.data = data;
        return this;
    }

    @Getter
    public static class Data {
        private String id;
        private String title;


        public Data withId(String id) {
            this.id = id;
            return this;
        }

        public Data withTitle(String title) {
            this.title = title;
            return this;
        }
    }

}
