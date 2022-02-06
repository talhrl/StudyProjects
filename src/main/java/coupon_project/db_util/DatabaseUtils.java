package coupon_project.db_util;

import java.sql.*;
import java.util.Map;

public class DatabaseUtils {
    // Creating a private instance of connection
    private static Connection connection;

    /**
     * Function for run a command on mySQL
     *
     * @param query Command (mySQL language)
     * @throws InterruptedException
     */
    public static void runQuery(String query) throws InterruptedException, SQLException {
        //System.out.println("attempting to prepare statement");
        connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        //System.out.println("attempting to execute statement:"+ statement);
        statement.execute();
        //System.out.println("statement executed!");
        ConnectionPool.getInstance().restoreConnection(connection);
    }

    /**
     * Function for run a command on mySQL with parameters to replace "?"
     *
     * @param query  Command (mySQL language)
     * @param params Parameters to replace "?"
     * @throws InterruptedException if thread is interrupted.
     */
    public static void runQuery(String query, Map<Integer, Object> params) throws InterruptedException {
        try {
            //System.out.println("attempting to prepare statement.");
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            //System.out.println("inserting data to sql command");
            params.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        statement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        statement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        statement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        statement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        statement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        statement.setFloat(key, (Float) value);
                    }
                } catch (SQLException err) {
                    System.out.println("");
                    System.out.println(err.getMessage());
                }
            });
            //System.out.println("attempting to execute statement"+statement);
            statement.execute();
            //System.out.println("statement executed");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }

    /**
     * Function for run a command on mySQL and return data
     *
     * @param query Command (mySQL language)
     * @return Wanted data
     * @throws InterruptedException
     */
    public static ResultSet runQueryForResult(String query) throws InterruptedException {
        ResultSet resultSet = null;
        try {
            //System.out.println("attempting to prepare statement.");
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            //System.out.println("attempting to execute statement"+statement);
            resultSet = statement.executeQuery();
            //System.out.println("statement executed!");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
        return resultSet;
    }

    /**
     * Function for run a command on mySQL with parameters to replace "?" and return data
     *
     * @param query  Command (mySQL language)
     * @param params Parameters to replace "?"
     * @return Wanted data
     * @throws InterruptedException
     */
    public static ResultSet runQueryForResult(String query, Map<Integer, Object> params) throws InterruptedException {
        ResultSet resultset = null;
        try {
            //System.out.println("attempting to prepare statement");
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            //System.out.println("inserting values to sql statement.");
            params.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        statement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        statement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        statement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        statement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        statement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        statement.setFloat(key, (Float) value);
                    }
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }

            });
            //System.out.println("attempting to execute statement"+statement);
            resultset =  statement.executeQuery();
            //System.out.println("statement executed!");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
        return resultset;
    }
}
