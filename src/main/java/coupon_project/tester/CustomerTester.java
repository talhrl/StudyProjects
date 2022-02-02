package coupon_project.tester;

import coupon_project.beans.Category;
import coupon_project.exceptions.LoginException;
import coupon_project.exceptions.PurchaseException;
import coupon_project.facade.CustomerFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;

import java.sql.SQLException;

public class CustomerTester {
    public static void customerLoginFail() {
        try {
            LoginManager.getInstance().login("notTalHarel@gmail.com", "asd", ClientType.CUSTOMER);
            System.out.println("login succeeded with wrong password");
        } catch (Exception exception) {
            try {
                LoginManager.getInstance().login("aom", "tal_the_king", ClientType.CUSTOMER);
                System.out.println("login succeeded with wrong email");
            } catch (Exception exception1) {
                try {
                    LoginManager.getInstance().login("notTalHarel@gmail.com", "tal_the_king", ClientType.ADMINISTRATOR);
                    System.out.println("login succeeded with wrong clientType");
                } catch (Exception e) {
                    System.out.println("login failed successfully");
                }
            }
        }
    }

    //TODO: public boolean login(String email, String password) success
    public static void customerTester() {
        CustomerFacade customerFacade;
        //**************************************************************************************************************
        //                                           Tal Harel
        //**************************************************************************************************************
        try {
            customerFacade = (CustomerFacade) LoginManager.getInstance().login("notTalHarel@gmail.com", "tal_the_king", ClientType.CUSTOMER);
            // public void purchaseCoupon(int couponID) three coupons success
            try {
                customerFacade.purchaseCoupon(1);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(2);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(5);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            //public void purchaseCoupon(int couponID) failed by coupon doesn't exists
            try {
                customerFacade.purchaseCoupon(55);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            //public void purchaseCoupon(int couponID) failed by already bought
            try {
                customerFacade.purchaseCoupon(5);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public void purchaseCoupon(int couponID) failed by already expired
            try {
                customerFacade.purchaseCoupon(3);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public void purchaseCoupon(int couponID) failed by no left to buy
            try {
                customerFacade.purchaseCoupon(4);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCoupons() success
            try {
                customerFacade.getCustomerCoupons();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) success
            try {
                customerFacade.getCustomerCouponsByCategory(Category.Fashion);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) success
            try {
                customerFacade.getCustomerCouponsTillMaxPrice(89.0);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public Customer getCustomerDetails() success
            try {
                customerFacade.getCustomerDetails();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }


        //**************************************************************************************************************
        //                                           Shiri levi
        //**************************************************************************************************************
        try {
            customerFacade = (CustomerFacade) LoginManager.getInstance().login("notShiriLevi@gmail.com", "shiri_the_queen", ClientType.CUSTOMER);
            // public void purchaseCoupon(int couponID) three coupons success
            try {
                customerFacade.purchaseCoupon(22);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(29);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(24);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCoupons() success
            try {
                customerFacade.getCustomerCoupons();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) success
            try {
                customerFacade.getCustomerCouponsByCategory(Category.Fashion);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) success
            try {
                customerFacade.getCustomerCouponsTillMaxPrice(95.50);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public Customer getCustomerDetails() success
            try {
                customerFacade.getCustomerDetails();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }


        //**************************************************************************************************************
        //                                           Matan ozer
        //**************************************************************************************************************
        try {
            customerFacade = (CustomerFacade) LoginManager.getInstance().login("notMatanOzer@gmail.com", "matan_the_king", ClientType.CUSTOMER);
            // public void purchaseCoupon(int couponID) three coupons success
            try {
                customerFacade.purchaseCoupon(15);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(18);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(13);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCoupons() success
            try {
                customerFacade.getCustomerCoupons();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) success
            try {
                customerFacade.getCustomerCouponsByCategory(Category.Restaurant);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) success
            try {
                customerFacade.getCustomerCouponsTillMaxPrice(45.55);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public Customer getCustomerDetails() success
            try {
                customerFacade.getCustomerDetails();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }


        //**************************************************************************************************************
        //                                             Roei Rashty
        //**************************************************************************************************************
        try {
            customerFacade = (CustomerFacade) LoginManager.getInstance().login("notRoeiRashty@gmail.com", "roei_the_king", ClientType.CUSTOMER);
            // public void purchaseCoupon(int couponID) three coupons success
            try {
                customerFacade.purchaseCoupon(6);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(7);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(9);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCoupons() success
            try {
                customerFacade.getCustomerCoupons();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) success
            try {
                customerFacade.getCustomerCouponsByCategory(Category.Vacation);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) success
            try {
                customerFacade.getCustomerCouponsTillMaxPrice(60.75);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public Customer getCustomerDetails() success
            try {
                customerFacade.getCustomerDetails();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }


        //**************************************************************************************************************
        //                                             Zeev Mindali
        //**************************************************************************************************************
        try {
            customerFacade = (CustomerFacade) LoginManager.getInstance().login("notZeevMindali@gmail.com", "zeev_the_king", ClientType.CUSTOMER);
            // public void purchaseCoupon(int couponID) three coupons success
            try {
                customerFacade.purchaseCoupon(11);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(17);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            try {
                customerFacade.purchaseCoupon(20);
            } catch (PurchaseException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCoupons() success
            try {
                customerFacade.getCustomerCoupons();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) success
            try {
                customerFacade.getCustomerCouponsByCategory(Category.Vacation);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public ArrayList<Coupon> getCustomerCouponsTillMaxPrice(double maxPrice) success
            try {
                customerFacade.getCustomerCouponsTillMaxPrice(60.75);
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
            // public Customer getCustomerDetails() success
            try {
                customerFacade.getCustomerDetails();
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}