package testrunner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import pages.RecruitmentCandidateSearchPage;
import setup.OrangeHrmSetup;

import java.util.concurrent.TimeUnit;

public class CandidatesPageTestRunner extends OrangeHrmSetup {
    RecruitmentCandidateSearchPage recruitmentCandidateSearch;
    OrangeHRMLoginPage loginPage;

    @Test(priority = 1, description ="Search candidate without filter")
    public void candidateSearch(){
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearchWithoutFilter();
        String message = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Records Found"));
    }
    @Test(priority = 2, description = "Search candidate with single dropdown filter")
    public void candidateSearchWithDropDownFilter(){
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearchWithDropDownFilter();
        String message = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Records Found"));

    }

    @Test(priority = 3, description = "Search candidate with inputTextBox filter")
    public void candidateSearchWithInputTextBoxFilter() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearchWithInputTextBoxFilter();
       // String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
       // Assert.assertTrue(message.contains("Records Found"));
    }

    @Test(priority = 4, description = "Reset Button on Candidate Page")
    public void candidateResetButton() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateResetButton();
        String message = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        softAssert.assertTrue(message.contains("Records Found"));
    }
    @Test(priority = 5, description = "All Candidates select")
    public void selectAllCandidatesInRecord(){
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.selectAllCandidatesInRecord();
        String deleteBtnMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        softAssert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-container')]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")).click();
        String message = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(message.contains("Found"));

    }

    @Test(priority = 6, description = "Delete selected Candidate")
    public void deleteCandidateOnSingleCheckBoxSelect() throws InterruptedException {
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteCandidateOnSingleCheckBoxSelect();
        String deleteBtnMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).getText();
        softAssert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")).click();
       // driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')]")).click();
        String confirmationMsg = driver.findElement(By.xpath("//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[2]/p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]")).getText();
        System.out.println(confirmationMsg);
        softAssert.assertTrue(confirmationMsg.contains("permanently deleted"));
        // //div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/button[contains(@class,'oxd-dialog-close-button')]  -- For Cross
        //div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin')] -- for cancel
////div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')] -- for delete
    }
    @Test(priority = 7, description = "Multi selected records Delete Candidates")
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
    @Test(priority = 8, description = "Validating View Button")
    public void viewButton() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.viewButton();
    }
    @Test(priority = 9, description = "Validating delete button")
    public void deleteButtonIcon() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteButtonIcon();
    }
    @Test(priority = 10, description = "Adding new candidate")
    public void addNewCandidate() throws InterruptedException {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.addNewCandidate();
    }

}

