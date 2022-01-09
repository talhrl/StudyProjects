package coupon_project.dao;

import coupon_project.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomersDAO {
    public boolean isCustomerExists(String email, String password) throws SQLException, InterruptedException;

    public void addCustomer(Customer customer) throws SQLException, InterruptedException;

    public void updateCustomer(Customer customer) throws SQLException, InterruptedException;

    public void deleteCustomer(int customerID) throws SQLException, InterruptedException;

    public ArrayList<Customer> getAllCustomers() throws SQLException, InterruptedException;

    public Customer getOneCustomer(int customerID) throws SQLException, InterruptedException;

    public boolean isCustomerHaveCoupon(int customerID, int couponID) throws SQLException, InterruptedException;

    public int getCustomerIDbyEmail(String email) throws SQLException, InterruptedException;
}
