package apiTests;

import Utils.OrderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.partner.orders.FilteredListOfOrders;
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


    }
}
