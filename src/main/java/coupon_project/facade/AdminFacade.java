package coupon_project.facade;

import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.exceptions.AdministrationException;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminFacade extends ClientFacade {

    private static final String ADMIN_USERNAME = "admin@admin.com";

    private static final String ADMIN_PASSWORD = "admin";

    public AdminFacade() {
    }

    /**
     * checks if the login credentials are correct.
     *
     * @param email    Admins email.
     * @param password admins password.
     * @return whether credentials are correct.
     */
    public boolean login(String email, String password) {
        return email.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    /**
     * adds new company to the database.
     *
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
     *
     * @param company Company object.
     * @throws SQLException         when sql raises SQLException.
     * @throws InterruptedException when sql raises InterruptedException.
     */
    public void updateCompany(Company company) throws SQLException, InterruptedException, AdministrationException {
        if (!companyActions.isCompanyExistsByName(company.getName())) {
            throw new AdministrationException("Company doesn't exists");
        }
        companyActions.updateCompany(company);
    }

    public void deleteCompany(int companyID) throws SQLException, InterruptedException, AdministrationException {
        if (!companyActions.isCompanyExistsByID(companyID)) {
            throw new AdministrationException("Company doesn't exists");
        }
        ArrayList<Coupon> couponArrayList = couponActions.getAllCompanyCoupons(companyID);
        for (Coupon coupon : couponArrayList) {
            purchaseActions.deleteAllPurchasesByCoupon(coupon.getId());
        }
        couponActions.deleteAllCompanyCoupons(companyID);
        companyActions.deleteCompany(companyID);
    }

    public ArrayList<Company> getAllCompanies() throws SQLException, InterruptedException {
        return companyActions.getAllCompany();
    }

    public Company getOneCompany(int companyID) throws SQLException, InterruptedException, AdministrationException {
        if (!companyActions.isCompanyExistsByID(companyID)) {
            throw new AdministrationException("Company doesn't exists");
        }
        return companyActions.getOneCompany(companyID);
    }

    public void addCustomer(Customer customer) throws SQLException, InterruptedException, AdministrationException {
        if (customerActions.isCustomerExistsByEmail(customer.getEmail())) {
            throw new AdministrationException("Customer email already exists");
        }
        customerActions.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) throws SQLException, InterruptedException, AdministrationException {
        if (!customerActions.isCustomerExistsByEmail(customer.getEmail())) {
            throw new AdministrationException("This customer doesn't exists");
        }
        customerActions.updateCustomer(customer);
    }

    public void deleteCustomer(int customerID) throws SQLException, InterruptedException, AdministrationException {
        if (!customerActions.isCustomerExistsByID(customerID)) {
            throw new AdministrationException("This customer doesn't exists");
        }
        customerActions.deleteCustomer(customerID);
        ArrayList<Coupon> coupons = purchaseActions.getAllCustomerCoupons(customerID);
        for (Coupon coupon : coupons) {
            couponActions.increaseCouponAmount(coupon.getId());
        }
        purchaseActions.deleteAllPurchasesByCustomer(customerID);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException, InterruptedException {
        return customerActions.getAllCustomers();
    }

    public Customer getOneCustomer(int customerID) throws SQLException, InterruptedException, AdministrationException {
        if (!customerActions.isCustomerExistsByID(customerID)) {
            throw new AdministrationException("This customer doesn't exists");
        }
        return customerActions.getOneCustomer(customerID);
    }
}
