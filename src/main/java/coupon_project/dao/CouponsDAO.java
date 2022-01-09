package coupon_project.dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CouponsDAO {

    void addCoupon(Coupon coupon) throws SQLException, InterruptedException;

    void updateCoupon(Coupon coupon) throws SQLException, InterruptedException;

    void deleteCoupon(int couponID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getAllCoupons() throws SQLException, InterruptedException;

    Coupon getOneCoupon(int couponID) throws SQLException, InterruptedException;
    /**
     * A method that returns the list of all coupons in the system
     *
     * @return list of all coupons in the system
     * @throws SQLException
     * @throws InterruptedException
     */
    void decreaseCouponAmount(int couponID) throws SQLException, InterruptedException;
    /**
     * A method that checks whether a particular coupon remains
     *
     * @param couponID coupon id
     * @return whether a particular coupon remains
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getAllCompanyCoupons(int companyID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCompanyCouponsByCategory(int companyID, Category category) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCompanyCouponsTillMaxPrice(int companyID, double maxPrice) throws SQLException, InterruptedException;

    ArrayList<Customer> getAllCouponCustomers(int couponID) throws SQLException, InterruptedException;

    void deleteCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    boolean isCouponLeft(int couponID) throws SQLException, InterruptedException;

    boolean isCouponValid(int couponID) throws SQLException, InterruptedException;

    void deleteAllCompanyCoupons(int companyID) throws SQLException, InterruptedException;

    boolean isCouponExistsByNameForCompany(String name, int companyID) throws SQLException, InterruptedException;
}
