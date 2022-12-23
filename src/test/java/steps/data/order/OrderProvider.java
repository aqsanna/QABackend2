package steps.data.order;

import requests.order.*;
import storage.CollectingOrderValues;
import storage.USER;

import java.util.ArrayList;

public class OrderProvider {
    public static OrderConfirm orderConfirm(USER email) {
        return switch (email) {
            case EMAIL_INFO -> new OrderConfirm(
                    new OrderConfirm.Params(CollectingOrderValues.PREPARATION_TIME.getCollectingOrderValues()),
                    CollectingOrderValues.RESPONSE.getCollectingOrderValues(),
                    CollectingOrderValues.GROUP_BY.getCollectingOrderValues()
            );

            default -> null;
        };
    }

    public static OrderStart orderStart(USER email){
        return switch (email){
            case EMAIL_INFO -> new OrderStart(
                    CollectingOrderValues.RESPONSE.getCollectingOrderValues(),
                    CollectingOrderValues.GROUP_BY.getCollectingOrderValues()
            );
            default -> null;
        };
    }

    public static CollectOrderProduct collectOrderProduct(USER email){
        return switch (email){
            case EMAIL_INFO -> new CollectOrderProduct(
                    new CollectOrderProduct.Params(CollectingOrderValues.ASSEMBLED.getCollectingOrderValues()),
                    CollectingOrderValues.RESPONSE.getCollectingOrderValues(),
                    CollectingOrderValues.GROUP_BY.getCollectingOrderValues()
            );
            default -> null;
        };
    }

    public static FilterOrders filterOrder(USER email, ArrayList<String> orderStatus, ArrayList<String> orderType){
        return switch (email){
            case EMAIL_INFO -> new FilterOrders(
                    new FilterOrders.Filter(orderStatus, orderType),
                    "basic"
            );
            default -> null;
        };
    }

    public static ChangeOrderStatus changeOrderStatus(USER email, String status){
        return switch (email){
            case EMAIL_INFO -> new ChangeOrderStatus(status);
            default -> null;
        };
    }
}
