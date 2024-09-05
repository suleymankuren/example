package utils;

import java.sql.*;

public class DatabaseUtils {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static Connection establishConnection() throws SQLException{
        String username = PropertyReader.databasePropertyValue("username");
        String password = PropertyReader.databasePropertyValue("password");

        return DriverManager.getConnection("jdbc:oracle:thin:@studentsuleyman.cnpfrjivolaz.us-east-2.rds.amazonaws.com:1521/ORCL", username, password);
    }

    public static Statement connectStatement() throws SQLException{
        return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }

    public static void closeConnection(){
        if (connection!=null || statement!=null || resultSet!=null){
            try {
                connection.close();
                statement.close();
                resultSet.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
