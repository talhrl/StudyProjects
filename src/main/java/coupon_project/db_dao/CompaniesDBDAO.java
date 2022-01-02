package coupon_project.db_dao;

import coupon_project.beans.Company;
import coupon_project.dao.CompaniesDAO;
import coupon_project.db_util.ConnectionPool;

import java.util.ArrayList;

public class CompaniesDBDAO implements CompaniesDAO {
    private ConnectionPool connectionPool;

    @Override
    public boolean isCompanyExists(String email, String password) {
        return false;// TODO: func  : does company exist
    }

    @Override
    public void addCompany(Company company) {
// TODO: func : add company
    }

    @Override
    public void updateCompany(Company company) {
// TODO: func : updateCompany
    }

    @Override
    public void deleteCompany(int companyId) {
// TODO: func : deleteCompany
    }

    @Override
    public ArrayList<Company> getAllCompany() {
        return null;// TODO: func : getAllCompany
    }

    @Override
    public Company getOneCompany(int companyId) {
        return null;// TODO: func :getOneCompany
    }
}
