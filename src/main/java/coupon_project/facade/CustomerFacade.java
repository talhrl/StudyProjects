package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;

import java.util.ArrayList;

public class CustomerFacade extends ClientFacade {

    private int customerId;

    public CustomerFacade() {
        //todo : finish constructor of CustomerFacade
    }

    public boolean login(String email, String password) {
        //todo : finish login of CustomerFacade
        return false;
    }

    public void purchaseCoupon(Coupon coupon) {
        //todo : finish purchaseCoupon of CustomerFacade
    }

    public ArrayList<Coupon> getCustomerCoupons() {
        //todo : finish getCustomerCoupons of CustomerFacade

        return new ArrayList<>();
    }

    public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) {
        //todo : finish getCustomerCouponsByCategory of CustomerFacade

        return new ArrayList<>();
    }

    public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) {
        //todo : finish getCustomerCouponsTillMaxPrice of CustomerFacade

        return new ArrayList<>();
    }

    public Customer getCustomerDetails() {
        // todo : finish getCustomerDetails in CustomerFacade

        return new Customer();
    }


}
