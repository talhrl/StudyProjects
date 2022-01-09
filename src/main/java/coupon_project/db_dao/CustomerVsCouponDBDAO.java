package coupon_project.db_dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomerVsCouponDAO;
import coupon_project.db_util.DatabaseUtils;
import coupon_project.db_util.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerVsCouponDBDAO implements CustomerVsCouponDAO {
    @Override
    public boolean isPurchaseExists(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        String CHECK_COUPON_FOR_CUSTOMER = "SELECT COUNT(*) AS total" +
                "FROM `coupon_project`.`coupon_customers`" +
                "WHERE customer_id=? AND coupon_id=?";
        ResultSet resultSet = (ResultSet) DatabaseUtils.runQueryForResult(CHECK_COUPON_FOR_CUSTOMER, params);
        return resultSet.getInt("total") > 0;
    }

    @Override
    public void addPurchase(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params2 = new HashMap<>();
        params2.put(1, couponID);
        params2.put(2, customerID);
        String ADD_PURCHASE = "INSERT" +
                "INTO 'coupon_project'.'coupon_customers' " +
                "(`coupon_id`,`customer_id`)" +
                "VALUES (?,?)";
        DatabaseUtils.runQuery(ADD_PURCHASE, params2);
    }

    @Override
    public void deletePurchase(int customerID, int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params2 = new HashMap<>();
        params2.put(1, couponID);
        params2.put(2, customerID);
        String DELETE_PURCHASE = "DELETE" +
                "FROM 'coupon_project'.'coupon_customers' " +
                "WHERE customer_id=? AND coupon_id=?";
        DatabaseUtils.runQuery(DELETE_PURCHASE, params2);
    }

    @Override
    public void deleteAllPurchasesByCoupon(int couponID) throws SQLException, InterruptedException {
        Map<Integer, Object> params2 = new HashMap<>();
        params2.put(1, couponID);
        String DELETE_PURCHASE = "DELETE" +
                "FROM 'coupon_project'.'coupon_customers' " +
                "WHERE coupon_id=?";
        DatabaseUtils.runQuery(DELETE_PURCHASE, params2);
    }

    @Override
    public void deleteAllPurchasesByCustomer(int customerID) throws SQLException, InterruptedException {
        Map<Integer, Object> params2 = new HashMap<>();
        params2.put(1, customerID);
        String DELETE_PURCHASE = "DELETE" +
                "FROM 'coupon_project'.'coupon_customers' " +
                "WHERE customer_id=?";
        DatabaseUtils.runQuery(DELETE_PURCHASE, params2);
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
            CouponsDAO couponsDAO = Factory.getCouponDAO("sql");
            Coupon coupon = couponsDAO.getOneCoupon(resultSet.getInt("coupon_id"));
            couponsList.add(coupon);
        }
        return couponsList;
    }

    @Override
    public ArrayList<Coupon> getCustomerCouponsByCategory(int customerID, Category category) throws SQLException, InterruptedException {
        ArrayList<Coupon> couponArrayList = getAllCustomerCoupons(customerID);
        couponArrayList.removeIf(coupon -> coupon.getCategory().equals(category));
        return couponArrayList;
    }

    @Override
    public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(int customerID, double maxPrice) throws SQLException, InterruptedException {
        ArrayList<Coupon> couponArrayList = getAllCustomerCoupons(customerID);
        couponArrayList.removeIf(coupon -> coupon.getPrice() > maxPrice);
        return couponArrayList;
    }
}
