package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static final String JDBC_URL = "jdbc:mariadb://127.0.0.1:8806/dev_main";
    public static final String JDBC_STAGE_URL ="jdbc:mariadb://127.0.0.1:8807/local_express";
    public static final String JDBC_USER = "oqsannas";
    public static final String JDBC_PASSWORD = "oqsannas123";
    DatabaseConnector connection;

    {
        try {
            connection = (DatabaseConnector) DriverManager.getConnection(
                    "jdbc:mariadb://dev-localexpress.cywnebjlcxih.us-east-2.rds.amazonaws.com:3306/dev_main",
                    "oqsannas", "oqsannas123"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
