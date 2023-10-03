package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

        //WebDriver driver;
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

}
