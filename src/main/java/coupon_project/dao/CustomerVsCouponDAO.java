package coupon_project.dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerVsCouponDAO {
    boolean isPurchaseExists(int customerID, int couponID) throws SQLException, InterruptedException;

    void addPurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    void deletePurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    void deleteAllPurchasesByCoupon(int couponID) throws SQLException, InterruptedException;

    void deleteAllPurchasesByCustomer(int customerID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getAllCustomerCoupons(int customerID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCustomerCouponsByCategory(int customerID, Category category) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCustomerCouponsTillMaxPrice(int customerID, double maxPrice) throws SQLException, InterruptedException;
}
