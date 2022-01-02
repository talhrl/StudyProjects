package coupon_project.threads;

import coupon_project.dao.CouponsDAO;

public class CouponExpirationDailyJob implements Runnable {
    //todo: activate the thread at the beginning of the program, terminate at the end!!!!
    private boolean quit;
    private CouponsDAO couponsDao;
    @Override
    public void run() {
        // TODO: run()
    }
    public void stop(){
        //TODO: stop!
    }

    public CouponExpirationDailyJob(CouponsDAO couponsDao) {
        this.couponsDao = couponsDao;
    }
}
