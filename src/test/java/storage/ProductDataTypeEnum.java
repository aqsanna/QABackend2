package storage;

public enum ProductDataTypeEnum {
    ID("name"),
    NAME("Name");


    private final String datatype;
    ProductDataTypeEnum(String datatype) {
        this.datatype = datatype;
    }

    public String getProductDataType() {
        return datatype;
    }
    public String toString() {
        return "ProductDataTypeEnum{" +
                "ProductDataTypeEnum='" + datatype + '\'' +
                '}';
    }
}
