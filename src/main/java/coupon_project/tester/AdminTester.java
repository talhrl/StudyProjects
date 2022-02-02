package coupon_project.tester;

import com.mysql.cj.xdevapi.Table;
import coupon_project.beans.Company;
import coupon_project.beans.Customer;
import coupon_project.exceptions.AdministrationException;
import coupon_project.exceptions.LoginException;
import coupon_project.facade.AdminFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;
import coupon_project.utils.TablePrinter;

import java.sql.SQLException;

public class AdminTester {
    public static void adminLoginFail() {
        System.out.println("adminLoginFail start");
        AdminFacade adminFacade = null;
        try {
            adminFacade = (AdminFacade) LoginManager.getInstance().login("admin@admin.com", "asd", ClientType.ADMINISTRATOR);
            System.out.println("login succeeded with wrong password");
        } catch (Exception exception) {
            try {
                adminFacade = (AdminFacade) LoginManager.getInstance().login("aom", "admin", ClientType.ADMINISTRATOR);
                System.out.println("login succeeded with wrong email");
            } catch (Exception exception1) {
                try {
                    adminFacade = (AdminFacade) LoginManager.getInstance().login("admin@admin.com", "admin", ClientType.CUSTOMER);
                    System.out.println("login succeeded with wrong clientType");
                } catch (Exception e) {
                    System.out.println("login failed successfully");
                }
            }
        }
        System.out.println("adminLoginFail end");
    }

    public static void adminTester() {
        System.out.println("adminTester start");
        AdminFacade adminFacade;
        try {
            System.out.println("attempting login...");
            adminFacade = (AdminFacade) LoginManager.getInstance().login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
            System.out.println("login successful");
            //public void addCompany(Company company) six companies success
            try {
                adminFacade.addCompany(new Company("Roofmart", "roof@mart.com", "groceries"));
                System.out.println("Roofmart added");
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCompany(new Company("Pear", "pear@pear.com", "better_than_apple"));
                System.out.println("Pear added");
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCompany(new Company("Geegle", "geegle@geemail.com", "geegle4ever"));
                System.out.println("adding 3rd company");
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCompany(new Company("Macrosoft", "macrosoft11@macro-soft.com", "macro_means_bigger"));
                System.out.println("adding 4th company");
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCompany(new Company("Galaxybucks", "galaxybucks42@bucks.com", "bucksbucksbucks123"));
                System.out.println("adding 5th company");
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCompany(new Company("Nice", "nice@good.com", "87654321"));
                System.out.println("Adding 6th company");
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void addCompany(Company company) failed by name
            try {
                System.out.println("public void addCompany(Company company): reused name:");
                adminFacade.addCompany(new Company("Nice", "notnice@good.com", "12345678"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void addCompany(Company company) failed by email
            try {
                System.out.println("public void addCompany(Company company):should fail- reused email:");
                adminFacade.addCompany(new Company("telport", "galaxybucks42@bucks.com", "whyb79"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void updateCompany(Company company) failed by company doesn't exists
            try {
                System.out.println("public void updateCompany(Company company): should fail - non existent name");
                adminFacade.updateCompany(new Company("notNice", "notnice@good.com", "12345678"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void updateCompany(Company company) success
            try {
                System.out.println("public void updateCompany(Company company): should succeed");
                adminFacade.updateCompany(new Company("Nice", "notnice@good.com", "not87654321"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void deleteCompany(int companyID) failed by company doesn't exists
            try {
                adminFacade.deleteCompany(7);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void deleteCompany(int companyID) success
            try {
                adminFacade.deleteCompany(6);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public ArrayList<Company> getAllCompanies() success
            try {
                TablePrinter.print(adminFacade.getAllCompanies());
            } catch (SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public Company getOneCompany(int companyID) success
            try {
                TablePrinter.print(adminFacade.getOneCompany(3));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public Company getOneCompany(int companyID) failed by company doesn't exists
            try {
                adminFacade.getOneCompany(7);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void addCustomer(Customer customer) six customers success
            try {
                adminFacade.addCustomer(new Customer("notTal", "notHarel", "notTalHarel@gmail.com", "tal_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCustomer(new Customer("notShiri", "notLevi", "notShiriLevi@gmail.com", "shiri_the_queen"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCustomer(new Customer("notMatan", "notOzer", "notMatanOzer@gmail.com", "matan_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCustomer(new Customer("notRoei", "notRashty", "notRoeiRashty@gmail.com", "roei_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCustomer(new Customer("notZeev", "notMindali", "notZeevMindali@gmail.com", "zeev_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                adminFacade.addCustomer(new Customer("notElon", "notMusk", "notElonMusk@gmail.com", "elon_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void addCustomer(Customer customer) failed by email
            try {
                adminFacade.addCustomer(new Customer("Elon", "Musk", "notElonMusk@gmail.com", "not_elon_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void updateCustomer(Customer customer) failed by customer doesn't exists
            try {
                adminFacade.updateCustomer(new Customer("notRoei", "notRashty", "RoeiRashty@gmail.com", "roei_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void updateCustomer(Customer customer) success
            try {
                adminFacade.updateCustomer(new Customer("notMatan", "notOzer", "notMatanOzer@gmail.com", "matan_not_the_king"));
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void deleteCustomer(int customerID) failed by customer doesn't exists
            try {
                adminFacade.deleteCustomer(7);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public void deleteCustomer(int customerID) success
            try {
                adminFacade.deleteCustomer(6);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public ArrayList<Customer> getAllCustomers() success
            try {
                adminFacade.getAllCustomers();
            } catch (SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public Customer getOneCustomer(int customerID) success
            try {
                adminFacade.getOneCustomer(4);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //public Customer getOneCustomer(int customerID) failed by customer doesn't exist
            try {
                adminFacade.getOneCustomer(7);
            } catch (AdministrationException | SQLException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } catch (LoginException | InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
