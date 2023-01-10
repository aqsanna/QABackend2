package responses;

import lombok.Getter;
import requests.DiscountInfo;

import java.util.ArrayList;

@Getter
public class Discount {
    private Integer code;
    private String result;
    private String error;
    private ArrayList<DiscountInfo> data;
}
