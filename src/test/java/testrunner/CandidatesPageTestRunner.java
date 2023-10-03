package testrunner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import pages.RecruitmentCandidateSearchPage;
import setup.OrangeHrmSetup;

import java.util.concurrent.TimeUnit;

public class CandidatesPageTestRunner extends OrangeHrmSetup {
    RecruitmentCandidateSearchPage recruitmentCandidateSearch;
    OrangeHRMLoginPage loginPage;
   // JSONObject jsonObject = Utils.loadJsonFile("./src/test/resources/user.json");

    @Test(priority = 1, description ="search without filter")
    public void candidateSearch() throws InterruptedException{
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearch();
        Thread.sleep(10000);
    }
    @Test(priority = 2, description = "search with single dropdown filter")
    public void candidateSearchWithDropdown() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearch1();
        String message = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        Assert.assertTrue(message.contains("Records Found"));
        Thread.sleep(10000);
    }

    @Test(priority = 3, description = "search with inputTextBox")
    public void candidateSearchWithInputTextBox() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearch2();
       // String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
       // Assert.assertTrue(message.contains("Records Found"));
        Thread.sleep(10000);
    }

    @Test(priority = 3, description = "Reset Button")
    public void candidateResetButton() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateResetButton();
        String message = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Records Found"));
    }
    @Test(priority = 4, description = "All Candidates select")
    public void selectAllCandidatesInRecord() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.selectAllCandidatesInRecord();
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

    @Test(priority = 4, description = "Delete selected Candidate")
    public void deleteCandidateSingleSelect() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteCandidateSingleSelect();
        String deleteBtnMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        Assert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        Assert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).click();
       // driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')]")).click();
        String confirmationMsg = driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[2]/p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]")).getText();
        System.out.println(confirmationMsg);
        Assert.assertTrue(confirmationMsg.contains("permanently deleted"));
        // //div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/button[contains(@class,'oxd-dialog-close-button')]  -- For Cross
        //div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin')] -- for cancel
////div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')] -- for delete
    }
    @Test(priority = 6, description = "Multi selected records Delete Candidates")
    public void deleteCandidateMultiSelect() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteCandidateMultiSelect();
       /* String deleteBtnMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        Assert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        Assert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).click();
        // driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')]")).click();
        String confirmationMsg = driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[2]/p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]")).getText();
        System.out.println(confirmationMsg);
        Assert.assertTrue(confirmationMsg.contains("permanently deleted"));*/
    }
    @Test(priority = 6, description = "Validating View Button")
    public void viewButton() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.viewButton();
    }
    @Test(priority = 7, description = "Validating delete Button Icon")
    public void deleteButtonIcon() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteButtonIcon();
    }
    @Test(priority = 7, description = "Validating delete Button Icon")
    public void addNewCandidate() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.addNewCandidate();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10000);
       // driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[8]/button[contains(@class,'oxd-button oxd-button--medium oxd-button--ghost')")).click();//cancelButton
    }

}

