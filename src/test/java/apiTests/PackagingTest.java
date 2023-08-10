package apiTests;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import responses.packaging.PackagingErrorMsg;
import responses.packaging.PackagingForStore;
import steps.data.users.PackagingProvider;
import steps.data.users.UserInfoProvider;
import storage.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PackagingTest {
    Gson gson = new Gson();

    @Test
    @SerializedName("Check create Packing")
    public void addPackaging() {
        PackagingForStore createPacking = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.createPack(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);

        Assertions.assertEquals("Ok", createPacking.getMessage());
        Assertions.assertEquals("OK", createPacking.getCode());
        Assertions.assertTrue(createPacking.getData().pickupByDriver);
        Assertions.assertTrue(createPacking.getData().advancedCollectingFlow);


        ArrayList<PackagingForStore.Data.SpecialType> speciallist = createPacking.getData().getSpecialTypes();
        for (PackagingForStore.Data.SpecialType result : speciallist) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.type.isEmpty(), "type is empty");
            Assertions.assertFalse(result.isSpecial.isEmpty(), "is_special is empty");
            Assertions.assertFalse(result.canMix.isEmpty(), "can_mix is empty");
            Assertions.assertFalse(result.forShipping.isEmpty(), "for_shipping is empty");
            Assertions.assertFalse(result.forPack.isEmpty(), "for_pack is empty");
            Assertions.assertFalse(result.forProduct.isEmpty(), "for_product is empty");


        }
        ArrayList<PackagingForStore.Data.Box> boxList = createPacking.getData().getBoxes();
        for (PackagingForStore.Data.Box result : boxList) {
            Assertions.assertFalse(result.store_id.isEmpty(), "store_id is empty");
            Assertions.assertFalse(result.name.isEmpty(), "name is empty");
            Assertions.assertTrue(result.length>0, "length less than 0");
            Assertions.assertTrue(result.width>0, "width less than 0");
            Assertions.assertTrue(result.height>0, "height less than 0");
            Assertions.assertTrue(result.weight>0, "weight less than 0");
            Assertions.assertTrue(result.freeVolumeReserve>0, "free_volume_reserve less than 0");
            Assertions.assertFalse(result.specialEntityTypeId.isEmpty(), "special_entity_type_id is empty");
            Assertions.assertFalse(result.storeId.isEmpty(), "storeId is empty");
        }
        ArrayList<PackagingForStore.Data.Pack> packList = createPacking.getData().getPacks();
        for (PackagingForStore.Data.Pack result : packList) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.name.isEmpty(), "name is empty");
            Assertions.assertFalse(result.price.isEmpty(), "price is empty");
            Assertions.assertTrue(result.freeCount>0, "freeCount less than 0");
            Assertions.assertFalse(result.upc.isEmpty(), "upc is empty");
            Assertions.assertFalse(result.specialEntityTypeId.isEmpty(), "special_entity_type_id is empty");
            Assertions.assertFalse(result.storeId.isEmpty(), "storeId is empty");
        }
    }
    @Test
    @SerializedName("Check update Packing")
    public void updatePackaging() {
        PackagingForStore updatePacking = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.updatePacking(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);

        Assertions.assertEquals("Ok", updatePacking.getMessage());
        Assertions.assertEquals("OK", updatePacking.getCode());
        Assertions.assertFalse(updatePacking.getData().pickupByDriver);
        Assertions.assertFalse(updatePacking.getData().advancedCollectingFlow);


        ArrayList<PackagingForStore.Data.SpecialType> updateSpeciallist = updatePacking.getData().getSpecialTypes();
        for (PackagingForStore.Data.SpecialType result : updateSpeciallist) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.type.isEmpty(), "type is empty");
            Assertions.assertFalse(result.isSpecial.isEmpty(), "is_special is empty");
            Assertions.assertFalse(result.canMix.isEmpty(), "can_mix is empty");
            Assertions.assertFalse(result.forShipping.isEmpty(), "for_shipping is empty");
            Assertions.assertFalse(result.forPack.isEmpty(), "for_pack is empty");
            Assertions.assertFalse(result.forProduct.isEmpty(), "for_product is empty");


        }
        ArrayList<PackagingForStore.Data.Box> updateBoxList = updatePacking.getData().getBoxes();
        for (PackagingForStore.Data.Box result : updateBoxList) {
            Assertions.assertFalse(result.store_id.isEmpty(), "store_id is empty");
            Assertions.assertFalse(result.name.isEmpty(), "name is empty");
            Assertions.assertTrue(result.length>0, "length less than 0");
            Assertions.assertTrue(result.width>0, "width less than 0");
            Assertions.assertTrue(result.height>0, "height less than 0");
            Assertions.assertTrue(result.weight>0, "weight less than 0");
            Assertions.assertTrue(result.freeVolumeReserve>0, "free_volume_reserve less than 0");
            Assertions.assertFalse(result.specialEntityTypeId.isEmpty(), "special_entity_type_id is empty");
            Assertions.assertFalse(result.storeId.isEmpty(), "storeId is empty");
        }
        ArrayList<PackagingForStore.Data.Pack> UpdatePackList = updatePacking.getData().getPacks();
        for (PackagingForStore.Data.Pack result : UpdatePackList) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.name.isEmpty(), "name is empty");
            Assertions.assertFalse(result.price.isEmpty(), "price is empty");
            Assertions.assertTrue(result.freeCount>0, "freeCount less than 0");
            Assertions.assertFalse(result.upc.isEmpty(), "upc is empty");
            Assertions.assertFalse(result.specialEntityTypeId.isEmpty(), "special_entity_type_id is empty");
            Assertions.assertFalse(result.storeId.isEmpty(), "storeId is empty");
        }
    }
    @Test
    @SerializedName("Check delete Packing")
    public void deletePackaging(){
        PackagingForStore deletePacking = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.deletePacking(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingForStore.class);

        Assertions.assertEquals("Ok", deletePacking.getMessage());
        Assertions.assertEquals("OK", deletePacking.getCode());
        Assertions.assertFalse(deletePacking.getData().pickupByDriver);
        Assertions.assertFalse(deletePacking.getData().advancedCollectingFlow);


        ArrayList<PackagingForStore.Data.SpecialType> deleteSpeciallist = deletePacking.getData().getSpecialTypes();
        for (PackagingForStore.Data.SpecialType result : deleteSpeciallist) {
            Assertions.assertFalse(result.id.isEmpty(), "id is empty");
            Assertions.assertFalse(result.type.isEmpty(), "type is empty");
            Assertions.assertFalse(result.isSpecial.isEmpty(), "is_special is empty");
            Assertions.assertFalse(result.canMix.isEmpty(), "can_mix is empty");
            Assertions.assertFalse(result.forShipping.isEmpty(), "for_shipping is empty");
            Assertions.assertFalse(result.forPack.isEmpty(), "for_pack is empty");
            Assertions.assertFalse(result.forProduct.isEmpty(), "for_product is empty");
        }
        ArrayList<PackagingForStore.Data.Box> deleteBoxList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deleteBoxList.isEmpty());
        ArrayList<PackagingForStore.Data.Box> deletePackList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deletePackList.isEmpty());

    }
    @Test
    @SerializedName("Check error messages Packing")
    public void errorMessagesPackaging(){
        PackagingErrorMsg errorMsg = given()
                .header(new Header("Authorization", "Bearer " + UserInfoProvider.getToken()))
                .when()
                .contentType(ContentType.JSON)
                .body((PackagingProvider.checkErrorMessages(User.EMAIL_INFO)))
                .put(ApiV1.STAGE.getApi() + ApiV2.PACKAGING.getApi())
                .then().log().all()
                .extract().as(PackagingErrorMsg.class);

         String message ="Please fix the following errors: Box Name cannot be blank., Length cannot be blank., Width cannot be blank., " +
                "Height cannot be blank., Pack name cannot be blank., Price cannot be blank., Free pack quantity cannot be blank.";
         String code ="UNPROCESSABLE_ENTITY";

        Assertions.assertEquals(message, errorMsg.getMessage());
        Assertions.assertEquals(code, errorMsg.getCode());

        List<String> expectedList = PackagingMessages.getMessages();
        List<String> actualList = new ArrayList<String>();

        for (PackagingErrorMsg.Validation data : errorMsg.getValidation()) {
            actualList.add(data.getField());
            actualList.add(data.getMessage());
        }
        Assertions.assertTrue(actualList.containsAll(expectedList), "expected list isn't correct");
        Assertions.assertEquals(actualList.size(), expectedList.size());
    }


}

