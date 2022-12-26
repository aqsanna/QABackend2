package apiTests;

import Utils.OrderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.pack.PackagingForStore;
import responses.partner.orders.FilteredListOfOrders;
import responses.partner.orders.OrderV2;
import responses.partner.orders.ShippingRates;
import steps.data.order.AddPacksToOrderProvider;
import steps.data.order.OrderProvider;
import storage.ExpandParams;
import storage.OrderMode;
import storage.OrderStatus;
import storage.USER;

import java.util.ArrayList;
import java.util.Objects;

public class CollectingShippingOrderTest {
    OrderUtils orderUtils = new OrderUtils();
    @Test
    @DisplayName("Check the order collecting for shipping")
    public void collectingShippingOrderTest(){
        ArrayList<String> orderStatus = new ArrayList<>();
        ArrayList<String> orderType = new ArrayList<>();

        orderStatus.add(OrderStatus.ASSEMBLED.getOrderStatus());
        orderStatus.add(OrderStatus.PACKING.getOrderStatus());
        orderType.add(OrderMode.SHIPPING.getOrderMode());

        FilteredListOfOrders filteredListOfOrders = orderUtils.postFilterOrders(OrderProvider.filterOrder(USER.EMAIL_INFO, orderStatus, orderType));
        Assertions.assertTrue(filteredListOfOrders.getData().getResult().size() >= 1, "Filtered list is empty");
        FilteredListOfOrders.Data.Result orderResult = filteredListOfOrders.getData().getResult().get(0);
        String orderId = filteredListOfOrders.getData().getResult().get(0).getId();
        OrderV2 order;

        if (Objects.equals(orderResult.getStatus(), OrderStatus.ASSEMBLED.getOrderStatus())){
            order = orderUtils.postChangeOrderStatus(orderId,
                    OrderProvider.changeOrderStatus(USER.EMAIL_INFO, OrderStatus.PACKING.getOrderStatus()),
                    ExpandParams.PRODUCTS.getExpandParams() + ", " + ExpandParams.PRODUCT_SHIPPING_PACKAGING_BOXES.getExpandParams());
        }else {
            order = orderUtils.getOrderDetails(orderId,
                    ExpandParams.PRODUCTS.getExpandParams() + ", " + ExpandParams.PRODUCT_SHIPPING_PACKAGING_BOXES.getExpandParams());
        }

        if(Objects.equals(order.getData().getProductShippingPackagingBoxes().size(), 0)){
            PackagingForStore packaging = orderUtils.getStorePackaging();

            Integer boxId = packaging.getData().getBoxes().get(0).getId();
            ArrayList<Integer> productIds = new ArrayList<Integer>();
            ArrayList<OrderV2.Data.Product> products = order.getData().getProducts();
            for (OrderV2.Data.Product product: products) {
                productIds.add(product.getId());
            }
            OrderV2 orderAddedToBox = orderUtils.postProductAddToBox(orderId,
                    AddPacksToOrderProvider.productAddBox(USER.EMAIL_INFO, productIds, boxId),
                    ExpandParams.SHIPPING_RATE.getExpandParams());
            System.out.println(orderAddedToBox.getData().getShippingRate());
        }

        ShippingRates shippingRates = orderUtils.shippingRates(orderId);

    }
}
