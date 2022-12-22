package Utils;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import requests.order.*;
import responses.pack.PacksToOrder;
import responses.pack.PackLocation;
import responses.partner.orders.FilteredListOfOrders;
import responses.pack.PacksToOrder;
import responses.partner.orders.Order;
import responses.partner.orders.PartnerOrders;
import steps.data.users.UserInfoProvider;
import storage.ApiV2;
import storage.ApiV1;

import java.util.ArrayList;

public class OrderUtils {
    Gson gson = new Gson();

    public PartnerOrders getOrderList(String orderStatus, int limit, int offset) {
        PartnerOrders orderList = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .queryParam("filter[status]", orderStatus)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .queryParam("sort", "asc")
                .when()
                .get(ApiV1.STAGE.getApi() + ApiV1.ORDERS.getApi())
                .then()
                .extract().as(PartnerOrders.class);
        Assertions.assertEquals("success", orderList.getResult(), "Can't get orders list. Have a error: " + orderList.getResult());
        Assertions.assertTrue(orderList.getError().isEmpty(), "Error messages: " + orderList.getError());
        return orderList;
    }

    public Order getOrder(String orderId) {
        Order order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .get(ApiV1.STAGE.getApi() + ApiV1.ORDERS.getApi() + "/" + orderId)
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", order.getResult(), "Can't get the order" + orderId + ". Have a error: " + order.getResult());
        Assertions.assertTrue(order.getError().isEmpty(), "Error messages: " + order.getError());
        Assertions.assertEquals(orderId, order.getData().getId(), "Get order: The order ids are not equal");
        return order;
    }

    public Order postConfirmOrder(String orderId, OrderConfirm data) {
        Order confirmedOrder = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV1.ORDERS_TO.getApi() + orderId + ApiV1.CONFIRM.getApi())
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", confirmedOrder.getResult(), "Can't confirm the order" + orderId + ". Have a error: " + confirmedOrder.getResult());
        Assertions.assertTrue(confirmedOrder.getError().isEmpty(), "Error messages: " + confirmedOrder.getError());
        Assertions.assertEquals(orderId, confirmedOrder.getData().getId(), "Confirm order: The order ids are not equal");
        return confirmedOrder;
    }

    public Order postStartOrder(String orderId, OrderStart data) {
        Order startOrder = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV1.ORDERS_TO.getApi() + orderId + ApiV1.ORDER_START.getApi())
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", startOrder.getResult(), "Can't start collecting the order" + orderId + ". Have a error: " + startOrder.getResult());
        Assertions.assertTrue(startOrder.getError().isEmpty(), "Error messages: " + startOrder.getError());
        Assertions.assertEquals(orderId, startOrder.getData().getId(), "Start order: The order ids are not equal");
        return startOrder;
    }

    public Order postCollectOrderProduct(String orderProductId, CollectOrderProduct data) {
        Order order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV1.ORDER_ITEMS.getApi() + orderProductId)
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", order.getResult(), "Can't confirm the order product " + orderProductId + ". Have a error: " + order.getResult());
        Assertions.assertTrue(order.getError().isEmpty(), "Error messages: " + order.getError());
        return order;
    }

    public PacksToOrder postAddPacksToOrder(String orderId, ArrayList<AddPack> data) {
        PacksToOrder order = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV2.STORE_ORDER.getApi() + orderId + ApiV2.ADD_PACKS.getApi())
                .then()
                .extract().as(PacksToOrder.class);
        Assertions.assertEquals("OK", order.getCode(), "Have a error: " + order.getMessage());
        return order;
    }

    public Order postFinishOrder(String orderId, OrderConfirm data){
        Order finishOrder = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(APIV1.STAGE.getApi() + APIV1.ORDERS_TO.getApi() + orderId + APIV1.FINISH.getApi())
                .then()
                .extract().as(Order.class);
        Assertions.assertEquals("success", finishOrder.getResult(), "Can't finish the order " + orderId + ". Have a error: " + finishOrder.getResult());
        Assertions.assertTrue(finishOrder.getError().isEmpty(), "Error messages: " + finishOrder.getError());
        Assertions.assertEquals(orderId, finishOrder.getData().getId(), "Confirm order: The order ids are not equal");
        Assertions.assertEquals("assembled", finishOrder.getData().getStatus(), "The order " + orderId + " is not changed status to assembled");
        return finishOrder;
    }

    public PackLocation postAddPackLocation(String orderId, ArrayList<AddPackLocation> data) {
        PackLocation location = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV2.PACK_LOCATION_URL.getApi() + orderId + ApiV2.PACK_LOCATION.getApi())
                .then()
                .extract().as(PackLocation.class);
        Assertions.assertEquals("OK", location.getCode(), "Can't add pack location for order " + orderId + ".Have a error: " + location.getMessage());
        return location;
    }

    public PackLocation postPrintPackLocation(String orderId, PrintPackLocation data) {
        PackLocation printPackLocation = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV2.PACK_LOCATION_URL.getApi() + orderId + ApiV2.PACK_LOCATION_PRINT.getApi())
                .then()
                .extract().as(PackLocation.class);
        Assertions.assertEquals("OK", printPackLocation.getCode(), "Can't nor print pack location" + orderId + ". Have a error: " + printPackLocation.getMessage());
        return printPackLocation;
    }

    public FilteredListOfOrders postFilterOrders(FilterOrders data){
        FilteredListOfOrders filteredListOfOrders = RestAssured.given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(data))
                .post(ApiV1.STAGE.getApi() + ApiV2.STORE_ORDER.getApi())
                .then()
                .extract().as(FilteredListOfOrders.class);
        Assertions.assertEquals("OK", filteredListOfOrders.getCode(), "Can't filter orders: " + filteredListOfOrders.getMessage());
        return filteredListOfOrders;
    }
}
