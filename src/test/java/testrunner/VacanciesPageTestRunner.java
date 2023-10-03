package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import pages.RecruitmentCandidateSearchPage;
import pages.RecruitmentVacanciesSearchPage;
import setup.OrangeHrmSetup;

import java.util.concurrent.TimeUnit;

public class VacanciesPageTestRunner extends OrangeHrmSetup {
    RecruitmentVacanciesSearchPage vacanciesSearch;
    OrangeHRMLoginPage loginPage;
   // JSONObject jsonObject = Utils.loadJsonFile("./src/test/resources/user.json");

    @Test(priority = 1, description ="search with filter")
    public void vacanciesSearchWithSingleFilter() throws InterruptedException{
        loginPage=new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.vacanciesSearchWithSingleFilter();
        String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Found"));
        Thread.sleep(10000);
    }

    @Test(priority = 2, description ="search with multiFilter")
    public void vacanciesSearchWithMultiFilter() throws InterruptedException{
        loginPage=new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.vacanciesSearchWithMultiFilter();
        String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Found"));
        Thread.sleep(10000);
    }

    @Test(priority = 2, description ="search with multiFilter")
    public void vacanciesResetButton() throws InterruptedException{
        loginPage=new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.vacanciesResetButton();
        String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Found"));
        Thread.sleep(10000);
    }
    @Test(priority = 2, description ="Select all vacancy record")
    public void vacanciesSelectAllRecords() throws InterruptedException{
        loginPage=new OrangeHRMLoginPage(driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.vacanciesSelectAllRecords();
        String deleteBtnMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        Assert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        Assert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-container')]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")).click();
        String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Found"));
    }
    @Test(priority = 4, description = "Single selected Vacancy")
    public void vacanciesSingleSelect() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.vacanciesSingleSelect();
        String deleteBtnMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        System.out.println(deleteBtnMessage);
        Assert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        Assert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).click();
        String confirmationMsg = driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[2]/p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]")).getText();
        System.out.println(confirmationMsg);
        Assert.assertTrue(confirmationMsg.contains("permanently deleted"));
    }
    @Test(priority = 6, description = "Multi selected records Delete Candidates")
    public void deleteCandidateMultiSelect() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.deleteMultiSelectVacancies();
    }
    @Test(priority = 7, description = "Validating Delete Icon")
    public void deleteIconVacancies() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.deleteIconOfVacancies();
    }
    @Test(priority = 8, description = "Validating Edit Icon")
    public void editIconOfVacancies() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        vacanciesSearch =new RecruitmentVacanciesSearchPage(driver);
        vacanciesSearch.editIconOfVacancies();
    }

}
