package helpers;
import io.restassured.http.Header;
import models.responses.partner.orders.PartnerOrders;
public class RequestOrders extends AbstractRequest {

    public PartnerOrders requestGetOrder(String orderStatus, int limit, int offset, String url){
        return baseAuthorizedRequest()
                .header(new Header("Authorization", "Bearer " + AbstractRequest.getToken()))
                .queryParam("filter[status]", orderStatus)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .queryParam("sort", "asc")
                .get(url)
                .then()
                .extract().as(PartnerOrders.class);
    }
}
