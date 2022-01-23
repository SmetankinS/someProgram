import java.sql.*;

public class SomeAction {

    private static final String DB_NAME = "postgres";
    private static final String DB_PASSWORD = "0000";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/some_db";

    public int getBalance(int id) {
        try {
            int balance;
            Connection connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            String SQL_BALANCE = "select balance from some_table where id = " + id;
            ResultSet result = statement.executeQuery(SQL_BALANCE);
            result.next();
            balance = result.getInt("balance");
            System.out.println(balance);
            return balance;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong");
            return -1;
        }
    }

    public int takeMoney(int id, int sum) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            if(getBalance(id) >= sum) {
                String SQL_BALANCE = "update some_table set balance = " + (getBalance(id) - sum) +
                    " where id = " + id;
                statement.execute(SQL_BALANCE);
            } else if(getBalance(id) < sum) {
                System.out.println("Not so many");
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something wrong");
            return -1;
        }
    }

    public int putMoney(int id, int sum) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            String SQL_BALANCE = "update some_table set balance = " + (getBalance(id) + sum) +
                    " where id = " + id;
            statement.execute(SQL_BALANCE);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something wrong");
            return 0;
        }
        return 1;
    }
}
