package coupon_project.dao;

import coupon_project.beans.Company;

import java.util.ArrayList;

public interface CompaniesDAO {
    public boolean isCompanyExists(String email, String password);

    public void addCompany(Company company);

    public void updateCompany(Company company);

    public void deleteCompany(int companyId);

    public ArrayList<Company> getAllCompany();

    public Company getOneCompany(int companyId);

}
