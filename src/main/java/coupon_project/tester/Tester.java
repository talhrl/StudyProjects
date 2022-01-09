package coupon_project.tester;

import coupon_project.exceptions.LoginException;
import coupon_project.facade.AdminFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;

import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) {
        //admin
        try {
            AdminFacade admin = (AdminFacade) LoginManager.getInstance()
                    .login("admin@admin.com","admin", ClientType.ADMINISTRATOR);
            System.out.println("User logged successfully");
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
