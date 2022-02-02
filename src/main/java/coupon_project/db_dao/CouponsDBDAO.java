package coupon_project.db_dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dao.CouponsDAO;
import coupon_project.db_util.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class CouponsDBDAO implements CouponsDAO {

    @Override
    public void addCoupon(Coupon coupon) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getAmount());
        params.put(2, coupon.getCategory());
        params.put(3, coupon.getCompanyID());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate());
        params.put(6, coupon.getEndDate());
        params.put(7, coupon.getTitle());
        params.put(8, coupon.getImage());
        params.put(9, coupon.getPrice());
        params.put(10, coupon.getId());
        String ADD_COUPON = "INSERT " +
                "INTO coupon_project.coupons " +
                "(`amount`,`category`,`company_id`, `description`, `start_date`, `end_date`, `title`, `image`, `price`,`id`) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        DatabaseUtils.runQueryForResult(ADD_COUPON, params);
    }


    @Override
    public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCategory());
        params.put(2, coupon.getTitle());
        params.put(3, coupon.getDescription());
        params.put(4, coupon.getStartDate());
        params.put(5, coupon.getEndDate());
        params.put(6, coupon.getAmount());
        params.put(7, coupon.getPrice());
        params.put(8, coupon.getImage());
        params.put(9, coupon.getId());
        String UPDATE_COUPON = "UPDATE " +
                "coupon_project.coupons " +
                "SET category_id=?, title=?, description=?, start_date=?, end_date=?, amount=?, price=?, image=? " +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(UPDATE_COUPON, params);
    }


    @Override
    public void deleteCoupon(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String DELETE_COUPON = "DELETE " +
                "FROM coupon_project.coupons " +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(DELETE_COUPON, params);
    }


    @Override
    public ArrayList<Coupon> getAllCoupons() throws SQLException, InterruptedException {
        String GET_COUPON = "SELECT * " +
                "FROM coupon_project.coupons";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON);
        ArrayList<Coupon> couponsList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = new Coupon();
            coupon.setAmount(resultSet.getInt("amount"));
            coupon.setCategory(Category.values()[resultSet.getInt("category_id")]);
            coupon.setId(resultSet.getInt("id"));
            coupon.setCompanyID(resultSet.getInt("company_id"));
            coupon.setDescription(resultSet.getString("description"));
            coupon.setEndDate(resultSet.getDate("end_date"));
            coupon.setStartDate(resultSet.getDate("start_date"));
            coupon.setImage(resultSet.getString("image"));
            coupon.setPrice(resultSet.getDouble("price"));
            coupon.setTitle(resultSet.getString("title"));
            couponsList.add(coupon);
        }
        return couponsList;
    }


    @Override
    public Coupon getOneCoupon(int couponID) throws SQLException, InterruptedException {
        Coupon coupon = new Coupon();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String GET_COUPON = "SELECT (*) " +
                "FROM coupon_project.coupons " +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        coupon.setAmount(resultSet.getInt("amount"));
        coupon.setCategory((Category.values()[resultSet.getInt("category_id")]));
        coupon.setId(resultSet.getInt("id"));
        coupon.setCompanyID(resultSet.getInt("company_id"));
        coupon.setDescription(resultSet.getString("description"));
        coupon.setEndDate(resultSet.getDate("end_date"));
        coupon.setStartDate(resultSet.getDate("start_date"));
        coupon.setImage(resultSet.getString("image"));
        coupon.setPrice(resultSet.getDouble("price"));
        coupon.setTitle(resultSet.getString("title"));
        return coupon;
    }


    @Override
    public boolean isCouponLeft(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String GET_COUPON = "SELECT amount " +
                "FROM coupon_project.coupons " +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        return resultSet.getInt("amount") > 0;
    }

    @Override
    public boolean isCouponExists(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String IS_COUPON_EXISTS = "SELECT COUNT(*) AS total " +
                "FROM coupon_project.coupons " +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(IS_COUPON_EXISTS, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public ArrayList<Coupon> getAllCompanyCoupons(int companyID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        String GET_COUPON = "SELECT * " +
                "FROM coupon_project.coupons " +
                "WHERE company_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        ArrayList<Coupon> couponsList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = new Coupon();
            coupon.setAmount(resultSet.getInt("amount"));
            coupon.setCategory(Category.values()[resultSet.getInt("category_id")]);
            coupon.setId(resultSet.getInt("id"));
            coupon.setCompanyID(resultSet.getInt("company_id"));
            coupon.setDescription(resultSet.getString("description"));
            coupon.setEndDate(resultSet.getDate("end_date"));
            coupon.setStartDate(resultSet.getDate("start_date"));
            coupon.setImage(resultSet.getString("image"));
            coupon.setPrice(resultSet.getDouble("price"));
            coupon.setTitle(resultSet.getString("title"));
            couponsList.add(coupon);
        }
        return couponsList;
    }


    @Override
    public ArrayList<Coupon> getCompanyCouponsByCategory(int companyID, Category category) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        params.put(2, category.ordinal());
        String GET_COUPON_CATEGORY = "SELECT * " +
                "FROM coupon_project.coupons " +
                "WHERE company_id=? AND category=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON_CATEGORY, params);
        ArrayList<Coupon> couponsList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = new Coupon();
            coupon.setAmount(resultSet.getInt("amount"));
            coupon.setCategory(Category.values()[resultSet.getInt("category_id")]);
            coupon.setId(resultSet.getInt("id"));
            coupon.setCompanyID(resultSet.getInt("company_id"));
            coupon.setDescription(resultSet.getString("description"));
            coupon.setEndDate(resultSet.getDate("end_date"));
            coupon.setStartDate(resultSet.getDate("start_date"));
            coupon.setImage(resultSet.getString("image"));
            coupon.setPrice(resultSet.getDouble("price"));
            coupon.setTitle(resultSet.getString("title"));
            couponsList.add(coupon);
        }
        return couponsList;
    }


    @Override
    public ArrayList<Coupon> getCompanyCouponsTillMaxPrice(int companyID, double maxPrice) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        params.put(2, maxPrice);
        String GET_COUPON_TILL_PRICE = "SELECT * " +
                "FROM coupon_project.coupons " +
                "WHERE company_id=? AND price<=? ";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON_TILL_PRICE, params);
        ArrayList<Coupon> couponList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = new Coupon();
            coupon.setAmount(resultSet.getInt("amount"));
            coupon.setCategory(Category.values()[resultSet.getInt("category_id")]);
            coupon.setId(resultSet.getInt("id"));
            coupon.setCompanyID(resultSet.getInt("company_id"));
            coupon.setDescription(resultSet.getString("description"));
            coupon.setEndDate(resultSet.getDate("end_date"));
            coupon.setStartDate(resultSet.getDate("start_date"));
            coupon.setImage(resultSet.getString("image"));
            coupon.setPrice(resultSet.getDouble("price"));
            coupon.setTitle(resultSet.getString("title"));
            couponList.add(coupon);
        }
        return couponList;
    }

    @Override
    public void decreaseCouponAmount(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String REDUCE_COUPON_AMOUNT = "UPDATE " +
                "coupon_project.coupons " +
                "SET amount = amount-1 " +
                "WHERE id=?";
        DatabaseUtils.runQuery(REDUCE_COUPON_AMOUNT, params);
    }


    @Override
    public void deleteCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        String DELETE_COUPON_FOR_CUSTOMER = "DELETE " +
                "FROM coupon_project.coupons " +
                "WHERE customer_id=? AND coupon_id=?";
        DatabaseUtils.runQueryForResult(DELETE_COUPON_FOR_CUSTOMER, params);
    }

    @Override
    public ArrayList<Customer> getAllCouponCustomers(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String GET_CUSTOMER = "SELECT customer_id " +
                "FROM coupon_project.coupons " +
                "WHERE coupon_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_CUSTOMER, params);
        ArrayList<Customer> customerList = new ArrayList<>();
        CustomersDBDAO customersDBDAO = new CustomersDBDAO();
        while (resultSet.next()) {
            Customer customer = customersDBDAO.getOneCustomer(resultSet.getInt("customer_id"));
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public boolean isCouponValid(int couponID) throws SQLException, InterruptedException {
        Coupon coupon = getOneCoupon(couponID);
        return coupon.getEndDate().after(GregorianCalendar.getInstance().getTime());
    }

    @Override
    public void deleteAllCompanyCoupons(int companyID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        String DELETE_COUPON_BY_COMPANY = "DELETE " +
                "FROM coupon_project.coupons " +
                "WHERE company_id=?";
        DatabaseUtils.runQuery(DELETE_COUPON_BY_COMPANY, params);
    }

    @Override
    public boolean isCouponExistsByNameForCompany(String name, int companyID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        params.put(2, name);
        String CHECK_FOR_COUPON_BY_NAME = "SELECT COUNT(*) as total " +
                "FROM coupon_project.coupons " +
                "WHERE company_id=? AND title=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_FOR_COUPON_BY_NAME, params);
        return resultSet.getInt("total") > 0;
    }
}
