package storage;

public enum USER {
    EMAIL("info@local.express"),
    BAD_EMAIL("sydney@fife"),
    BUNDLE_ID("com.worldappsystem.LEPartners"),
    APP_VERSION("5.7.2"),
    DEVICE_VERSION("15.0.2"),
    OS("ios"),
    PUSH_TOKEN("f8EbEjHLT0RGqX1jnJGxRj:APA91bHlnkZAGhcjNzfAuJ-ZB7A8-u3K5-lG-dQXfW3gT8A-d-KTmEap1lNHvd7B1wuhc8vVR0IqIKVH5zH3HfsbvfL5F9SCPnrUJfV24lKWJLz997zZv5ba5ksDhiL0DbuyM_PemsJr"),
    APPLICATION_KEY("andranikr9ae8uv7t8aijkes02lgwhwwqk6o9q2s00uboqv8a82dd5tjsfzpxoyn"),
    PASSWORD("123456Ii");

    private String user;

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
