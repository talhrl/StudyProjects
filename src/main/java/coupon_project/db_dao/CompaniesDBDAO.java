package coupon_project.db_dao;

import com.mysql.cj.protocol.Resultset;
import coupon_project.beans.Company;
import coupon_project.dao.CompaniesDAO;
import coupon_project.db_util.DatabaseUtils;
import coupon_project.db_util.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompaniesDBDAO implements CompaniesDAO {


    @Override
    public boolean isCompanyExists(String email, String password) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        String CHECK_COMPANY = "SELECT COUNT(*) AS total" +
                "FROM coupon_project.companies" +
                "WHERE email=? AND password=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_COMPANY, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public boolean isCompanyExistsByID(int companyID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        String IS_COUPON_EXISTS = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.companies " +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(IS_COUPON_EXISTS, params);
        resultSet.next();
        return resultSet.getInt("total") > 0;
    }

    @Override
    public void addCompany(Company company) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getId());
        params.put(2, company.getName());
        params.put(3, company.getEmail());
        params.put(4, company.getPassword());
        String ADD_COMPANY = "INSERT" +
                "INTO coupon_project.companies " +
                "(`id`,`name`,`email`,`password`)" +
                "VALUES (?,?,?,?)";
        DatabaseUtils.runQuery(ADD_COMPANY, params);
    }

    /**
     * Updating the company's data, only the company's email and / or password can be updated
     *
     * @param company company data
     * @throws SQLException         If the company does not exist
     * @throws InterruptedException
     */
    @Override
    public void updateCompany(Company company) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getEmail());
        params.put(2, company.getPassword());
        params.put(3, company.getName());
        String UPDATE_COMPANY = "UPDATE " +
                "coupon_project.companies " +
                "SET email=?, password=? " +
                "WHERE name=?";
        DatabaseUtils.runQuery(UPDATE_COMPANY, params);
    }

    @Override
    public void deleteCompany(int companyId) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        String CHECK_COMPANY = "DELETE" +
                "FROM coupon_project.companies" +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(CHECK_COMPANY, params);
    }


    @Override
    public ArrayList<Company> getAllCompany() throws SQLException, InterruptedException {
        String GET_COMPANIES = "SELECT *" +
                "FROM coupon_project.companies";
        ResultSet resultSet = DatabaseUtils.runQueryForResult(GET_COMPANIES);
        ArrayList<Company> companyList = new ArrayList<>();
        while (resultSet.next()) {
            Company company = new Company();
            company.setEmail(resultSet.getString("email"));
            company.setId(resultSet.getInt("id"));
            company.setName(resultSet.getString("name"));
            company.setPassword(resultSet.getString("password"));
            company.setCoupons(Factory.getCouponDAO("sql").getAllCompanyCoupons(resultSet.getInt("id")));
            companyList.add(company);
        }
        return companyList;
    }


    @Override
    public Company getOneCompany(int companyId) throws SQLException, InterruptedException {
        Company company = new Company();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        String GET_COMPANY = "SELECT (*)" +
                "FROM coupon_project.companies" +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COMPANY, params);
        resultSet.next();
        company.setId(resultSet.getInt("id"));
        company.setPassword(resultSet.getString("password"));
        company.setEmail(resultSet.getString("email"));
        company.setName(resultSet.getString("name"));
        company.setCoupons(Factory.getCouponDAO("sql").getAllCompanyCoupons(resultSet.getInt("id")));
        return company;
    }


    @Override
    public int getCompanyIDbyEmail(String email) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        String GET_COMPANY = "SELECT id" +
                "FROM coupon_project.companies" +
                "WHERE email=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COMPANY, params);
        return resultSet.getInt("id");
    }

    @Override
    public boolean isCompanyExistsByName(String name) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, name);
        String CHECK_COMPANY_BY_NAME = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.companies " +
                "WHERE name=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_COMPANY_BY_NAME, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public boolean isCompanyExistsByEmail(String email) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        String CHECK_COMPANY_BY_EMAIL = "SELECT COUNT(*) AS total" +
                "FROM coupon_project.companies" +
                "WHERE email=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_COMPANY_BY_EMAIL, params);
        resultSet.next();
        return resultSet.getInt("total") > 0;
    }
}
