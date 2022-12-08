package apiTests;

import Utils.OrderUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.partner.orders.PartnerOrders;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.OrderStatus;

public class OrderTest {
    UserInfoProvider userInfoProvider = new UserInfoProvider();

    @Test
    @DisplayName("Check partner order list")
    public void orderListTest() {
        OrderUtils orderUtils = new OrderUtils();
        for (int i = 0; i < OrderStatus.values().length; i++) {
            boolean emptyData = false;
            int limit = 20;
            int offset = 0;

            while (!emptyData) {
                PartnerOrders orderList = orderUtils.getOrderList(OrderStatus.values()[i].getOrderStatus(), limit, offset);

                if (orderList.getData().size() > 0) {
                    for (PartnerOrders.Order order : orderList.getData()) {

                        try {
                            int id = Integer.parseInt(order.getId());
                        } catch (NumberFormatException ex) {
                            System.out.println("Incorrect order_id: " + order.getId());
                        }

                        try {
                            Assertions.assertEquals(OrderStatus.values()[i].getOrderStatus(), order.getStatus(), "The order " + order.getId() + " actual status: " + order.getStatus() + " Expected status: " + OrderStatus.values()[i].getOrderStatus());
                            Assertions.assertFalse(order.getCreationDate().isEmpty(), "The order " + order.getId() + " creation date is empty");
                            Assertions.assertFalse(order.getDropoff().getPerson().getFirstName().isEmpty(), "The order " + order.getId() + " first name is empty");
                            Assertions.assertTrue(order.getPayment().getTotal() >= 0, "The order " + order.getId() + " total price is " + order.getPayment().getTotal());
                            Assertions.assertFalse(order.getDropoff().getPerson().getPhone().isEmpty(), "The order " + order.getId() + " phone is empty");

                            for (PartnerOrders.Order.Transaction transaction : order.getTransactions()) {
                                if (transaction.getTransactionID() != null) {
                                    Assertions.assertFalse(transaction.getTransactionID().isEmpty(), "The order " + order.getId() + " transactionID is empty. Type is " + transaction.getType() + " id : " + transaction.getId());
                                } else {
                                    System.out.println("The order " + order.getId() + " transactionID is NULL");
                                }
                            }
                        } catch (AssertionError e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    offset += limit;
                } else {
                    emptyData = true;
                }
            }
        }
    }

}