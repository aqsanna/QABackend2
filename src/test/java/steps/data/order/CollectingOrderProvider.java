package steps.data.order;

import requests.order.*;
import storage.CollectingOrderValues;
import storage.User;

import java.util.ArrayList;

public class CollectingOrderProvider {
    public static OrderConfirm orderConfirm(User email) {


        return switch (email) {
            case EMAIL_INFO -> new OrderConfirm(
                    new OrderConfirm.Params(CollectingOrderValues.PREPARATION_TIME.getCollectingOrderValues()),
                    CollectingOrderValues.RESPONSE.getCollectingOrderValues(),
                    CollectingOrderValues.GROUP_BY.getCollectingOrderValues()
            );

            default -> null;
        };
    }

    public static OrderStart orderStart(User email) {
        return switch (email) {
            case EMAIL_INFO -> new OrderStart(
                    CollectingOrderValues.RESPONSE.getCollectingOrderValues(),
                    CollectingOrderValues.GROUP_BY.getCollectingOrderValues()
            );
            default -> null;
        };
    }

    public static CollectOrderProduct collectOrderProduct(User email) {
        return switch (email) {
            case EMAIL_INFO -> new CollectOrderProduct(
                    new CollectOrderProduct.Params(CollectingOrderValues.ASSEMBLED.getCollectingOrderValues()),
                    CollectingOrderValues.RESPONSE.getCollectingOrderValues(),
                    CollectingOrderValues.GROUP_BY.getCollectingOrderValues()
            );
            default -> null;
        };
    }

    public static FilterOrders filterOrder(User email, ArrayList<String> orderStatus, ArrayList<String> orderType){
        return switch (email){
            case EMAIL_INFO -> new FilterOrders(
                    new FilterOrders.Filter(orderStatus, orderType),
                    "basic"
            );
            default -> null;
        };
    }

    public static ChangeOrderStatus changeOrderStatus(User email, String status){
        return switch (email){
            case EMAIL_INFO -> new ChangeOrderStatus(status);
            default -> null;
        };
    }
}
