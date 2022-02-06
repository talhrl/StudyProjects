package coupon_project.login;

import coupon_project.exceptions.LoginException;
import coupon_project.facade.AdminFacade;
import coupon_project.facade.ClientFacade;
import coupon_project.facade.CompanyFacade;
import coupon_project.facade.CustomerFacade;
import coupon_project.utils.DateUtils;

import java.sql.SQLException;

public class LoginManager {

    private static volatile LoginManager instance = null;

    private LoginManager() {
    }

    /**
     * double check, so that only one instance will be created, and so that only at creation time the sync block will be accessed.
     * @return reference to instance of login manager.
     */
    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    /**
     * gets email password and client type, and returns
     * @param email client's email.
     * @param password client's password.
     * @param clientType one of the 3 client types (admin, company, customer).
     * @return a facade object, which gives access to the client's allowed actions.
     * @throws LoginException when email and password don't match client type.
     * @throws SQLException when exception is raised from sql queries.
     * @throws InterruptedException if thread is interrupted.
     */
    public ClientFacade login(String email, String password, ClientType clientType) throws LoginException, SQLException, InterruptedException {
        switch (clientType) {
            case ADMINISTRATOR:
                ClientFacade adminFacade = new AdminFacade();
                if (!adminFacade.login(email, password)) {
                    throw new LoginException("Invalid email or password");
                }
                //System.out.println(DateUtils.getLocalDateTime() + email + " was logged");
                return adminFacade;
            case COMPANY:
                ClientFacade companyFacade = new CompanyFacade();
                if (!companyFacade.login(email, password)) {
                    throw new LoginException("Invalid email or password");
                }
                //System.out.println(DateUtils.getLocalDateTime() + email + " was logged");
                return companyFacade;
            case CUSTOMER:
                ClientFacade customerFacade = new CustomerFacade();
                if (!customerFacade.login(email, password)) {
                    throw new LoginException("Invalid email or password");
                }
                //System.out.println(DateUtils.getLocalDateTime() + email + " was logged");
                return customerFacade;
            default:
                return null;
        }
    }
}
