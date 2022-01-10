package coupon_project.facade;

import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.exceptions.AdministrationException;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminFacade extends ClientFacade {

    private final String ADMIN_USERNAME = "admin@admin.com";

    private final String ADMIN_PASSWORD = "admin";

    public AdminFacade() {
    }

    /**
     * checks if the login credentials are correct.
     *
     * @param email    Admin's email.
     * @param password admin's password.
     * @return whether credentials are correct.
     */
    public boolean login(String email, String password) {
        return email.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    /** adds new company to the database.
     * @param company A company object.
     * @throws SQLException            when sql raises an exception.
     * @throws InterruptedException    when thread is interrupted.
     * @throws AdministrationException when email or company name already exist.
     */
    public void addCompany(Company company) throws SQLException, InterruptedException, AdministrationException {
        if (companyActions.isCompanyExistsByName(company.getName())) {
            throw new AdministrationException("Company name already exists");
        }
        if (companyActions.isCompanyExistsByEmail(company.getEmail())) {
            throw new AdministrationException("Company email already exists");
        }
        companyActions.addCompany(company);
    }

    /**
     * updates company's data. Can only update company's email or username
     * @param company Company object.
     * @throws SQLException when sql raises SQLException.
     * @throws InterruptedException when sql raises InterruptedException.
     */
    public void updateCompany(Company company) throws SQLException, InterruptedException {
        companyActions.updateCompany(company);
    }

    public void deleteCompany(int companyID) throws SQLException, InterruptedException {
        ArrayList<Coupon> couponArrayList = couponActions.getAllCompanyCoupons(companyID);
        for (Coupon coupon : couponArrayList) {
            purchaseActions.deleteAllPurchasesByCoupon(coupon.getId());
        }
        companyActions.deleteCompany(companyID);
        couponActions.deleteAllCompanyCoupons(companyID);
    }

    public ArrayList<Company> getAllCompanies() throws SQLException, InterruptedException {
        return companyActions.getAllCompany();
    }

    public Company getOneCompany(int companyID) throws SQLException, InterruptedException {
        return companyActions.getOneCompany(companyID);
    }

    public void addCustomer(Customer customer) throws SQLException, InterruptedException, AdministrationException {
        if (customerActions.isCustomerExistsByEmail(customer.getEmail())) {
            throw new AdministrationException("Customer email already exists");
        }
        customerActions.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) throws SQLException, InterruptedException {
        customerActions.updateCustomer(customer);
    }

    public void deleteCustomer(int customerID) throws SQLException, InterruptedException {
        customerActions.deleteCustomer(customerID);
        purchaseActions.deleteAllPurchasesByCustomer(customerID);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException, InterruptedException {
        return customerActions.getAllCustomers();
    }

    public Customer getOneCustomer(int customerID) throws SQLException, InterruptedException {
        return customerActions.getOneCustomer(customerID);
    }
}
