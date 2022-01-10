package coupon_project.dao;

import coupon_project.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomersDAO {
    /**
     * checks if specific customer exist in the system
     *
     * @param email- customer email
     * @param password - customer password
     * @return if company exists
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCustomerExists(String email, String password) throws SQLException, InterruptedException;

    /**
     * add new customer to the system
     *
     * @param customer data
     * @throws SQLException
     * @throws InterruptedException
     */
    void addCustomer(Customer customer) throws SQLException, InterruptedException;

    /**
     * a method update customer existing data
     *
     * @param customer data
     * @throws SQLException
     * @throws InterruptedException
     */
    void updateCustomer(Customer customer) throws SQLException, InterruptedException;

    /**
     * a method delete customer from the system by id
     *
     * @param customerID
     * @throws SQLException
     * @throws InterruptedException
     */
    void deleteCustomer(int customerID) throws SQLException, InterruptedException;

    /**
     * a methode that shows all customer in the system
     *
     * @return list of all customers
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Customer> getAllCustomers() throws SQLException, InterruptedException;

    /**
     * a method shows specific customer data by id
     *
     * @param customerID
     * @return customer data
     * @throws SQLException
     * @throws InterruptedException
     */
    Customer getOneCustomer(int customerID) throws SQLException, InterruptedException;

    /**
     * a method that checks if customer have coupon
     *
     * @param customerID
     * @param couponID
     * @return if customer have specific coupon
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCustomerHaveCoupon(int customerID, int couponID) throws SQLException, InterruptedException;

    /**
     *  a method that get customer id by customer email
     *
     * @param email
     * @return customer id
     * @throws SQLException
     * @throws InterruptedException
     */
    int getCustomerIDbyEmail(String email) throws SQLException, InterruptedException;

    /**
     * a method that checks if customer exist in the system by customer email
     *
     * @param email
     * @return if customer exist in the system
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCustomerExistsByEmail(String email) throws SQLException, InterruptedException;
}
