package coupon_project.db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {

    // Getting the max number of connection
    private static final int NUM_OF_CONS = DataBaseManager.MAX_CONNECTION;
    // Initializing the instance for null at the beginning
    private static volatile ConnectionPool instance = null;
    // Initializing the connections stack at the beginning
    private final Stack<Connection> connections = new Stack<>();

    /**
     * Private constructor (SingleTon)
     *
     * @throws SQLException
     */
    private ConnectionPool() throws SQLException {
        //open all connections
        openAllConnections();
    }

    /**
     * Function for getting the connections instance
     * Creates the connections stack if it's null
     *
     * @return ConnectionPool with the connections stack
     */
    public static ConnectionPool getInstance() {
        //before locking the critical code...
        if (instance == null) {
            //create the connection pool
            synchronized (ConnectionPool.class) {
                //before creating the code.....
                if (instance == null) {
                    try {
                        instance = new ConnectionPool();
                    } catch (SQLException throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    /**
     * Function for getting one connection from the stack
     *
     * @return Connection (the top one)
     * @throws InterruptedException
     */
    public Connection getConnection() throws InterruptedException {
        synchronized (connections) {
            if (connections.isEmpty()) {
                //wait until we will get a connection back
                connections.wait();
            }
            return connections.pop();
        }
    }

    /**
     * Function for restore the connection that was taken back to the stack
     *
     * @param connection The connection that was taken
     */
    public void restoreConnection(Connection connection) {
        synchronized (connections) {
            connections.push(connection);
            //notify that we got back a connection from the user...
            connections.notify();
        }
    }

    /**
     * Function for opening the stack, creating and adding all the connections
     *
     * @throws SQLException when sql throws exception.
     */
    private void openAllConnections() throws SQLException {
        for (int index = 0; index < NUM_OF_CONS; index += 1) {
            Connection connection = DriverManager.getConnection(DataBaseManager.URL, DataBaseManager.USER_NAME, DataBaseManager.USER_PASS);
            connections.push(connection);
        }
    }

    /**
     * Function for closing the connections, prevent the connections from getting out and waiting for all of them to be back
     *
     * @throws InterruptedException
     */
    public void closeAllConnection() throws InterruptedException {
        synchronized (connections) {
            while (connections.size() < NUM_OF_CONS) {
                connections.wait();
            }
            connections.removeAllElements();
        }
    }
}