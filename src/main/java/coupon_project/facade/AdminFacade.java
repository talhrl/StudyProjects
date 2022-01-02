package coupon_project.facade;

import coupon_project.beans.Company;
import coupon_project.beans.Customer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class AdminFacade extends ClientFacade {

    public AdminFacade() {
        //todo : finish constructor of adminFacade
    }

    public boolean login(String email, String password) {
        //todo : finish login of adminFacade
        return false;
    }

    public void addCompany(Company company){
        //todo : finish addCompany of adminFacade
    }

    public void updateCompany(Company company){
        //todo : finish updateCompany of adminFacade
    }

    public void deleteCompany(int CompanyID) {
        //todo : finish deleteCompany of adminFacade
    }

    public ArrayList<Company> getAllCompanies() {
        //todo : finish getAllCompanies of adminFacade
        return new ArrayList<>();
    }

    public Company getOneCompany(int companyID) {
        //todo : finish getOneCompany of adminFacade
        return new Company();
    }

    public void addCustomer(Customer customer) {
        //todo : finish addCustomer of adminFacade
    }

    public void updateCustomer(Customer customer) {
        //todo : finish updateCustomer of adminFacade
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
