package coupon_project.facade;

import coupon_project.dao.CompaniesDAO;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomerVsCouponDAO;
import coupon_project.dao.CustomersDAO;
import coupon_project.db_util.Factory;

import java.sql.SQLException;

public abstract class ClientFacade {
    protected CompaniesDAO companyActions = Factory.getCompanyDAO("sql");
    protected CustomersDAO customerActions = Factory.getCustomerDAO("sql");
    protected CouponsDAO couponActions = Factory.getCouponDAO("sql");
    protected CustomerVsCouponDAO purchaseActions = Factory.getCustomerVsCouponDAO("sql");

    public abstract boolean login(String userName, String password) throws SQLException, InterruptedException;
}