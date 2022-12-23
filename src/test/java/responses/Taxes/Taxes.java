package responses.Taxes;

import lombok.Getter;
import requests.TaxesInfo;

import java.util.ArrayList;

@Getter
public class Taxes {
    private Integer code;
    private String result;
    private String error;
    private ArrayList<TaxesInfo> data;
}
