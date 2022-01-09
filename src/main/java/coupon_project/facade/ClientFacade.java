package coupon_project.facade;

import coupon_project.dao.CompaniesDAO;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomersDAO;

import java.sql.SQLException;

public abstract class ClientFacade {
    protected CompaniesDAO companiesDAO;
    protected CustomersDAO customersDAO;
    protected CouponsDAO couponsDAO;

    public abstract boolean login(String userName, String password) throws SQLException, InterruptedException;
}
