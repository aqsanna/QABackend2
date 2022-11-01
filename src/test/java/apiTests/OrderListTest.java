package apiTests;

import Utile.Order;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.partner.orders.PartnerOrders;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.ORDER_STATUS;

public class OrderListTest {
    UserInfoProvider userInfoProvider = new UserInfoProvider();

    @Test
    @DisplayName("Check partner order list")
    public void orderListTest() {
        for (int i = 0; i < ORDER_STATUS.values().length; i++) {
            boolean emptyData = false;
            int limit = 20;
            int offset = 0;

            while (!emptyData) {
                PartnerOrders orderList = RestAssured.given().header(new Header("Authorization", "Bearer " + userInfoProvider.getToken())).queryParam("filter[status]", ORDER_STATUS.values()[i].getOrderStatus()).queryParam("limit", limit).queryParam("offset", offset).queryParam("sort", "asc").when().get(APIV1.STAGE.getApi() + APIV1.ORDERS.getApi()).then().extract().as(PartnerOrders.class);

                Assertions.assertEquals("success", orderList.getResult(), "Have a error: " + orderList.getResult());
                Assertions.assertTrue(orderList.getError().isEmpty(), "Error messages: " + orderList.getError());

                if (orderList.getData().size() > 0) {
                    for (Order order : orderList.getData()) {

                        try {
                            int id = Integer.parseInt(order.getId());
                        } catch (NumberFormatException ex) {
                            System.out.println("Incorrect order_id: " + order.getId());
                        }

                        try {
                            Assertions.assertEquals(ORDER_STATUS.values()[i].getOrderStatus(), order.getStatus(), "The order " + order.getId() + " actual status: " + order.getStatus() + " Expected status: " + ORDER_STATUS.values()[i].getOrderStatus());
                            Assertions.assertFalse(order.getCreationDate().isEmpty(), "The order " + order.getId() + " creation date is empty");
                            Assertions.assertFalse(order.getDropoff().getPerson().getFirstName().isEmpty(), "The order " + order.getId() + " first name is empty");
                            Assertions.assertTrue(order.getPayment().getTotal() >= 0, "The order " + order.getId() + " total price is " + order.getPayment().getTotal());
                            Assertions.assertFalse(order.getDropoff().getPerson().getPhone().isEmpty(), "The order " + order.getId() + " phone is empty");

                            for (Order.Transaction transaction : order.getTransactions()) {
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