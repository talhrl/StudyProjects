package coupon_project.dao;

import coupon_project.beans.Company;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompaniesDAO {
    /**
     * checks if company exists by email and password
     *
     * @param email- company login email
     * @param password - company login password
     * @return true if company exist false if not
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCompanyExists(String email, String password) throws SQLException, InterruptedException;

    /**
     * Updating the company's data, only the company's email and / or password can be updated
     *
     * @param company company data
     * @throws SQLException         If the company does not exist
     * @throws InterruptedException
     */
    void addCompany(Company company) throws SQLException, InterruptedException;
    /**
     * Updating the company's data, only the company's email and / or password can be updated
     *
     * @param company company data
     * @throws SQLException         If the company does not exist
     * @throws InterruptedException
     */
    void updateCompany(Company company) throws SQLException, InterruptedException;

    /**
     * Method of delivering a company out of the system
     *
     * @param companyId The ID number of the company you want to delete
     * @throws SQLException         If there is no company with this ID number
     * @throws InterruptedException
     */
    void deleteCompany(int companyId) throws SQLException, InterruptedException;

    /**
     * shows all companies data
     *
     * @return companies data list
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Company> getAllCompany() throws SQLException, InterruptedException;

    /**
     * shows specific company data by company id
     *
     * @param companyId
     * @return company data
     * @throws SQLException
     * @throws InterruptedException
     */
    Company getOneCompany(int companyId) throws SQLException, InterruptedException;

    /**
     * shows company id by company email
     *
     * @param email- company email
     * @return company id
     * @throws SQLException
     * @throws InterruptedException
     */
    int getCompanyIDbyEmail(String email) throws SQLException, InterruptedException;

    /**
     * checks if company already exist by name
     *
     * @param name- company name
     * @return true if company exist false if not
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCompanyExistsByName(String name) throws SQLException, InterruptedException;

    /**
     *  checks if company already exist by email
     *
     * @param email company email
     * @return true if company exist false if not
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCompanyExistsByEmail(String email) throws SQLException, InterruptedException;
}
