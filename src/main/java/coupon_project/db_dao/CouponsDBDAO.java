package coupon_project.db_dao;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dao.CouponsDAO;
import coupon_project.db_util.ConnectionPool;
import coupon_project.db_util.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CouponsDBDAO implements CouponsDAO {
    private ConnectionPool connectionPool;

    /**
     * A method that adds a new coupon to the system
     * @param coupon coupon data
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public void addCoupon(Coupon coupon) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getId());
        params.put(2, coupon.getAmount());
        params.put(3, coupon.getCategory());
        params.put(4, coupon.getCompanyID());
        params.put(5, coupon.getDescription());
        params.put(6, coupon.getStartDate());
        params.put(7, coupon.getEndDate());
        params.put(8, coupon.getTitle());
        params.put(9, coupon.getImage());
        params.put(10, coupon.getPrice());
        String ADD_COUPON = "INSERT INTO `coupon_project`.`coupons` " +
                "(`id`,`amount`,`category`,`company_id`, `description`, `start_date`, `end_date`, `title`, `image`, `price`)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        DatabaseUtils.runQueryForResult(ADD_COUPON, params);
    }

    /**
     * A method that updates existing coupon data
     * @param coupon coupon data
     * @throws SQLException
     * @throws InterruptedException
     */
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
        String UPDATE_COUPON = "UPDATE `coupon_project`.`coupons` " +
                "SET category_id=?, title=?, description=?, start_date=?, end_date=?, amount=?, price=?, image=?" +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(UPDATE_COUPON, params);
    }

    /**
     * Method that deletes a coupon by ID number
     * @param couponID id number
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public void deleteCoupon(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String DELETE_COUPON = "DELETE" +
                "FROM `coupon_project`.`coupons`" +
                "WHERE id=?";
        DatabaseUtils.runQueryForResult(DELETE_COUPON, params);
    }

    /**
     * A method that returns the list of all coupons in the system
     * @return list of all coupons in the system
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public ArrayList<Coupon> getAllCoupons() throws SQLException, InterruptedException {
        String GET_COUPON = "SELECT *" +
                "FROM `coupon.project`.`coupons`";
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

    /**
     * Receiving data of a single coupon from the system according to the coupon ID number
     * @param couponID coupon id
     * @return coupon data
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public Coupon getOneCoupon(int couponID) throws SQLException, InterruptedException {
        Coupon coupon = new Coupon();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String GET_COUPON = "SELECT (*) FROM `coupon.project`.`coupons`" +
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

    /**
     * A method that checks whether a particular coupon remains
     * @param couponID coupon id
     * @return whether a particular coupon remains
     * @throws SQLException
     * @throws InterruptedException
     */
    @Override
    public boolean isCouponLeft(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String GET_COUPON = "SELECT amount FROM `coupon.project`.`coupons`" +
                "WHERE id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        return resultSet.getInt("amount") > 0;
    }

    @Override
    public ArrayList<Coupon> getAllCompanyCoupons(int companyID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyID);
        String GET_COUPON = "SELECT *" +
                "FROM `coupon.project`.`coupons`" +
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
        String GET_COUPON_CATEGORY = "SELECT *" +
                "FROM `coupon.project`.`coupons`" +
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
        String GET_COUPON_TILL_PRICE = "SELECT *" +
                "FROM `coupon.project`.`coupons`" +
                "WHERE company_id=? AND price<=?";
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
    public void addCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String REDUCE_COUPON_AMOUNT = "SET amount = amount-1 WHERE id=?";
        DatabaseUtils.runQueryForResult(REDUCE_COUPON_AMOUNT, params);

        Map<Integer, Object> params2 = new HashMap<>();
        params2.put(1, couponID);
        params2.put(2, customerID);
        String ADD_COUPON = "INSERT INTO 'coupon_project'.'coupon_customers' " +
                "(`coupon_id`,`customer_id`)" +
                "VALUES (?,?)";
        DatabaseUtils.runQueryForResult(ADD_COUPON, params2);
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        String DELETE_COUPON_FOR_CUSTOMER = "DELETE" +
                "FROM `coupon_project`.`coupon_customers`" +
                "WHERE customer_id=? AND coupon_id=?";
        DatabaseUtils.runQueryForResult(DELETE_COUPON_FOR_CUSTOMER, params);
    }

    @Override
    public ArrayList<Coupon> getAllCustomerCoupons(int customerID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        String GET_COUPON = "SELECT coupon_id" +
                "FROM `coupon.project`.`coupon_customers`" +
                "WHERE customer_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        ArrayList<Coupon> couponsList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = getOneCoupon(resultSet.getInt("coupon_id"));
            couponsList.add(coupon);
        }
        return couponsList;
    }

    @Override
    public ArrayList<Customer> getAllCouponCustomers(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponID);
        String GET_CUSTOMER = "SELECT customer_id" +
                "FROM `coupon.project`.`coupon_customers`" +
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
    public ArrayList<Coupon> getCustomerCouponsByCategory(int customerID, Category category) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        String GET_COUPON = "SELECT coupon_id" +
                "FROM `coupon.project`.`coupon_customers`" +
                "WHERE customer_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        ArrayList<Coupon> couponsList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = getOneCoupon(resultSet.getInt("coupon_id"));
            if (coupon.getCategory() == category) {
                couponsList.add(coupon);
            }
        }
        return couponsList;
    }

    @Override
    public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(int customerID, double maxPrice) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        String GET_COUPON = "SELECT coupon_id" +
                "FROM `coupon.project`.`coupon_customers`" +
                "WHERE customer_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(GET_COUPON, params);
        ArrayList<Coupon> couponsList = new ArrayList<>();
        while (resultSet.next()) {
            Coupon coupon = getOneCoupon(resultSet.getInt("coupon_id"));
            if (coupon.getPrice() <= maxPrice) {
                couponsList.add(coupon);
            }
        }

        return couponsList;
    }
}
