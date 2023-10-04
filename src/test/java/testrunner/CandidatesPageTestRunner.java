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
        softAssert.assertAll();
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
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Search candidate with inputTextBox filter")
    public void candidateSearchWithInputTextBoxFilter(){
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateSearchWithInputTextBoxFilter();
    }

    @Test(priority = 4, description = "Reset Button on Candidate Page")
    public void candidateResetButton(){
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.candidateResetButton();
        String message = OrangeHrmSetup.driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")).getText();
        System.out.println(message);
        softAssert.assertTrue(message.contains("Records Found"));
        softAssert.assertAll();
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
        softAssert.assertAll();

    }

    @Test(priority = 6, description = "Delete selected Candidate")
    public void deleteCandidateOnSingleCheckBoxSelect(){
        loginPage=new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username= (String) jsonObject.get("username");;
        String password= (String) jsonObject.get("password");
        loginPage.doLogin(username,password);
        recruitmentCandidateSearch =new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteCandidateOnSingleCheckBoxSelect();

    }

    @Test(priority = 7, description = "Multi selected records Delete Candidates")
    public void deleteCandidateMultiSelect(){
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteCandidateMultiSelect();
    }
    @Test(priority = 8, description = "Validating View Button")
    public void viewButton(){
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.viewButton();
    }
    @Test(priority = 9, description = "Validating delete button")
    public void deleteButtonIcon(){
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.deleteButtonIcon();
    }
    @Test(priority = 10, description = "Adding new candidate")
    public void addNewCandidate() {
        loginPage = new OrangeHRMLoginPage(OrangeHrmSetup.driver);
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        loginPage.doLogin(username, password);
        recruitmentCandidateSearch = new RecruitmentCandidateSearchPage(OrangeHrmSetup.driver);
        recruitmentCandidateSearch.addNewCandidate();
    }

}

