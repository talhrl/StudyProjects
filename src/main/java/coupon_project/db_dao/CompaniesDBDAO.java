package coupon_project.db_dao;

import coupon_project.beans.Company;
import coupon_project.dao.CompaniesDAO;
import coupon_project.db_util.ConnectionPool;
import coupon_project.db_util.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompaniesDBDAO implements CompaniesDAO {
    private ConnectionPool connectionPool;

    @Override
    public boolean isCompanyExists(String email, String password) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        String CHECK_COMPANY = "SELECT COUNT(*) AS total" +
                "FROM `coupon_project`.`company_table`" +
                "WHERE email=? AND password=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_COMPANY, params);
        return resultSet.getInt("total") > 0;
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
    public void deleteCompany(int companyId) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        String CHECK_COMPANY = "DELETE" +
                "FROM `coupon_project`.`company_table`" +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(CHECK_COMPANY, params);
    }

    /**
     * A method that returns a list of all companies
     * @return list of all companies
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public ArrayList<Company> getAllCompany() throws SQLException, InterruptedException {
        String GET_COMPANIES = "SELECT *" +
                "FROM `coupon.project`.`company_table`";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COMPANIES);
        ArrayList<Company> companyList = new ArrayList<>();
        while (resultSet.next()) {
            Company company = new Company();
            company.setEmail(resultSet.getString("email"));
            company.setId(resultSet.getInt("id"));
            company.setName(resultSet.getString("name"));
            company.setPassword(resultSet.getString("password"));
            companyList.add(company);
        }
        return companyList;
    }

    @Override
    public Company getOneCompany(int companyId) {
        return null;// TODO: func :getOneCompany
    }

    /**
     *A method that returns the company's ID number according to email address
     * @param email company email
     * @return id number
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public int getCompanyIDbyEmail(String email) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        String GET_COMPANY = "SELECT id FROM `coupon_project`.`company_table`" +
                "WHERE email=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COMPANY, params);
        return resultSet.getInt("id");
    }
}
