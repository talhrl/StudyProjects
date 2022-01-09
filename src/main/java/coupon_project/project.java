package coupon_project;

import coupon_project.db_util.DataBaseManager;

import java.sql.SQLException;

public class project {
    public static void main(String[] args) throws SQLException, InterruptedException {
        DataBaseManager.createCouponsProjectDB();
    }
}
