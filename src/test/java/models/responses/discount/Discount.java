package models.responses.discount;

import lombok.Getter;
import models.requests.discount.DiscountInfo;

import java.util.ArrayList;

@Getter
public class Discount {
    private Integer code;
    private String result;
    private String error;
    private ArrayList<DiscountInfo> data;
}
