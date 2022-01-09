package coupon_project.dao;

import coupon_project.beans.Company;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompaniesDAO {
    public boolean isCompanyExists(String email, String password) throws SQLException, InterruptedException;

    public void addCompany(Company company) throws SQLException, InterruptedException;

    public void updateCompany(Company company) throws SQLException, InterruptedException;

    public void deleteCompany(int companyId) throws SQLException, InterruptedException;

    public ArrayList<Company> getAllCompany() throws SQLException, InterruptedException;

    public Company getOneCompany(int companyId) throws SQLException, InterruptedException;

    public int getCompanyIDbyEmail(String email) throws SQLException, InterruptedException;

}
