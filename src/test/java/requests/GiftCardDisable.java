package requests;

import lombok.With;

@With
public class GiftCardDisable {
    public String status;

    public GiftCardDisable(String status){
        this.status=status;
    }
}
