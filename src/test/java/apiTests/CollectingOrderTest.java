package apiTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.OrderConfirm;
import responses.partner.orders.Order;
import responses.partner.orders.PartnerOrders;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.OrderStatus;

public class CollectingOrderTest {
    Gson gson = new Gson();

    @Test
    @DisplayName("Check partner order list")
    public void collectingOrderTest(){
        UserInfoProvider userInfoProvider = new UserInfoProvider();
        PartnerOrders getNewOrders = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + userInfoProvider.getToken()))
                .queryParam("filter[status]", OrderStatus.NEW.getOrderStatus())
                .queryParam("limit", 20)
                .queryParam("offset", 0)
                .queryParam("sort", "asc")
                .when()
                .get(APIV1.STAGE.getApi() + APIV1.ORDERS.getApi())
                .then()
                .extract().as(PartnerOrders.class);
        Assertions.assertEquals("success", getNewOrders.getResult(), "Have a error: " + getNewOrders.getResult());
        Assertions.assertTrue(getNewOrders.getError().isEmpty(), "Error messages: " + getNewOrders.getError());
        String orderId = null;
        for (PartnerOrders.Order order : getNewOrders.getData()){
            if(!order.isConfirmed()){
                orderId = order.getId();
            }
        }


        System.out.println(orderId + "as");
        Order order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .get(APIV1.STAGE.getApi() + APIV1.ORDERS.getApi() + "/" + orderId)
                .then()
                .extract().as(Order.class);

        Assertions.assertEquals("success", order.getResult(), "Have a error: " + order.getResult());
        Assertions.assertTrue(order.getError().isEmpty(), "Error messages: " + order.getError());
        Assertions.assertEquals(orderId, order.getData().getId(), "Request order Id " + orderId + " is not equal with response order Id " + order.getData().getId());
        Assertions.assertEquals(order.getData().getStatus().toLowerCase(), OrderStatus.NEW.getOrderStatus().toLowerCase(), "The order status is not NEW");

        Order confirmOrder = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(new OrderConfirm()))
                .post(APIV1.STAGE.getApi() + APIV1.ORDERS_TO.getApi() + orderId + APIV1.CONFIRM.getApi())
                .then()
                .extract().as(Order.class);

        System.out.println(confirmOrder);

    }
}
