import Utile.Order;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import responses.partner.orders.PartnerOrders;
import responses.userLogin.SuccessLogin;
import spec.Specifications;
import steps.data.users.UserInfoProvider;
import storage.APIV2;
import storage.ORDER_STATUS;
import storage.USER;

import static io.restassured.RestAssured.given;

public class OrderListTest {
    Gson gson = new Gson();
    UserInfoProvider userInfoProvider = new UserInfoProvider();
    @Test
    @DisplayName("Check partner order list")
    public void orderListTest(){
        Specifications.installSpecification(Specifications.requestSpec(APIV2.LOGIN.getApi()), Specifications.responseOK200());

        SuccessLogin successLogin = given()
                .when()
                .contentType(ContentType.JSON)
                .body(gson.toJson(userInfoProvider.getUser(USER.EMAIL_INFO)))
                .post(APIV2.STAGE.getApi() + APIV2.REGISTER.getApi())
                .then().log().all()
                .extract().as(SuccessLogin.class);

        for (int i = 0; i < ORDER_STATUS.values().length; i++) {
            boolean emptyData = false;
            int orderCount = 20;
            int page = 0;
            while (!emptyData) {
                PartnerOrders orderList = RestAssured.given()
                        .header(new Header("Authorization", "Bearer " + successLogin.getData().getToken()))
                        .queryParam("filter[status]", ORDER_STATUS.values()[i].getOrderStatus())
                        .queryParam("limit", orderCount)
                        .queryParam("offset", page)
                        .queryParam("sort", "asc")
                        .when()
                        .get(APIV2.STAGE.getApi() + APIV2.ORDERS.getApi())
                        .then().log().all()
                        .extract().as(PartnerOrders.class);
                Assertions.assertEquals("success", orderList.getResult(), "Have a error: " + orderList.getResult());
                Assertions.assertTrue(orderList.getError().isEmpty(), "Error messages: " + orderList.getError());
                if (orderList.getData().size() > 0){
                    for (Order order:orderList.getData()) {
                        try{
                            int id = Integer.parseInt(order.getId());
                        }
                        catch (NumberFormatException ex){
                            Assertions.fail("Incorrect order_id: " + order.getId());
                        }

                        Assertions.assertEquals(ORDER_STATUS.values()[i].getOrderStatus(), order.getStatus(), "Order actual status: " + order.getStatus() + "Expected status: " + ORDER_STATUS.values()[i].getOrderStatus() );
                        Assertions.assertFalse(order.getCreationDate().isEmpty(), "The order " + order.getId() + "creation date is empty");
                        Assertions.assertFalse(order.getDropoff().getPerson().getFirstName().isEmpty(), "The order " + order.getId() + " first name is empty");
                        Assertions.assertFalse(order.getDropoff().getPerson().getPhone().isEmpty(), "The order " + order.getId() + " phone is empty");
                        Assertions.assertTrue(order.getPayment().getTotal() > 0 , "The order " + order.getId() + " total price is " + order.getPayment().getTotal());
                        for (Order.Transaction transaction: order.getTransactions()) {
                            Assertions.assertFalse(transaction.getTransactionID().isEmpty(), "The order " + order.getId() + " transactionID is empty. Type is " + transaction.getType() + " id : " + transaction.getId());
                        }
                    }
                    page += orderCount;
                }
                else {
                    emptyData = true;
                }
            }
        }
    }
}