package dataProviders;
import Utils.RandomGenerateMethods;
import helpers.RequestPackaging;
import lombok.Getter;
import models.requests.packaging.*;
import enums.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.DatabaseConnector.*;

@Getter
public class PackagingProvider {

    public static PackagingCreate createPack(User email, String boxName, String packName, Integer number, Double price, String weight, String upc) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)){
            String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
            String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";
            try (PreparedStatement boxStatement = connection.prepareStatement(boxQuery)) {
                boxStatement.setInt(1, 1);
                ResultSet boxResult = boxStatement.executeQuery();
                if (boxResult.next()) {
                    PackagingCreate.Box box = new PackagingCreate.Box(
                            boxResult.getString("id"),
                            number,
                            weight,
                            boxName,
                            weight,
                            weight,
                            weight);

                    try (PreparedStatement packStatement = connection.prepareStatement(packQuery)) {
                        packStatement.setInt(1, 2);
                        ResultSet packResult = packStatement.executeQuery();
                        if (packResult.next()) {
                            PackagingCreate.Pack pack = new PackagingCreate.Pack(
                                    packResult.getString("id"),
                                    packName,
                                    price,
                                    number,
                                    upc);
                            return new PackagingCreate(List.of(box), List.of(pack),
                                    Boolean.parseBoolean(User.PICKUPBYDRIVER.getUserData()),
                                    Boolean.parseBoolean(User.ADVENCEDCOLLECTINGFLOW.getUserData()));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static PackagingUpdate updatePacking(User email, String boxName, String packName, String weight, Double price, Integer number, String upc) {
        String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
        String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement boxStatement = connection.prepareStatement(boxQuery);
             PreparedStatement packStatement = connection.prepareStatement(packQuery)) {

            boxStatement.setInt(1, 1);
            ResultSet boxResult = boxStatement.executeQuery();

            if (boxResult.next()) {
                PackagingUpdate.Box boxUpdate = new PackagingUpdate.Box(
                        RequestPackaging.getPackagingBoxId(),
                        User.STORE.getUserData(),
                        boxName,
                        weight,
                        weight,
                        weight,
                        weight,
                        weight,
                        boxResult.getString("id"),
                        User.STORE.getUserData());

                packStatement.setInt(1, 2);
                ResultSet packResult = packStatement.executeQuery();

                if (packResult.next()) {
                    PackagingUpdate.Pack packUpdate = new PackagingUpdate.Pack(
                            RequestPackaging.getPackagingId(),
                            packName,
                            price,
                            number,
                            upc,
                            packResult.getString("id"),
                            User.STORE.getUserData());

                    return new PackagingUpdate(List.of(boxUpdate), List.of(packUpdate), false, false);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static PackagingDelete deletePacking(User email){
        return new PackagingDelete( false, false);
    }

    public static PackagingErrorMessages checkErrorMessages(User email) {
        String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
        String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement boxStatement = connection.prepareStatement(boxQuery);
             PreparedStatement packStatement = connection.prepareStatement(packQuery)) {

            boxStatement.setInt(1, 1);
            ResultSet boxResult = boxStatement.executeQuery();

            if (boxResult.next()) {
                PackagingErrorMessages.Box box = new PackagingErrorMessages.Box()
                        .withFreeVolumeReserve(RandomGenerateMethods.randomIntegerOneToNine())
                        .withSpecialEntityTypeId(boxResult.getString("id"))
                        .withWeight(RandomGenerateMethods.randomIntegerOneToNine())
                        .build();

                ArrayList<PackagingErrorMessages.Box> boxesMessages = new ArrayList<>();
                boxesMessages.add(box);

                packStatement.setInt(1, 2);
                ResultSet packResult = packStatement.executeQuery();

                if (packResult.next()) {
                    PackagingErrorMessages.Pack pack = new PackagingErrorMessages.Pack()
                            .withSpecialEntityTypeId(packResult.getString("id"))
                            .build();

                    ArrayList<PackagingErrorMessages.Pack> packsMessages = new ArrayList<>();
                    packsMessages.add(pack);

                    return new PackagingErrorMessages(boxesMessages, packsMessages,
                            Boolean.parseBoolean(User.PICKUPBYDRIVER.getUserData()),
                            Boolean.parseBoolean(User.ADVENCEDCOLLECTINGFLOW.getUserData()));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static PackagingErrorMessagesForInvalidCredential checkErrorMessagesForInvalidCredential(User email) {
        String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
        String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement boxStatement = connection.prepareStatement(boxQuery);
             PreparedStatement packStatement = connection.prepareStatement(packQuery)) {

            boxStatement.setInt(1, 1);
            ResultSet boxResult = boxStatement.executeQuery();

            if (boxResult.next()) {
                PackagingErrorMessagesForInvalidCredential.Box box = new PackagingErrorMessagesForInvalidCredential.Box()
                        .withLength(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withWidth(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withHeight(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withWeight(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withFreeVolumeReserve(RandomGenerateMethods.randomMinusIntegerOneToNine())
                        .withSpecialEntityTypeId(boxResult.getString("id"))
                        .build();

                ArrayList<PackagingErrorMessagesForInvalidCredential.Box> boxesMessages = new ArrayList<>();
                boxesMessages.add(box);

                packStatement.setInt(1, 2);
                ResultSet packResult = packStatement.executeQuery();

                if (packResult.next()) {
                    PackagingErrorMessagesForInvalidCredential.Pack pack = new PackagingErrorMessagesForInvalidCredential.Pack()
                            .withFreeCount(RandomGenerateMethods.randomMinusIntegerOneToNine())
                            .withPrice("-5")
                            .withSpecialEntityTypeId(packResult.getString("id"))
                            .build();

                    ArrayList<PackagingErrorMessagesForInvalidCredential.Pack> packsMessages = new ArrayList<>();
                    packsMessages.add(pack);

                    return new PackagingErrorMessagesForInvalidCredential(boxesMessages, packsMessages, 3, 4);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
