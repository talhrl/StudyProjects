package coupon_project.db_util;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Map;

public class DatabaseUtils {
    static int id = 0;
    // Creating a private instance of connection
    private static Connection connection;

    /**
     * Function for run a command on mySQL
     *
     * @param query Command (mySQL language)
     * @throws InterruptedException
     */
    public static void runQuery(String query) throws InterruptedException, SQLException {
        int temp_id = id++;
        System.out.println(""+temp_id+":"+query);
        connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        ConnectionPool.getInstance().restoreConnection(connection);
        System.out.println("query number " +temp_id+" done");
    }

    /**
     * Function for run a command on mySQL with parameters to replace "?"
     *
     * @param query  Command (mySQL language)
     * @param params Parameters to replace "?"
     * @throws InterruptedException if thread is interrupted.
     */
    public static void runQuery(String query, Map<Integer, Object> params) throws InterruptedException {
        int temp_id = id++;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
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
            System.out.println(""+temp_id+":"+statement);
            statement.execute();
        } catch (SQLException err) {
            System.out.println(temp_id+err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
            System.out.println("query number " +temp_id+" done");
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
        int temp_id = id++;
        System.out.println(""+temp_id+":"+query);
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException err) {
            System.out.println(temp_id+err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
        System.out.println("query number " +temp_id+" done");
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
        id++;

        ResultSet resultset = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
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
            System.out.println(""+id+":"+statement);
            resultset =  statement.executeQuery();
        } catch (SQLException err) {
            System.out.println(temp_id+err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
        System.out.println("query number " +temp_id+" done");
        return resultset;
    }
}
