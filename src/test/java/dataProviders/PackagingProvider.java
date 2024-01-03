package dataProviders;
import Utils.RandomGenerateMethods;
import helpers.RequestPackaging;
import lombok.Getter;
import lombok.SneakyThrows;
import models.requests.packaging.*;
import enums.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.DatabaseConnector.*;

@Getter
public class PackagingProvider {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    private static PackagingCreate.Box createBox(ResultSet boxResult, String boxName, Integer number, String weight) throws SQLException {
        return new PackagingCreate.Box(
                boxResult.getString("id"),
                number,
                weight,
                boxName,
                weight,
                weight,
                weight);
    }
    private static PackagingCreate.Pack createPack(ResultSet packResult, String packName, Double price, Integer number, String upc) throws SQLException {
        return new PackagingCreate.Pack(
                packResult.getString("id"),
                packName,
                price,
                number,
                upc);
    }
    private static PackagingUpdate.Box boxUpdate(ResultSet boxResult, String boxName,  String weight) throws SQLException{
        return new PackagingUpdate.Box(
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
    }
    private static  PackagingUpdate.Pack packUpdate(ResultSet packResult, String packName, Double price, Integer number, String upc) throws SQLException {
        return new PackagingUpdate.Pack(
                  RequestPackaging.getPackagingId(),
                  packName,
                  price,
                  number,
                  upc,
                  packResult.getString("id"),
                  User.STORE.getUserData());
}

    public static PackagingCreate createPack(User email, String boxName, String packName, Integer number, Double price, String weight, String upc) {
        try(Connection connection = getConnection()){
            String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
            String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";
            try (PreparedStatement boxStatement = connection.prepareStatement(boxQuery)) {
                boxStatement.setInt(1, 1);
                ResultSet boxResult = boxStatement.executeQuery();
                if (boxResult.next()) {
                    PackagingCreate.Box box = createBox(boxResult, boxName, number, weight);

                    try (PreparedStatement packStatement = connection.prepareStatement(packQuery)) {
                        packStatement.setInt(1, 2);
                        ResultSet packResult = packStatement.executeQuery();
                        if (packResult.next()) {
                            PackagingCreate.Pack pack = createPack(packResult, packName, price, number, upc);
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
    @SneakyThrows
    public static PackagingUpdate updatePacking(User email, String boxName, String packName, String weight, Double price, Integer number, String upc) {
        try (Connection connection = getConnection()) {
            String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
            String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";

            PreparedStatement boxStatement = connection.prepareStatement(boxQuery);
            PreparedStatement packStatement = connection.prepareStatement(packQuery); {
                boxStatement.setInt(1, 1);
                ResultSet boxResult = boxStatement.executeQuery();
                if (boxResult.next()) {
                    PackagingUpdate.Box boxUpdate = boxUpdate(boxResult, boxName, weight);
                    packStatement.setInt(1, 2);
                    ResultSet packResult = packStatement.executeQuery();
                    if (packResult.next()) {
                        PackagingUpdate.Pack packUpdate = packUpdate(packResult, packName, price, number, upc);
                        return new PackagingUpdate(List.of(boxUpdate), List.of(packUpdate), false, false);
                    }
                }
            }
            return null;
        }
    }
    public static PackagingDelete deletePacking(User email){
        return new PackagingDelete( false, false);
    }

    @SneakyThrows
    public static PackagingErrorMessages checkErrorMessages(User email) {

        try (Connection connection = getConnection()) {
            String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
            String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";
            PreparedStatement boxStatement = connection.prepareStatement(boxQuery);
            PreparedStatement packStatement = connection.prepareStatement(packQuery);
            {

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

            }
            return null;
        }
    }
    @SneakyThrows
    public static PackagingErrorMessagesForInvalidCredential checkErrorMessagesForInvalidCredential(User email) {
        String boxQuery = "SELECT * FROM special_entity_type WHERE id = 1";
        String packQuery = "SELECT * FROM special_entity_type WHERE id = 2";

        try (Connection connection = getConnection()) {
            PreparedStatement boxStatement = connection.prepareStatement(boxQuery);
            PreparedStatement packStatement = connection.prepareStatement(packQuery);
            {

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

            }

            return null;
        }
    }
}
