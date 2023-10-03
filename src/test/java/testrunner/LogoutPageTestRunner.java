package testrunner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import setup.OrangeHrmSetup;

public class LogoutPageTestRunner extends OrangeHrmSetup {
    OrangeHRMLoginPage page;
    @Test(priority = 1, description = "User login with valid credential")
    public void doLogout(){
        page = new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");
        String password= (String) jsonObject.get("password");
        page.doLogout(username,password);

    }
}
