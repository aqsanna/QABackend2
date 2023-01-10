package storage;

public enum User {
    EMAIL_INFO("info@local.express"),
    EMAIL_CLIENT("oqsannas+31102022@localexpress.io"),
    BAD_EMAIL("sydney@fife"),
    BUNDLE_ID("com.worldappsystem.LEPartners"),
    APP_VERSION("5.7.2"),
    DEVICE_VERSION("15.0.2"),
    OS("ios"),
    PUSH_TOKEN("f8EbEjHLT0RGqX1jnJGxRj:APA91bHlnkZAGhcjNzfAuJ-ZB7A8-u3K5-lG-dQXfW3gT8A-d-KTmEap1lNHvd7B1wuhc8vVR0IqIKVH5zH3HfsbvfL5F9SCPnrUJfV24lKWJLz997zZv5ba5ksDhiL0DbuyM_PemsJr"),
    APPLICATION_KEY("partnersapp2031f94af9829c64d321d3a210acaad611f76e072ba21a8a6bebb"),
    APPLICATION_CLIENT("yourgrocerystore6aKp9IXiKEIhEByJkMsZ4d65eKi2h8rO56JZYd9RcQKwmWrr"),
    PASSWORD_CLIENT("Local@123"),
    PASSWORD("123456Ii"),
    NAME("Test-CreateProduct Name"),
    UPC("351578977348"),
    CATEGORY_ID("48343"),
    PRICE("7.3"),
    PRICE_UNITS("each"),
    VOLUME("20"),
    VOLUME_UNITS("lb"),
    QUANTITY_IN_PACK("10"),
    DISPLAYED_VALUE_FOR_PRICE("8"),
    DESCRIPTION("test text description"),
    INGREDIENTS("text ingredients"),
    TAG_IDS("144"),
    IS_FOODSTAMP("true"),
    IS_SHIPPABLE("true"),
    SEQUENCE("save-tax63a58f9e63ef6"),
    APPLICATIONKEY("partnerbetatpqseyxgmbcuvyxctwfhibfqyurbglzlvowfjmeztqafrenipFUUU"),
    ACTION("save-tax"),
    TITLE("TestTaxName"),
    VISIBLE_TITLE("TestVT"),
    IS_ACTIVE("1"),
    STORE_ID("87"),
    PER_UNIT("1"),
    IS_CRV("0"),
    VALUE("2"),
    TYPE("fixed"),
    APPLY_TO_ALL_PRODUCTS("0"),
    LANGUAGES("en-US"),
    CONTENTLANG("en-US"),
    COMMOND("POST"),
    HAS_AVAILABILITY_SCHEDULE("false"),
    ICON("https://cdn.stage.local.express/img/JyeicWbpavIiO2Ln1Wl2clRw9lbnLldWYneuZ09mb4A0lXaVavE3S2Zh1WBnauU=0nIn.jpg"),
    PRIORITY("10");

    private final String user;

    User(String user) {
        this.user = user;
    }

    public String getUserData() {
        return user;
    }

    @Override
    public String toString() {
        return "USERS{" +
                "user='" + user + '\'' +
                '}';
    }
}
