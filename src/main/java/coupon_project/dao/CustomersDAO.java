package coupon_project.dao;

import coupon_project.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomersDAO {
    boolean isCustomerExists(String email, String password) throws SQLException, InterruptedException;

    void addCustomer(Customer customer) throws SQLException, InterruptedException;

    void updateCustomer(Customer customer) throws SQLException, InterruptedException;

    void deleteCustomer(int customerID) throws SQLException, InterruptedException;

    ArrayList<Customer> getAllCustomers() throws SQLException, InterruptedException;

    Customer getOneCustomer(int customerID) throws SQLException, InterruptedException;

    boolean isCustomerHaveCoupon(int customerID, int couponID) throws SQLException, InterruptedException;

    int getCustomerIDbyEmail(String email) throws SQLException, InterruptedException;

    boolean isCustomerExistsByEmail(String email) throws SQLException, InterruptedException;
}
