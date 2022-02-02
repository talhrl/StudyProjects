package coupon_project.db_dao;

import coupon_project.beans.Customer;
import coupon_project.dao.CustomersDAO;
import coupon_project.db_util.DatabaseUtils;
import coupon_project.db_util.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomersDBDAO implements CustomersDAO {

    @Override
    public boolean isCustomerExists(String email, String password) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        String CHECK_CUSTOMER = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.customers " +
                "WHERE email=? AND password=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_CUSTOMER, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public boolean isCustomerExistsByID(int customerID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        String IS_COUPON_EXISTS = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.customers " +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(IS_COUPON_EXISTS, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getId());
        params.put(2, customer.getEmail());
        params.put(3, customer.getPassword());
        params.put(4, customer.getFirstName());
        params.put(5, customer.getLastName());

        String ADD_CUSTOMER = "INSERT " +
                "INTO coupon_project.customers " +
                "(`id`,`email`,`password`,`first_name`, `last_name`) " +
                "VALUES (?,?,?,?,?)";
        DatabaseUtils.runQueryForResult(ADD_CUSTOMER, params);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getPassword());
        params.put(4, customer.getEmail());
        String UPDATE_CUSTOMER = "UPDATE " +
                "coupon_project.customers " +
                "SET first_name=?, last_name=?, password=? " +
                "WHERE email=?";
        DatabaseUtils.runQueryForResult(UPDATE_CUSTOMER, params);
    }

    @Override
    public void deleteCustomer(int customerID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        String DELETE_CUSTOMER = "DELETE " +
                "FROM coupon_project.customers " +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(DELETE_CUSTOMER, params);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException, InterruptedException {
        String GET_CUSTOMERS = "SELECT * " +
                "FROM coupon_project.customers";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_CUSTOMERS);
        ArrayList<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setEmail(resultSet.getString("email"));
            customer.setId(resultSet.getInt("id"));
            customer.setFirstName(resultSet.getString("first_name"));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setPassword(resultSet.getString("password"));
            customer.setCoupons(Factory.getCustomerVsCouponDAO("sql").getAllCustomerCoupons(resultSet.getInt("id")));
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer getOneCustomer(int customerID) throws SQLException, InterruptedException {
        Customer customer = new Customer();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        String GET_CUSTOMER = "SELECT (*) " +
                "FROM coupon_project.customers " +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_CUSTOMER, params);
        customer.setEmail(resultSet.getString("email"));
        customer.setId(resultSet.getInt("id"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setPassword(resultSet.getString("password"));
        customer.setCoupons(Factory.getCustomerVsCouponDAO("sql").getAllCustomerCoupons(resultSet.getInt("id")));
        return customer;
    }

    @Override
    public boolean isCustomerHaveCoupon(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        String CHECK_COUPON_FOR_CUSTOMER = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.customers " +
                "WHERE customer_id=? AND coupon_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_COUPON_FOR_CUSTOMER, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public int getCustomerIDbyEmail(String email) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        String GET_COMPANY = "SELECT id " +
                "FROM coupon_project.customers " +
                "WHERE email=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COMPANY, params);
        return resultSet.getInt("id");
    }

    @Override
    public boolean isCustomerExistsByEmail(String email) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        String CHECK_CUSTOMER = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.customers " +
                "WHERE email=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_CUSTOMER, params);
        return resultSet.getInt("total") > 0;
    }
}
