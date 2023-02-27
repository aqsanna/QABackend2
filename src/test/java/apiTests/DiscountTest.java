package apiTests;

import io.restassured.http.Header;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requests.DiscountInfo;
import responses.Discount;
import steps.data.users.UserInfoProvider;
import storage.ApiV1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class DiscountTest {
    @Test
    @Description("Check success partner discount list")
    public void CheckDiscountListTest() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        Discount discount = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .get(ApiV1.STAGE.getApi() + ApiV1.DISCOUNT_LIST.getApi())
                .then()
                .extract().as(Discount.class);

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
