package coupon_project.utils;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;

import java.util.ArrayList;
import java.util.Arrays;

public class Examples {
    public final static Company Roofmart = new Company(1, "Roofmart", "roof@mart.com", "groceries");
    public final static ArrayList<Coupon> roofmartCoupons = new ArrayList<>(Arrays.asList(
            new Coupon(1, 1, Category.Fashion, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(2, 1, Category.Electricity, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(3, 1, Category.Grocery, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(4, 1, Category.Restaurant, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(5, 1, Category.Vacation, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow")
    ));

    public final static Company Pear = new Company(2, "Pear", "pear@pear.com", "better_than_apple");
    public final static ArrayList<Coupon> pearCoupons = new ArrayList<>(Arrays.asList(
            new Coupon(6, 2, Category.Fashion, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(7, 2, Category.Electricity, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(8, 2, Category.Grocery, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(9, 2, Category.Restaurant, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(10, 2, Category.Vacation, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow")
    ));

    public final static Company Geegle = new Company(3, "Geegle", "geegle@geemail.com", "geegle4ever");
    public final static ArrayList<Coupon> geegleCoupons = new ArrayList<>(Arrays.asList(
            new Coupon(11, 3, Category.Fashion, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(12, 3, Category.Electricity, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(13, 3, Category.Grocery, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(14, 3, Category.Restaurant, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(15, 3, Category.Vacation, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow")
    ));

    public final static Company Macrosoft = new Company(4, "Macrosoft", "macrosoft11@macro-soft.com", "macro_means_bigger");
    public final static ArrayList<Coupon> macrosoftCoupons = new ArrayList<>(Arrays.asList(
            new Coupon(16, 4, Category.Fashion, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(17, 4, Category.Electricity, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(18, 4, Category.Grocery, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(19, 4, Category.Restaurant, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(20, 4, Category.Vacation, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow")
    ));

    public final static Company Galaxybucks = new Company(5, "Galaxybucks", "galaxybucks42@bucks.com", "bucksbucksbucks123");
    public final static ArrayList<Coupon> galaxybucksCoupons = new ArrayList<>(Arrays.asList(
            new Coupon(21, 5, Category.Fashion, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(22, 5, Category.Electricity, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(23, 5, Category.Grocery, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(24, 5, Category.Restaurant, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(25, 5, Category.Vacation, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow")
    ));

    public final static Company Nice = new Company(6, "Nice", "nice@good.com", "87654321");
    public final static ArrayList<Coupon> niceCoupons = new ArrayList<>(Arrays.asList(
            new Coupon(26, 6, Category.Fashion, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(27, 6, Category.Electricity, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(28, 6, Category.Grocery, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(29, 6, Category.Restaurant, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow"),
            new Coupon(30, 6, Category.Vacation, "title", "description", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow")
    ));

}
