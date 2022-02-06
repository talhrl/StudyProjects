package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.exceptions.CompanyException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyFacade extends ClientFacade {
    private int companyID;

    public CompanyFacade() {
    }

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        if (companyActions.isCompanyExists(email, password)) {
            this.companyID = companyActions.getCompanyIDbyEmail(email);
            return true;
        }
        return false;
    }

    public void addCoupon(Coupon coupon) throws SQLException, InterruptedException, CompanyException {
        if (couponActions.isCouponExistsByNameForCompany(coupon.getTitle(), companyID)) {
            throw new CompanyException("Coupon name already exists for your company");
        }
        coupon.setCompanyID(companyID);
        couponActions.addCoupon(coupon);
    }

    public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException, CompanyException {
        if (!couponActions.isCouponExistsByNameForCompany(coupon.getTitle(), companyID)) {
            throw new CompanyException("This coupon doesn't exist");
        }
        couponActions.updateCoupon(coupon);
    }

    public void deleteCoupon(int couponID) throws SQLException, InterruptedException, CompanyException {
        if (!couponActions.isCouponExists(couponID)) {
            throw new CompanyException("This coupon doesn't exists)");
        }
        if (couponActions.getOneCoupon(couponID).getCompanyID() != companyID) {
            throw new CompanyException("This is not your coupon");
        }
        couponActions.deleteCoupon(couponID);
        purchaseActions.deleteAllPurchasesByCoupon(couponID);
    }

    public ArrayList<Coupon> getCompanyCoupons() throws SQLException, InterruptedException {
        return couponActions.getAllCompanyCoupons(this.companyID);
    }

    public ArrayList<Coupon> getCompanyCouponsByCategory(Category category) throws SQLException, InterruptedException {
        return couponActions.getCompanyCouponsByCategory(this.companyID, category);
    }

    public ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) throws SQLException, InterruptedException {
        return couponActions.getCompanyCouponsTillMaxPrice(this.companyID, maxPrice);
    }

    public Company getCompanyDetails() throws SQLException, InterruptedException {
        return companyActions.getOneCompany(this.companyID);
    }
}