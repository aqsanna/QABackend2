package models.responses.giftCard;

import lombok.Getter;

import java.util.List;
@Getter
public class GiftCardErrorMsg {
    public String message;
    public String code;
    public List<Validation> validation;
    public Integer statusCode;

    @Getter
    public static class Validation{
       public String field;
       public String message;
      }
}
