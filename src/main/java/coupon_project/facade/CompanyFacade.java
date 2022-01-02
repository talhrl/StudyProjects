package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;

import java.util.ArrayList;

public class CompanyFacade extends ClientFacade {
    int companyID;

    @Override
    public boolean login(String userName, String password) {
        return false;
    }

    public CompanyFacade(int companyID) {
        //todo : finish constructor of companyFacade
    }

    void addCoupon(Coupon coupon) {
        //todo : finish addCoupon of companyFacade
    }

    void updateCoupon(Coupon coupon) {
        //todo : finish updateCoupon of companyFacade
    }

    void deleteCoupon(int couponID) {
        //todo : finish deleteCoupon of companyFacade
    }

    ArrayList<Coupon> getCompanyCoupons() {
        //todo : finish getCompanyCoupons of companyFacade
        return new ArrayList<>();
    }

    ArrayList<Coupon> getCompanyCouponsByCategory(Category category) {
        //todo : finish getCompanyCouponsByCategory of companyFacade
        return new ArrayList<>();
    }

    ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) {
        //todo : finish getCompanyCouponsTillMaxPrice of companyFacade
        return new ArrayList<>();
    }

    public Company getCompanyDetails(){
        // todo : finish getCompanyDetails in CompanyFacade

        return new Company();
    }
}