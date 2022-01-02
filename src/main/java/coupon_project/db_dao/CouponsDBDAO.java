package coupon_project.db_dao;

import coupon_project.beans.Coupon;
import coupon_project.dao.CouponsDAO;
import coupon_project.db_util.ConnectionPool;

import java.util.ArrayList;

public class CouponsDBDAO implements CouponsDAO {
    private ConnectionPool connectionPool;

    @Override
    public void addCoupon(Coupon coupon) {
// TODO: add coupon
    }

    @Override
    public void updateCoupon(Coupon coupon) {
// TODO: update coupon
    }

    @Override
    public void deleteCoupon(int couponID) {
// TODO: delete coupon
    }

    @Override
    public ArrayList<Coupon> getAllCoupons() {
        return null;// TODO: get all coupons
    }

    @Override
    public Coupon getOneCoupon(int couponID) {
        return null;// TODO: getOneCoupon
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {
// TODO: addCouponPurchase
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {
// TODO: deleteCouponPurchase
    }
}
