package enums;

import java.util.ArrayList;
import java.util.List;

public enum ProductDataType {
    ID("name"),
    ID1("category"),
    ID2("price"),
    ID3("displayed_value_for_price"),
    ID4("price_unit"),
    ID5("volume"),
    ID6("images"),
    ID7("taxes"),
    ID8("sales"),
    ID9("tags"),
    ID10("info"),
    ID11("barcode"),
    ID12("upc"),
    ID13("availability"),
    ID14("in_stock"),
    ID15("inventory"),
    ID16("modifications"),
    ID17("shipping_data"),
    ID18("store_product_mapping"),
    ID19("qty_in_pack"),
    ID20("is_foodstamp"),
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
    NAME19("Quantity in Pack"),
    NAME20("Is Foodstamp");


    private final String datatype;

    ProductDataType(String datatype) {
        this.datatype = datatype;
    }

    public static List<String> getType() {
        List<String> listType = new ArrayList<String>();
        for (ProductDataType l : ProductDataType.values()) {
            listType.add(l.getProductDataType());
        }
        return listType;
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
