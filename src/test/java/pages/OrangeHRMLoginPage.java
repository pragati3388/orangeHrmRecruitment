package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.OrangeHrmSetup;
import static setup.OrangeHrmSetup.*;

public class OrangeHRMLoginPage {

    public OrangeHRMLoginPage(WebDriver driver) {
            PageFactory.initElements(driver,this);
        }

    @FindBy(name="username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(css ="[type=submit]")
    WebElement btnLogin;
    @FindBy(tagName = "p")
    WebElement lvlInvalidCreds;
    @FindBy(tagName = "span")
    WebElement withoutCreds;
    @FindBy(tagName = "h6")
    WebElement dashboard;
    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    WebElement profileDropDown;

    @FindBy(partialLinkText = "Logout")
    WebElement logout;

    public void doLogin(String user,String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);
        btnLogin.click();
    }

    public String doLogInWithInvalidCreds(String username, String password){
        this.username.sendKeys(username);//username
        this.password.sendKeys(password);//password
        btnLogin.click();
        return lvlInvalidCreds.getText();
    }
    public String doLogInWithoutCreds(String username, String password){
        btnLogin.click();
        return withoutCreds.getText();
    }

    public void doLogout(String user,String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);
        btnLogin.click();
        String message = dashboard.getText();
        softAssert.assertEquals("Dashboard",message);
        profileDropDown.click();
        logout.click();
        softAssert.assertTrue(username.isEnabled());

    }

}
