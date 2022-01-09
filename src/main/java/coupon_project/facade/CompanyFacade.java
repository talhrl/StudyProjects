package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.dao.CompaniesDAO;
import coupon_project.dao.CouponsDAO;
import coupon_project.db_dao.CompaniesDBDAO;
import coupon_project.db_dao.CouponsDBDAO;
import coupon_project.db_util.Factory;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyFacade extends ClientFacade {
    private int companyID;
    private CompaniesDAO companyActions;
    private CouponsDAO couponActions;

    public CompanyFacade() {
        this.companyActions = Factory.getCompanyDAO("sql");;
        this.couponActions = Factory.getCouponDAO("sql");;
    }

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        if (companyActions.isCompanyExists(email, password)) {
            this.companyID = companyActions.getCompanyIDbyEmail(email);
            return true;
        }
        return false;
    }

    void addCoupon(Coupon coupon) throws SQLException, InterruptedException {
        couponActions.addCoupon(coupon);
    }

    void updateCoupon(Coupon coupon) throws SQLException, InterruptedException {
        couponActions.updateCoupon(coupon);
    }

    void deleteCoupon(int couponID) throws SQLException, InterruptedException {
        couponActions.deleteCoupon(couponID);
    }

    ArrayList<Coupon> getCompanyCoupons() throws SQLException, InterruptedException {
        return couponActions.getAllCompanyCoupons(this.companyID);
    }

    ArrayList<Coupon> getCompanyCouponsByCategory(Category category) throws SQLException, InterruptedException {
        return couponActions.getCompanyCouponsByCategory(this.companyID, category);
    }

    ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) throws SQLException, InterruptedException {
        return couponActions.getCompanyCouponsTillMaxPrice(this.companyID, maxPrice);
    }

    public Company getCompanyDetails() throws SQLException, InterruptedException {
        return companyActions.getOneCompany(this.companyID);
    }
}