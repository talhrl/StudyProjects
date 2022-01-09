package coupon_project.dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.db_dao.CouponsDBDAO;

import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CouponsDAO {

    void addCoupon(Coupon coupon) throws SQLException, InterruptedException;

    void updateCoupon(Coupon coupon) throws SQLException, InterruptedException;

    void deleteCoupon(int couponID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getAllCoupons() throws SQLException, InterruptedException;

    Coupon getOneCoupon(int couponID) throws SQLException, InterruptedException;

    void addCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getAllCompanyCoupons(int companyID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCompanyCouponsByCategory(int companyID, Category category) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCompanyCouponsTillMaxPrice(int companyID, double maxPrice) throws SQLException, InterruptedException;

    ArrayList<Coupon> getAllCustomerCoupons(int customerID) throws SQLException, InterruptedException;

    ArrayList<Customer> getAllCouponCustomers(int couponID) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCustomerCouponsByCategory(int customerID, Category category) throws SQLException, InterruptedException;

    ArrayList<Coupon> getCustomerCouponsTillMaxPrice(int customerID, double maxPrice) throws SQLException, InterruptedException;

    void deleteCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException;

    boolean isCouponLeft(int couponID) throws SQLException, InterruptedException;

}
