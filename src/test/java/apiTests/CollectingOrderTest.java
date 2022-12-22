package apiTests;

import Utils.OrderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.partner.orders.Order;
import responses.partner.orders.PartnerOrders;
import steps.data.order.AddPacksToOrderProvider;
import steps.data.order.OrderProvider;
import storage.OrderStatus;
import storage.USER;
public class CollectingOrderTest {
    @Test
    @DisplayName("Check the order collecting")
    public void collectingOrderTest() {
        OrderUtils orderUtils = new OrderUtils();
        PartnerOrders getNewOrders = orderUtils.getOrderList(OrderStatus.NEW.getOrderStatus(), 20, 0);
        PartnerOrders.Order order = getNewOrders.getData().get(0);
        String orderId = order.getId();
        Order confirmOrder;

        if (!order.isConfirmed()) {
            confirmOrder = orderUtils.postConfirmOrder(orderId, OrderProvider.orderConfirm(USER.EMAIL_INFO));
            Assertions.assertTrue(confirmOrder.getData().isConfirmed(), "The order" + orderId + "isn't confirmed");
        }

        Order startOrder = orderUtils.postStartOrder(orderId, OrderProvider.orderStart(USER.EMAIL_INFO));
        Assertions.assertEquals("assembling", startOrder.getData().getStatus(), "Order is not started collecting, The order status is" + startOrder.getData().getStatus());

        for (Order.Data.GroupedItem groupedItem : startOrder.getData().getGroupedItems()) {
            for (Order.Data.GroupedItem.OrderProduct orderProduct : groupedItem.getOrderProducts()) {
                Order assembledProductOrder = orderUtils.postCollectOrderProduct(orderProduct.getId(), OrderProvider.collectOrderProduct(USER.EMAIL_INFO));
                Order.Data.GroupedItem.OrderProduct orderProductItem = assembledProductOrder.getData().getGroupedItems()
                        .stream().flatMap(groupedItem1 -> groupedItem1.getOrderProducts()
                                .stream().filter(orderProduct1 -> orderProduct1.getId().equals(orderProduct.getId())))
                                .findAny()
                                .orElse(null);
                Assertions.assertEquals("assembled", orderProductItem.getStatus(), "The order product is not assembled, Order id: " + orderId + " orderProductId: " + orderProductItem.getId());
            }
        }

        if (startOrder.getData().getWrapping().isHasAdvancedCollectingFlow()){
            String packId = startOrder.getData().getWrapping().getPacks().get(0).getId();
            float price = Float.parseFloat(startOrder.getData().getWrapping().getPacks().get(0).getPrice());
            for(Order.Data.Wrapping.Pack pack : startOrder.getData().getWrapping().getPacks()){
                if(Integer.parseInt(pack.getFreeQty()) > 0){
                    packId = pack.getId();
                    break;
                }
                else if (Float.parseFloat(pack.getPrice()) <= price) {
                    packId = pack.getId();
                }
            }
            orderUtils.postAddPacksToOrder(orderId, AddPacksToOrderProvider.addPack(USER.EMAIL_INFO, packId, "1"));
            orderUtils.postAddPackLocation(orderId, AddPacksToOrderProvider.addPackLocations(USER.EMAIL_INFO, null, packId, ""));
            orderUtils.postPrintPackLocation(orderId, AddPacksToOrderProvider.printPackLocation(USER.EMAIL_INFO, "2"));
        }
        System.out.println(orderId);
        orderUtils.postFinishOrder(orderId, OrderProvider.orderConfirm(USER.EMAIL_INFO));

    }
}
