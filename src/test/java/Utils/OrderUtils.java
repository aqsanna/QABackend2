package Utils;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import requests.AddPack;
import requests.CollectOrderProduct;
import requests.OrderConfirm;
import requests.OrderStart;
import responses.pack.AddPacksToOrder;
import responses.partner.orders.Order;
import responses.partner.orders.PartnerOrders;
import steps.data.users.UserInfoProvider;
import storage.APIV1;
import storage.APIV2;

public class OrderUtils {
    Gson gson = new Gson();
    public PartnerOrders getOrderList(String orderStatus, int limit, int offset){
        PartnerOrders orderList = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .queryParam("filter[status]", orderStatus)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .queryParam("sort", "asc")
                .when()
                .get(APIV1.STAGE.getApi() + APIV1.ORDERS.getApi())
                .then()
                .extract().as(PartnerOrders.class);
        Assertions.assertEquals("success", orderList.getResult(), "Have a error: " + orderList.getResult());
        Assertions.assertTrue(orderList.getError().isEmpty(), "Error messages: " + orderList.getError());
        return  orderList;
    }
    public Order getOrder(String orderId){
        Order order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .get(APIV1.STAGE.getApi() + APIV1.ORDERS.getApi() + "/" + orderId)
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", order.getResult(), "Have a error: " + order.getResult());
        Assertions.assertTrue(order.getError().isEmpty(), "Error messages: " + order.getError());
        Assertions.assertEquals(orderId, order.getData().getId(), "Get order: The order ids are not equal");
        return order;
    }
    public Order postConfirmOrder(String orderId, OrderConfirm data){
        Order confirmedOrder = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(APIV1.STAGE.getApi() + APIV1.ORDERS_TO.getApi() + orderId + APIV1.CONFIRM.getApi())
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", confirmedOrder.getResult(), "Have a error: " + confirmedOrder.getResult());
        Assertions.assertTrue(confirmedOrder.getError().isEmpty(), "Error messages: " + confirmedOrder.getError());
        Assertions.assertEquals(orderId, confirmedOrder.getData().getId(), "Confirm order: The order ids are not equal");
        return confirmedOrder;
    }

    public Order postStartOrder(String orderId, OrderStart data){
        Order startOrder = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(APIV1.STAGE.getApi() + APIV1.ORDERS_TO.getApi() + orderId + APIV1.ORDER_START.getApi())
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", startOrder.getResult(), "Have a error: " + startOrder.getResult());
        Assertions.assertTrue(startOrder.getError().isEmpty(), "Error messages: " + startOrder.getError());
        Assertions.assertEquals(orderId, startOrder.getData().getId(), "Start order: The order ids are not equal");
        return startOrder;
    }

    public Order postCollectOrderProduct(String orderProductId, CollectOrderProduct data){
        Order order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(APIV1.STAGE.getApi() + APIV1.ORDER_ITEMS.getApi() + orderProductId)
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", order.getResult(), "Have a error: " + order.getResult());
        Assertions.assertTrue(order.getError().isEmpty(), "Error messages: " + order.getError());
        return order;
    }
    public AddPacksToOrder postAddPacksToOrder(String orderId, AddPack data){
        AddPacksToOrder order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(APIV1.STAGE.getApi() + APIV2.ADD_PACKS_URL.getApi() + orderId + APIV2.ADD_PACKS.getApi())
                .then()
                .extract().as(AddPacksToOrder.class);
        Assertions.assertEquals("OK", order.getCode(), "Have a error: " + order.getMessage());
        return order;
    }
}
