package coupon_project.db_dao;

import coupon_project.beans.Customer;
import coupon_project.dao.CustomersDAO;
import coupon_project.db_util.ConnectionPool;

import java.util.ArrayList;

public class CustomersDBDAO implements CustomersDAO {
    private ConnectionPool connectionPool;

    @Override
    public boolean isCustomerExists(String email, String password) {


        // TODO: isCustomerExists
        return false;
    }

    @Override
    public void addCustomer(Customer customer) {
        // TODO: addCustomer
    }

    @Override
    public void updateCustomer(Customer customer) {
        // TODO: updateCustomer
    }

    @Override
    public void deleteCustomer(int customerID) {
        // TODO: deleteCustomer
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        // TODO: getAllCustomers
        return null;
    }

    @Override
    public Customer getOneCustomer(int customerID) {
        // TODO: getOneCustomer
        return null;
    }
}
