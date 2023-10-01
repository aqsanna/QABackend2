package enums;

public enum CollectingOrderValues {
    PREPARATION_TIME("30"),
    RESPONSE("order"),
    GROUP_BY("departments"),
    ASSEMBLED("assembled");


    private final String collectingOrderValues;

    CollectingOrderValues(String collectingOrderValues) {
        this.collectingOrderValues = collectingOrderValues;
    }

    public String getCollectingOrderValues() {
        return collectingOrderValues;
    }
}
