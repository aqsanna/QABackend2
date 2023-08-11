package apiTests;
import assertions.AssertionForPackaging;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.*;
import responses.packaging.PackagingErrorMsg;
import responses.packaging.PackagingForStore;
import steps.data.users.PackagingProvider;
import steps.data.users.UserInfoProvider;
import storage.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackagingTest {
    Gson gson = new Gson();
    AssertionForPackaging assertionForPackaging = new AssertionForPackaging();

    @Test
    @Order(1)
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
        assertionForPackaging.assertSpecialTypes(createPacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(createPacking.getData().getPacks());
        assertionForPackaging.assertBoxes(createPacking.getData().getBoxes());
    }
    @Test
    @Order(2)
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
        assertionForPackaging.assertSpecialTypes(updatePacking.getData().getSpecialTypes());
        assertionForPackaging.assertPacks(updatePacking.getData().getPacks());
        assertionForPackaging.assertBoxes(updatePacking.getData().getBoxes());
    }
    @Test
    @Order(3)
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
        assertionForPackaging.assertSpecialTypes(deletePacking.getData().getSpecialTypes());
        ArrayList<PackagingForStore.Data.Box> deleteBoxList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deleteBoxList.isEmpty());
        ArrayList<PackagingForStore.Data.Box> deletePackList = deletePacking.getData().getBoxes();
        Assertions.assertTrue(deletePackList.isEmpty());
    }
}

