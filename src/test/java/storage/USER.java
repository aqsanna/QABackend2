package storage;

public enum USER {
    EMAIL_INFO("info@local.express"),
    BAD_EMAIL("sydney@fife"),
    BUNDLE_ID("com.worldappsystem.LEPartners"),
    APP_VERSION("5.7.2"),
    DEVICE_VERSION("15.0.2"),
    OS("ios"),
    PUSH_TOKEN("f8EbEjHLT0RGqX1jnJGxRj:APA91bHlnkZAGhcjNzfAuJ-ZB7A8-u3K5-lG-dQXfW3gT8A-d-KTmEap1lNHvd7B1wuhc8vVR0IqIKVH5zH3HfsbvfL5F9SCPnrUJfV24lKWJLz997zZv5ba5ksDhiL0DbuyM_PemsJr"),
    APPLICATION_KEY("partnersapp2031f94af9829c64d321d3a210acaad611f76e072ba21a8a6bebb"),
    NAME("Test-CreateProduct Name"),
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
    IS_SHIPPABLE("false"),
    HAS_AVAILABILITY_SCHEDULE("false"),
    PASSWORD("123456");

    private final String user;

    USER(String user) {
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
