package coupon_project;

import coupon_project.dao.CouponsDAO;
import coupon_project.db_util.DataBaseManager;
import coupon_project.tester.Test;

import java.sql.SQLException;

public class project {
    public static void main(String[] args) throws SQLException, InterruptedException {
        DataBaseManager.createCouponsProjectDB();
    }
}
