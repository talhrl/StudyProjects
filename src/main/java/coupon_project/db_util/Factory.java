package coupon_project.db_util;

import coupon_project.dao.CompaniesDAO;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomersDAO;
import coupon_project.db_dao.CompaniesDBDAO;
import coupon_project.db_dao.CouponsDBDAO;
import coupon_project.db_dao.CustomersDBDAO;

import java.lang.reflect.Type;

public class Factory {

    public static CouponsDAO getCouponDAO(String DB){
        CouponsDAO myCouponsDAO = null;
        switch (DB){
            case "sql":
                myCouponsDAO =new CouponsDBDAO();
            default:
                return myCouponsDAO;
        }
    }
    public static CompaniesDAO getCompanyDAO(String DB) {
        CompaniesDAO myCompanyDAO = null;
        switch (DB) {
            case "sql":
                myCompanyDAO = new CompaniesDBDAO();
            default:
                return myCompanyDAO;
        }
    }
    public static CustomersDAO getCustomerDAO(String DB) {
        CustomersDAO myCustomerDAO = null;
        switch (DB) {
            case "sql":
                myCustomerDAO = new CustomersDBDAO();
            default:
                return myCustomerDAO;
        }
    }
    }
