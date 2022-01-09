package coupon_project.facade;

import coupon_project.beans.Company;
import coupon_project.beans.Customer;
import coupon_project.dao.CompaniesDAO;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomersDAO;
import coupon_project.db_dao.CompaniesDBDAO;
import coupon_project.db_dao.CouponsDBDAO;
import coupon_project.db_dao.CustomersDBDAO;
import coupon_project.db_util.Factory;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class AdminFacade extends ClientFacade {

    private final String ADMIN_USERNAME = "admin@admin.com";

    private final String ADMIN_PASSWORD = "admin";

    private CompaniesDAO companyActions;
    private CustomersDAO customerActions;
    private CouponsDAO couponActions;

    public AdminFacade() {
        this.companyActions = Factory.getCompanyDAO("sql");
        this.customerActions = Factory.getCustomerDAO("sql");
        this.couponActions = Factory.getCouponDAO("sql");
    }

    public boolean login(String email, String password) {
        if (email.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            return true;
        }
        return false;
    }

    public void addCompany(Company company) throws SQLException, InterruptedException {
        companyActions.addCompany(company);
    }

    public void updateCompany(Company company) throws SQLException, InterruptedException {
        companyActions.updateCompany(company);
    }

    public void deleteCompany(int CompanyID) {
        //todo : finish deleteCompany of adminFacade
    }

    public ArrayList<Company> getAllCompanies() throws SQLException, InterruptedException {
        return companyActions.getAllCompany();
    }

    public Company getOneCompany(int companyID) throws SQLException, InterruptedException {
        return companyActions.getOneCompany(companyID);
    }

    public void addCustomer(Customer customer) throws SQLException, InterruptedException {
        customerActions.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) throws SQLException, InterruptedException {
        customerActions.updateCustomer(customer);
    }

    public void deleteCustomer(int customerID) {
        //todo : finish deleteCustomer of adminFacade
    }

    public ArrayList<Customer> getAllCustomers() {
        //todo : finish getAllCustomers of adminFacade
        return new ArrayList<>();
    }

    public Customer getOneCustomer(int customerID) {
        //todo : finish getOneCustomer of adminFacade
        return new Customer();
    }
}
