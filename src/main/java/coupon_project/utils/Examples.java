package coupon_project.utils;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class Examples {
    public final static Company Roofmart = new Company("Roofmart", "roof@mart.com", "groceries");
    public final static Company Pear = new Company("Pear", "pear@pear.com", "better_than_apple");
    public final static Company Geegle = new Company("Geegle", "geegle@geemail.com", "geegle4ever");
    public final static Company Macrosoft = new Company("Macrosoft", "macrosoft11@macro-soft.com", "macro_means_bigger");
    public final static Company Galaxybucks = new Company("Galaxybucks", "galaxybucks42@bucks.com", "bucksbucksbucks123");
    public final static Company Nice = new Company("Nice", "nice@good.com", "87654321");


    public final static Coupon coupon01 = new Coupon(Category.Fashion, "Shirt", "A cheap cheap shirt", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon02 = new Coupon(Category.Electricity, "Computer", "A cheap cheap computer", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon03 = new Coupon(Category.Grocery, "Milk", "A cheap cheap milk", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon04 = new Coupon(Category.Restaurant, "McDonald", "A cheap cheap fake hamburger", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon05 = new Coupon(Category.Vacation, "Fatal", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon06 = new Coupon(Category.Fashion, "Jeans", "Cheap cheap jeans", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon07 = new Coupon(Category.Electricity, "TV", "A cheap cheap TV", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon08 = new Coupon(Category.Grocery, "Coca Cola", "A cheap cheap coca cola bottle", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon09 = new Coupon(Category.Restaurant, "Ahla", "A cheap cheap hummus", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon10 = new Coupon(Category.Vacation, "Leonardo", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon11 = new Coupon(Category.Fashion, "Shoes", "Cheap cheap shoes", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon12 = new Coupon(Category.Electricity, "Phone", "A cheap cheap phone", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon13 = new Coupon(Category.Grocery, "Pasta", "A cheap cheap pasta", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon14 = new Coupon(Category.Restaurant, "Shipudei Tzipora", "A cheap cheap meat", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon15 = new Coupon(Category.Vacation, "Club Hotel", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon16 = new Coupon(Category.Fashion, "Socks", "Cheap cheap socks", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon17 = new Coupon(Category.Electricity, "Laptop", "A cheap cheap laptop", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon18 = new Coupon(Category.Grocery, "Cucumber", "A cheap cheap cucumber", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon19 = new Coupon(Category.Restaurant, "Cafe Cafe", "A cheap cheap coffee", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon20 = new Coupon(Category.Vacation, "Hilton", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon21 = new Coupon(Category.Fashion, "Hat", "A cheap cheap hat", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon22 = new Coupon(Category.Electricity, "Electric Piano", "A cheap cheap electric piano", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon23 = new Coupon(Category.Grocery, "Cornflakes", "A cheap cheap cornflakes", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon24 = new Coupon(Category.Restaurant, "Japanika", "A cheap cheap sushi", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon25 = new Coupon(Category.Vacation, "Tzimerim Bazafon", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon26 = new Coupon(Category.Fashion, "Necklace", "A cheap cheap necklace", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon27 = new Coupon(Category.Electricity, "Lamb", "A cheap cheap lamb", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon28 = new Coupon(Category.Grocery, "Water Bottle", "A cheap cheap water bottle", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon29 = new Coupon(Category.Restaurant, "Burgeranch", "A cheap cheap hamburger", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon30 = new Coupon(Category.Vacation, "Wyndham", "A cheap cheap vacation", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");
    public final static Coupon coupon31 = new Coupon(Category.Fashion, "Underwear", "A cheap cheap underwear", DateUtils.getStartDate(), DateUtils.getEndDate(), NumberUtils.getAmount(), NumberUtils.getPrice(), "This PC//pictures//wow");

    public final static Customer customer1 = new Customer("notTal", "notHarel", "notTalHarel@gmail.com", "tal_the_king");
    public final static Customer customer2 = new Customer("notShiri", "notLevi", "notShiriLevi@gmail.com", "shiri_the_queen");
    public final static Customer customer3 = new Customer("notMatan", "notOzer", "notMatanOzer@gmail.com", "matan_the_king");
    public final static Customer customer4 = new Customer("notRoei", "notRashty", "notRoeiRashty@gmail.com", "roei_the_king");
    public final static Customer customer5 = new Customer("notZeev", "notMindali", "notZeevMindali@gmail.com", "zeev_the_king");
    public final static Customer customer6 = new Customer("notElon", "notMusk", "notElonMusk@gmail.com", "elon_the_king");

}
