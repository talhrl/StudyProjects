package coupon_project.threads;

import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dao.CouponsDAO;
import coupon_project.db_util.Factory;

/**
 * this is a daily job that erases all coupons which had their expiration date surpass the current date.
 */
public class CouponExpirationDailyJob implements Runnable {
    //todo: activate the thread at the beginning of the program, terminate at the end!!!!
    private boolean quit = false;
    private final CouponsDAO couponsDAO;

    /**
     * if run quits legally when finished, and quit is true
     * if run quits illegally, quit will stay false.
     * thread waits until woken by another util thread that keeps tabs on the time.
     */
    @Override
    public void run() {
        while (!quit) {
            try {
                for (Coupon coupon : couponsDAO.getAllCoupons())
                    if (GregorianCalendar.getInstance().getTime().before(coupon.getEndDate())) {
                        for (Customer customer :this.couponsDAO.getAllCouponCustomers(coupon.getId())){
                            this.couponsDAO.deleteCouponPurchase(customer.getId(), coupon.getId());
                        }
                        this.couponsDAO.deleteCoupon(coupon.getId());
                    }
                Thread.sleep(60 * 1000 * 60 * 24);
            } catch (Exception Exception) {
                break;
            }

        }
    }

    /**
     * calling this function will terminate the thread legally.
     */
    public void stop() {
        this.quit = true;
    }

    public CouponExpirationDailyJob(String DB) {
        this.couponsDAO = Factory.getCouponDAO(DB);

    }
}
