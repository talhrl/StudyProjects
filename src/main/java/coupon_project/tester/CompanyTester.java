package coupon_project.tester;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.exceptions.CompanyException;
import coupon_project.exceptions.LoginException;
import coupon_project.facade.CompanyFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;
import coupon_project.utils.DateUtils;
import coupon_project.utils.NumberUtils;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CompanyTester {
    //public boolean login(String email, String password) failed
    public static void companyLoginFail() {
        CompanyFacade companyFacade = null;
        try {
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("galaxybucks42@bucks.com", "bucksbucksbucks321", ClientType.COMPANY);
            System.out.println("login succeeded with wrong password");
        } catch (Exception exception) {
            try {
                companyFacade = (CompanyFacade) LoginManager.getInstance().login("aom", "bucksbucksbucks123", ClientType.COMPANY);
                System.out.println("login succeeded with wrong email");
            } catch (Exception exception1) {
                try {
                    companyFacade = (CompanyFacade) LoginManager.getInstance().login("galaxybucks42@bucks.com", "bucksbucksbucks123", ClientType.ADMINISTRATOR);
                    System.out.println("login succeeded with wrong clientType");
                } catch (Exception e) {
                    System.out.println("login failed successfully");
                }
            }
        }
    }

    //public boolean login(String email, String password) one company success
    public static void companyTester() {
        CompanyFacade companyFacade;

        //**************************************************************************************************************
        //                                           RoofMart
        //**************************************************************************************************************
        try {
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("Roof@mart.com", "roofmart", ClientType.COMPANY);

            //void addCoupon(Coupon coupon) six coupons success
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Shirt", "A cheap cheap shirt", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Electricity, "Computer", "A cheap cheap computer", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            // expired coupon, ID=3
            Calendar expiredCalendar = new GregorianCalendar();
            expiredCalendar.add(Calendar.DAY_OF_MONTH,-1);
            try {
                companyFacade.addCoupon(new Coupon(Category.Grocery, "Milk", "A cheap cheap milk", DateUtils.getStartDate(), expiredCalendar.getTime(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            // amount coupon =0, ID=4
            try {
                companyFacade.addCoupon(new Coupon(Category.Restaurant, "McDonald", "A cheap cheap fake hamburger", DateUtils.getStartDate(), DateUtils.getEndDate(), 0, NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Vacation, "Fatal", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Jeans", "Cheap cheap jeans", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }

            //void addCoupon(Coupon coupon) failed by name
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Shirt", "not A cheap cheap shirt", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //void updateCoupon(Coupon coupon) failed by coupon doesn't exists
            try {
                companyFacade.updateCoupon(new Coupon(Category.Vacation, "not Fatal", "cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //void updateCoupon(Coupon coupon) success
            try {
                companyFacade.updateCoupon(new Coupon(Category.Fashion, "Jeans", "Cheap beauty jeans", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //void deleteCoupon(int couponID) failed by coupon doesn't exists
            try {
                companyFacade.deleteCoupon(7);
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //void deleteCoupon(int couponID) success
            try {
                companyFacade.deleteCoupon(3);
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCoupons() success
            try {
                companyFacade.getCompanyCoupons();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsByCategory(Category category) success
            try {
                companyFacade.getCompanyCouponsByCategory(Category.Fashion);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) success
            try {
                companyFacade.getCompanyCouponsTillMaxPrice(70.50);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //public Company getCompanyDetails() success
            try {
                companyFacade.getCompanyDetails();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }

        //and now, for each of the rest four companies:
        //public boolean login(String email, String password)
        //void addCoupon(Coupon coupon) five coupons success
        //ArrayList<Coupon> getCompanyCoupons() success
        //ArrayList<Coupon> getCompanyCouponsByCategory(Category category) success
        //ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) success
        //public Company getCompanyDetails() success

        //**************************************************************************************************************
        //                                           GalaxyBucks
        //**************************************************************************************************************

        try {
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("galaxybucks42@bucks.com", "bucksbucksbucks123", ClientType.COMPANY);
            //void addCoupon(Coupon coupon) five coupons success
            try {
                companyFacade.addCoupon(new Coupon(Category.Electricity, "TV", "A cheap cheap TV", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Grocery, "Coca Cola", "A cheap cheap coca cola bottle", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Restaurant, "Ahla", "A cheap cheap hummus", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Vacation, "Leonardo", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Shoes", "Cheap cheap shoes", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCoupons() success
            try {
                companyFacade.getCompanyCoupons();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsByCategory(Category category) success
            try {
                companyFacade.getCompanyCouponsByCategory(Category.Vacation);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) success
            try {
                companyFacade.getCompanyCouponsTillMaxPrice(43.64);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //public Company getCompanyDetails() success
            try {
                companyFacade.getCompanyDetails();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }

        //**************************************************************************************************************
        //                                           Pear
        //**************************************************************************************************************

        try {
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("pear@pear.com", "better_than_apple", ClientType.COMPANY);
            //void addCoupon(Coupon coupon) five coupons success
            try {
                companyFacade.addCoupon(new Coupon(Category.Electricity, "Phone", "A cheap cheap phone", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Grocery, "Pasta", "A cheap cheap pasta", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Restaurant, "Shipudei Tzipora", "A cheap cheap meat", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Vacation, "Club Hotel", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Socks", "Cheap cheap socks", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCoupons() success
            try {
                companyFacade.getCompanyCoupons();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsByCategory(Category category) success
            try {
                companyFacade.getCompanyCouponsByCategory(Category.Restaurant);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) success
            try {
                companyFacade.getCompanyCouponsTillMaxPrice(66.60);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //public Company getCompanyDetails() success
            try {
                companyFacade.getCompanyDetails();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }

        //**************************************************************************************************************
        //                                           MacroSoft
        //**************************************************************************************************************

        try {
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("macrosoft11@macro-soft.com", "macro_means_bigger",ClientType.COMPANY);
            //void addCoupon(Coupon coupon) five coupons success
            try {
                companyFacade.addCoupon(new Coupon(Category.Electricity, "Laptop", "A cheap cheap laptop", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Grocery, "Cucumber", "A cheap cheap cucumber", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Restaurant, "Cafe Cafe", "A cheap cheap coffee", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Vacation, "Hilton", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Hat", "A cheap cheap hat", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCoupons() success
            try {
                companyFacade.getCompanyCoupons();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsByCategory(Category category) success
            try {
                companyFacade.getCompanyCouponsByCategory(Category.Restaurant);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) success
            try {
                companyFacade.getCompanyCouponsTillMaxPrice(44.60);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //public Company getCompanyDetails() success
            try {
                companyFacade.getCompanyDetails();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }

        //**************************************************************************************************************
        //                                           Geegle
        //**************************************************************************************************************

        try {
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("geegle@geemail.com", "geegle4ever", ClientType.COMPANY);
            //void addCoupon(Coupon coupon) five coupons success
            try {
                companyFacade.addCoupon(new Coupon(Category.Electricity, "Electric Piano", "A cheap cheap electric piano", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Grocery, "Cornflakes", "A cheap cheap cornflakes", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Restaurant, "Japanika", "A cheap cheap sushi", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Vacation, "Tzimerim Bazafon", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                companyFacade.addCoupon(new Coupon(Category.Fashion, "Necklace", "A cheap cheap necklace", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"));
            } catch (CompanyException | SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCoupons() success
            try {
                companyFacade.getCompanyCoupons();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsByCategory(Category category) success
            try {
                companyFacade.getCompanyCouponsByCategory(Category.Electricity);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //ArrayList<Coupon> getCompanyCouponsTillMaxPrice(double maxPrice) success
            try {
                companyFacade.getCompanyCouponsTillMaxPrice(35.46);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
            //public Company getCompanyDetails() success
            try {
                companyFacade.getCompanyDetails();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (LoginException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
