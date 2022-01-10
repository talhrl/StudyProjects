package coupon_project.dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerVsCouponDAO {
    /**
     *  a method that checks if purchase exist in the system
     *
     * @param customerID
     * @param couponID
     * @return if exist
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isPurchaseExists(int customerID, int couponID) throws SQLException, InterruptedException;

    /**
     * a method that add new purchase to the system
     *
     * @param customerID
     * @param couponID
     * @throws SQLException
     * @throws InterruptedException
     */
    void addPurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    /**
     * a method that delete purchase from system
     *
     * @param customerID
     * @param couponID
     * @throws SQLException
     * @throws InterruptedException
     */
    void deletePurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    /**
     * a methode that delete all purchases of specific coupon from system
     *
     * @param couponID
     * @throws SQLException
     * @throws InterruptedException
     */
    void deleteAllPurchasesByCoupon(int couponID) throws SQLException, InterruptedException;

    /**
     * a methode that delete all purchases of specific customer from system
     *
     * @param customerID
     * @throws SQLException
     * @throws InterruptedException
     */
    void deleteAllPurchasesByCustomer(int customerID) throws SQLException, InterruptedException;

    /**
     * a method shows all customer purchases
     *
     * @param customerID
     * @return list of all customer purchases
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getAllCustomerCoupons(int customerID) throws SQLException, InterruptedException;

    /**
     * a method shows all customer purchases from specific category
     *
     * @param customerID
     * @param category coupon category
     * @return list of purchases from specific category
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getCustomerCouponsByCategory(int customerID, Category category) throws SQLException, InterruptedException;

    /**
     * a method shows all customer purchases till max price
     *
     * @param customerID
     * @param maxPrice
     * @return list of purchases till the max price
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getCustomerCouponsTillMaxPrice(int customerID, double maxPrice) throws SQLException, InterruptedException;
}
