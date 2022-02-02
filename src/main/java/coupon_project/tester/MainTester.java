package coupon_project.tester;

import coupon_project.db_util.DataBaseManager;

import java.sql.SQLException;

public class MainTester {
    public static void adminTest() {
        AdminTester.adminLoginFail();
        AdminTester.adminTester();
    }

    public static void companyTest() {
        CompanyTester.companyLoginFail();
        CompanyTester.companyTester();
    }

    public static void customerTest() {
        CustomerTester.customerLoginFail();
        CustomerTester.customerTester();
    }

    public static void mainTest() {
        try {
            DataBaseManager.dropCouponsProjectDB();
            DataBaseManager.createCouponsProjectDB();
            adminTest();
            companyTest();
            customerTest();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}