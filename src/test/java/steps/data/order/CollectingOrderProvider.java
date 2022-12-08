package steps.data.order;

import requests.CollectOrderProduct;
import requests.OrderConfirm;
import requests.OrderStart;
import storage.CollectingOrderValues;
import storage.USER;

public class CollectingOrderProvider {
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
}
