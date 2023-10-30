package apiTests;

import helpers.RequestDiscount;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.requests.discount.DiscountInfo;
import models.responses.discount.Discount;
import dataProviders.UserInfoProvider;
import enums.ApiV1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DiscountTest {
    RequestDiscount requestDiscount = new RequestDiscount();
    @Test
    @Description("Check success partner discount list")
    public void CheckDiscountListTest() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        Discount discount = requestDiscount.requestDiscountList(ApiV1.DISCOUNT_LIST.getApi());
        Assertions.assertEquals("success", discount.getResult());
        Assertions.assertEquals("", discount.getError());
        Assertions.assertEquals(200, discount.getCode());

        ArrayList<DiscountInfo> discountInfos = discount.getData();

        for (DiscountInfo data : discountInfos) {
            if ((data.startDate != null) || (data.endDate != null)) {
                String dateStart = data.startDate;
                String dateEnd = data.startDate;
                try {
                    Date dateFormatStart = format.parse(dateStart);
                    Date dateFormatEnd = format.parse(dateEnd);
                    Assertions.assertTrue(true, "Date is not in the correct format");
                } catch (ParseException e) {
                    Assertions.fail( "Date is not in the correct format");
                }
            }
            Assertions.assertTrue(UserInfoProvider.isNumber(data.id), "id contains char");
            Assertions.assertNotNull(data.title, "title is null");
            Assertions.assertNotNull(data.type, "type is empty");
            Assertions.assertNotNull(data.description, "description is empty");
        }
    }
}
