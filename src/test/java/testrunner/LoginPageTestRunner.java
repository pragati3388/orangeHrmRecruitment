package testrunner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import setup.OrangeHrmSetup;

public class LoginPageTestRunner extends OrangeHrmSetup {
    OrangeHRMLoginPage loginPage;

    @Test(priority = 1, description = "User login with valid credential")
    public void doLogin(){
        loginPage=new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        String message = driver.findElement(By.tagName("h6")).getText();
        softAssert.assertEquals("Dashboard",message);
        softAssert.assertAll();
    }

    @Test(priority = 2,description = "User doLogin with invalid credential")
    public void doLoginWithInvalidCredential(){
        loginPage=new OrangeHRMLoginPage(driver);
        String message_actual= loginPage.doLogInWithInvalidCreds("Simple","45256");
        String message_expected="Invalid credentials";
        softAssert.assertTrue(message_actual.contains(message_expected));
        softAssert.assertAll();
    }

    @Test(priority = 3,description = "User doLogin with invalid username and valid password")
    public void doLoginWithInvalidUsername(){
        loginPage=new OrangeHRMLoginPage(driver);
        String message_actual= loginPage.doLogInWithInvalidCreds("Abcd","admin123");
        String message_expected="Invalid credentials";
        softAssert.assertTrue(message_actual.contains(message_expected));
        softAssert.assertAll();
    }

    @Test(priority = 4,description = "User doLogin without credentials")
    public void doLoginWithoutCredentials(){
        loginPage=new OrangeHRMLoginPage(driver);
        String message_actual= loginPage.doLogInWithoutCreds("","");
        String message_expected="Required";
        softAssert.assertTrue(message_actual.contains(message_expected));
        softAssert.assertAll();
    }

}
