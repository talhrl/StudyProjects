package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.db_dao.CouponsDBDAO;
import coupon_project.db_dao.CustomersDBDAO;
import coupon_project.exceptions.PurchaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFacade extends ClientFacade {
    private int customerID;
    private CustomersDBDAO customerActions;
    private CouponsDBDAO couponAction;

    public CustomerFacade() {
        this.customerActions = new CustomersDBDAO();
        this.couponAction = new CouponsDBDAO();
    }

    public boolean login(String email, String password) throws SQLException, InterruptedException {
        if (customerActions.isCustomerExists(email, password)) {
            this.customerID = customerActions.getCustomerIDbyEmail(email);
            return true;
        }
        return false;
    }

    public void purchaseCoupon(Coupon coupon) throws SQLException, InterruptedException, PurchaseException {
        if (customerActions.isCustomerHaveCoupon(customerID, coupon.getId())) {
            throw new PurchaseException("You already bought this coupon");
        }
        if (!couponAction.isCouponLeft(coupon.getId())) {
            throw new PurchaseException("This coupon is no longer available");
        }
        couponAction.addCouponPurchase(customerID, coupon.getId());
    }

    public ArrayList<Coupon> getCustomerCoupons() throws SQLException, InterruptedException {
        return couponAction.getAllCustomerCoupons(this.customerID);
    }

    public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) throws SQLException, InterruptedException {
        return couponAction.getCustomerCouponsByCategory(this.customerID, category);
    }

    public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) throws SQLException, InterruptedException {
        return couponAction.getCustomerCouponsTillMaxPrice(this.customerID, maxPrice);
    }

    public Customer getCustomerDetails() throws SQLException, InterruptedException {
        return customerActions.getOneCustomer(this.customerID);
    }


}
