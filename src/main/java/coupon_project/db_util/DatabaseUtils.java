package coupon_project.db_util;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseUtils {

    // Creating a private instance of connection
    private static Connection connection;

    /**
     * Function for run a command on mySQL
     *
     * @param query Command (mySQL language)
     * @throws SQLException
     * @throws InterruptedException
     */
    public static void runQuery(String query) throws SQLException, InterruptedException {
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }

    /**
     * Function for run a command on mySQL with parameters to replace "?"
     *
     * @param query  Command (mySQL language)
     * @param params Parameters to replace "?"
     * @throws SQLException
     * @throws InterruptedException
     */
    public static void runQuery(String query, Map<Integer, Object> params) throws SQLException, InterruptedException {
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
            statement.execute();
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
     * @throws SQLException
     * @throws InterruptedException
     */
    public static Resultset runQueryForResult(String query) throws SQLException, InterruptedException {
        Resultset resultset = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            resultset = (Resultset) statement.executeQuery();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            connection = ConnectionPool.getInstance().getConnection();
        }
        return resultset;
    }

    /**
     * Function for run a command on mySQL with parameters to replace "?" and return data
     *
     * @param query  Command (mySQL language)
     * @param params Parameters to replace "?"
     * @return Wanted data
     * @throws SQLException
     * @throws InterruptedException
     */
    public static Resultset runQueryForResult(String query, Map<Integer, Object> params) throws SQLException, InterruptedException {
        Resultset resultset = null;
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
            resultset = (Resultset) statement.executeQuery();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            connection = ConnectionPool.getInstance().getConnection();
        }
        return resultset;
    }
}
