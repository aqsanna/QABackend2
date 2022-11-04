package storage;

import java.util.ArrayList;
import java.util.List;

public enum ProductDataTypeEnum {
    ID("name"),
    ID1("category"),
    ID2("price"),
    ID3("displayed_value_for_price"),
    ID4("price_unit"),
    ID5("images"),
    ID6("taxes"),
    ID7("sales"),
    ID8("tags"),
    ID9("info"),
    ID10("barcode"),
    ID11("upc"),
    ID12("availability"),
    ID13("in_stock"),
    ID14("inventory"),
    ID15("modifications"),
    ID16("shipping_data"),
    ID17("store_product_mapping"),
    ID18("qty_in_pack"),
    NAME("Name"),
    NAME1("Category/Department"),
    NAME2("Price"),
    NAME3("Displayed Value for Price"),
    NAME4("Price Unit"),
    NAME5("Volume"),
    NAME6("Images"),
    NAME7("Taxes"),
    NAME8("Sales"),
    NAME9("Tags"),
    NAME10("Info"),
    NAME11("Barcode"),
    NAME12("Upc"),
    NAME13("Availability"),
    NAME14("In Stock"),
    NAME15("Inventory"),
    NAME16("Modifications"),
    NAME17("Shipping Data"),
    NAME18("Product Mapping"),
    NAME19("Quantity in Pack");



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
    public static List<String> getType(){
        List<String> listType = new ArrayList<String>();
        for(ProductDataTypeEnum l : ProductDataTypeEnum.values()){
            listType.add(l.getProductDataType());
        }
        return listType;
    }
}
