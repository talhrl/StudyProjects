package coupon_project.dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CouponsDAO {
    /**
     * A method that adds a new coupon to the system
     *
     * @param coupon coupon data
     * @throws SQLException
     * @throws InterruptedException
     */

    void addCoupon(Coupon coupon) throws SQLException, InterruptedException;
    /**
     * A method that updates existing coupon data
     *
     * @param coupon coupon data
     * @throws SQLException
     * @throws InterruptedException
     */

    void updateCoupon(Coupon coupon) throws SQLException, InterruptedException;
    /**
     * Method that deletes a coupon by ID number
     *
     * @param couponID id number
     * @throws SQLException
     * @throws InterruptedException
     */
    void deleteCoupon(int couponID) throws SQLException, InterruptedException;
    /**
     * A method that returns the list of all coupons in the system
     *
     * @return list of all coupons in the system
     * @throws SQLException
     * @throws InterruptedException
     */
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
     * A method that shows all company coupons
     *
     * @param companyID
     * @return coupons list
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getAllCompanyCoupons(int companyID) throws SQLException, InterruptedException;
    /**
     * method that shows company coupons by specific category
     *
     * @param companyID
     * @param category  of coupon
     * @return coupons list from the chosen category
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getCompanyCouponsByCategory(int companyID, Category category) throws SQLException, InterruptedException;

    /**
     * method that shows company coupons till max price
     *
     * @param companyID
     * @param maxPrice- max price of coupons list
     * @return coupons list till max price
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Coupon> getCompanyCouponsTillMaxPrice(int companyID, double maxPrice) throws SQLException, InterruptedException;

    /**
     * shows all customer that bought this coupon
     *
     * @param couponID
     * @return list of customers how bought the coupon
     * @throws SQLException
     * @throws InterruptedException
     */
    ArrayList<Customer> getAllCouponCustomers(int couponID) throws SQLException, InterruptedException;

    void deleteCouponPurchase(int customerID, int couponID) throws SQLException, InterruptedException;
    /**
     * A method that checks whether a particular coupon remains
     *
     * @param couponID coupon id
     * @return whether a particular coupon remains
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCouponLeft(int couponID) throws SQLException, InterruptedException;
    /**
     * A method that checks whether a particular coupon still valid
     *
     * @param couponID coupon id
     * @return whether a particular coupon valid
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCouponValid(int couponID) throws SQLException, InterruptedException;

    /**
     * method that delete all company coupons
     *
     * @param companyID
     * @throws SQLException
     * @throws InterruptedException
     */
    void deleteAllCompanyCoupons(int companyID) throws SQLException, InterruptedException;

    /**
     * checks if coupon name already exist in specific company
     *
     * @param name- coupon name
     * @param companyID
     * @return if coupon by this name exist in the company
     * @throws SQLException
     * @throws InterruptedException
     */
    boolean isCouponExistsByNameForCompany(String name, int companyID) throws SQLException, InterruptedException;
}
