package apiTests;

import Utils.OrderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.pack.PackagingForStore;
import responses.partner.orders.FilteredListOfOrders;
import responses.partner.orders.OrderV2;
import steps.data.order.OrderProvider;
import storage.OrderMode;
import storage.OrderStatus;
import storage.USER;

import java.util.ArrayList;

public class CollectingShippingOrderTest {
    OrderUtils orderUtils = new OrderUtils();
    @Test
    @DisplayName("Check the order collecting for shipping")
    public void collectingShippingOrderTest(){
        ArrayList<String> orderStatus = new ArrayList<>();
        ArrayList<String> orderType = new ArrayList<>();
        orderStatus.add(OrderStatus.ASSEMBLED.getOrderStatus());
        orderType.add(OrderMode.SHIPPING.getOrderMode());
        FilteredListOfOrders filteredListOfOrders = orderUtils.postFilterOrders(OrderProvider.filterOrder(USER.EMAIL_INFO, orderStatus, orderType));
        FilteredListOfOrders.Data.Result firstOrder = filteredListOfOrders.getData().getResult().get(0);
        OrderV2 order = orderUtils.postChangeOrderStatus(firstOrder.getId(), OrderProvider.changeOrderStatus(USER.EMAIL_INFO, OrderStatus.PACKING.getOrderStatus()));
        PackagingForStore packaging = orderUtils.getStorePackaging();
//        ArrayList<Integer> productIds= new ArrayList<Integer>();
//        for (OrderV2.Data.Product product: order.getData().getProducts()) {
//            productIds.add(product.getId());
//        }
//        System.out.println(productIds);
    }
}
