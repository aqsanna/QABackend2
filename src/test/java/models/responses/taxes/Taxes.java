package models.responses.taxes;

import lombok.Getter;
import models.requests.tax.TaxesInfo;

import java.util.ArrayList;

@Getter
public class Taxes {
    private Integer code;
    private String result;
    private String error;
    private ArrayList<TaxesInfo> data;
}
