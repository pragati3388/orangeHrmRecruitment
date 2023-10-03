package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import setup.OrangeHrmSetup;
import org.json.simple.JSONObject;
import utils.Utils;

public class LoginPageTestRunner extends OrangeHrmSetup {
    OrangeHRMLoginPage loginPage;
  //  JSONObject jsonObject = Utils.loadJsonFile("./src/test/resources/user.json");

    @Test(priority = 5, description = "User login with valid credential")
    public void doLogin(){
        //JSONObject jsonObject = Utils.loadJsonFile("./src/test/resources/user.json");
        loginPage=new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        WebElement headerText= driver.findElement(By.tagName("h6"));

    }

    @Test(priority = 2,description = "User doLogin with invalid credential")
    public void doLoginWithInvalidCreds(){
        loginPage=new OrangeHRMLoginPage(driver);
        String message_actual= loginPage.doLogInWithInvalidCreds("Simple","45256");
        String message_expected="Invalid credentials";
        Assert.assertTrue(message_actual.contains(message_expected));
    }
    @Test(priority = 3,description = "User doLogin with invalid username and valid password")
    public void doLoginWithInvalidUsername(){
        loginPage=new OrangeHRMLoginPage(driver);
        String message_actual= loginPage.doLogInWithInvalidCreds("Abcd","admin123");
        String message_expected="Invalid credentials";
        Assert.assertTrue(message_actual.contains(message_expected));
    }

    @Test(priority = 4,description = "User doLogin without credentials")
    public void doLoginWithoutCredentials(){
        loginPage=new OrangeHRMLoginPage(driver);
        String message_actual= loginPage.doLogInWithoutCreds("","");
        String message_expected="Required";
        Assert.assertTrue(message_actual.contains(message_expected));
    }

}
