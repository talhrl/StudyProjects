package coupon_project.threads;

import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomerVsCouponDAO;
import coupon_project.db_util.Factory;

import java.sql.SQLException;

/**
 * this is a daily job that erases all coupons which had their expiration date surpass the current date.
 */
public class CouponExpirationDailyJob implements Runnable {
    //todo: activate the thread at the beginning of the program, terminate at the end!!!!
    private boolean quit = false;
    private final CouponsDAO couponsDAO;
    private final CustomerVsCouponDAO customerVsCouponDAO;

    /**
     * if run quits legally when finished, and quit is true
     * if run quits illegally, quit will stay false.
     * thread waits until woken by another util thread that keeps tabs on the time.
     */
    @Override
    public void run() {
        while (!quit) {
            try {
                for (Coupon coupon : couponsDAO.getAllCoupons()) {
                    if (!couponsDAO.isCouponValid(coupon.getId())) {
                        customerVsCouponDAO.deleteAllPurchasesByCoupon(coupon.getId());
                        this.couponsDAO.deleteCoupon(coupon.getId());
                    }
                }
                //             milliseconds, seconds, minutes, hours
                Thread.sleep(1000      *  60  *    60  *  24);
            } catch (InterruptedException | SQLException e) {
                stop();
            }
        }
    }

    /**
     * calling this function will terminate the thread legally.
     */
    public void stop() {
        this.quit = true;
    }

    /**
     * constructor.
     *
     * @param DB name of the database you intend to work with.
     */
    public CouponExpirationDailyJob(String DB) {
        this.couponsDAO = Factory.getCouponDAO(DB);
        this.customerVsCouponDAO = Factory.getCustomerVsCouponDAO(DB);
    }
}
