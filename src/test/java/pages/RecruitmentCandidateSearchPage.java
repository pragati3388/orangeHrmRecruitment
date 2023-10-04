package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import setup.OrangeHrmSetup;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static setup.OrangeHrmSetup.*;

public class RecruitmentCandidateSearchPage {

    public RecruitmentCandidateSearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[normalize-space()='Recruitment'])")
    WebElement recruitmentMenu;
    @FindBy(css="[type=submit]")
    WebElement searchButton;
    @FindBy(xpath ="//div[contains(@class,'oxd-grid-4')]/div[4]//div[2]/div/div[contains(@class,'oxd-select-text')]")
    WebElement status;
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> options;
    @FindBy(xpath = "//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")
    WebElement recordCount;
    @FindBy(xpath="input[@fdprocessedid='gr9oyn']")
    WebElement inputBox;
    @FindBy(xpath="//form/div[3]/div/div/div/div[2]/div/div[contains(@class,'oxd-select-text oxd-select-text--active')]")
    WebElement modeOfApplication;
    @FindBy(xpath = "//div[@class='oxd-table-filter']//input")
    WebElement srchInputs;
   // @FindBy(xpath = "//button[text()='Reset']")
    @FindBy(css="[type=reset]")
    WebElement resetButton;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")
    WebElement selectAllCandidates;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")
    WebElement deleteSelectedButton;
    @FindBy(xpath = "//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[2]/p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]")
    WebElement deleteAlertPopupMessage;
    @FindBy(xpath="//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")
    WebElement firstRowSelect;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")
    WebElement secondRowSelect;
    @FindBy(xpath = "//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")
    WebElement recordFound;
    @FindBy(xpath = "//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')]")
    WebElement deleteConfirmButton;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[7]/div/button[1]")
    WebElement viewButton;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[7]/div/button[2]")
    WebElement deleteButtonIcon;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[7]/div/button[1]")
    WebElement downloadButton;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-header-container')]/button")
    WebElement addButton;
    @FindBy(xpath = "//div[contains(@class,'oxd-grid-3')]/div/div/div[2]/div/div[contains(@class,'oxd-select-text')]")
    WebElement vacancyDropDown;


    public void candidateSearchWithoutFilter(){
        recruitmentMenu.click();
        softAssert.assertTrue(searchButton.isEnabled());
        searchButton.click();

    }

    public void candidateSearchWithDropDownFilter(){
        recruitmentMenu.click();
        status.click();
        System.out.println("Total number of options in status :"+options.size());//to get the size of status
        for(WebElement op:options)//to get options in Webelement one by one
        {
            if(op.getText().equals("Rejected"))
            {
                op.click();
                break;
            }
        }
        searchButton.click();
    }
    public void candidateSearchWithInputTextBoxFilter(){
        recruitmentMenu.click();
        srchInputs.sendKeys("Root");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Total number of options in status :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals("Joe Root"))
            {
                op.click();
                break;
            }
        }

        searchButton.click();
    }
    public void candidateResetButton(){
        recruitmentMenu.click();
        srchInputs.sendKeys("Root");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Total number of options in status :" + options.size());
        for (WebElement op : options) {
            if (op.getText().equals("Joe Root")) {
                op.click();
                break;
            }
        }
        modeOfApplication.click();
        System.out.println("Total number of options in status :" + options.size());
        for (WebElement op : options) {
            if (op.getText().equals("Manual")) {
                op.click();
                break;
            }
        }
        searchButton.click();
        resetButton.click();
    }
    public void selectAllCandidatesInRecord(){
        recruitmentMenu.click();
        selectAllCandidates.click();

    }

    public void deleteCandidateOnSingleCheckBoxSelect(){
        recruitmentMenu.click();
        firstRowSelect.click();
        String deleteBtnMessage = deleteSelectedButton.getText();
        softAssert.assertTrue(deleteBtnMessage.contains("Delete Selected"));
        String selectMessage = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']/div[2]//div/div/span[@class='oxd-text oxd-text--span']")).getText();
        softAssert.assertTrue(selectMessage.contains("Selected"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        deleteSelectedButton.click();
        String confirmationMsg = deleteAlertPopupMessage.getText();
        System.out.println(confirmationMsg);
        softAssert.assertTrue(confirmationMsg.contains("permanently deleted"));
        softAssert.assertAll();
    }
    public void deleteCandidateMultiSelect(){
        recruitmentMenu.click();
        String foundRecordBeforeSelect = recordFound.getText().trim();
        firstRowSelect.click();
        secondRowSelect.click();
        deleteSelectedButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        deleteConfirmButton.click();
        String foundRecordAfterSelect = recordFound.getText().trim();
        int beforeSelectRecord =  Integer.valueOf(foundRecordBeforeSelect.substring(1,foundRecordBeforeSelect.indexOf(")")));
        int afterDeleteRecord =  Integer.valueOf(foundRecordAfterSelect.substring(1,foundRecordAfterSelect.indexOf(")")));
        softAssert.assertEquals(beforeSelectRecord - 2 , afterDeleteRecord);
        softAssert.assertAll();
    }
    public void viewButton(){
        recruitmentMenu.click();
        String selectedCandidateName= driver.findElement(By.xpath("//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[3]/div")).getText().trim();
        viewButton.click();
        String candidateName= driver.findElement(By.xpath("//div[contains(@class,'oxd-grid-3 orangehrm-full-width-grid')]/div[1]/div[1]/div[2]/p")).getText().trim();
        softAssert.assertEquals(selectedCandidateName,candidateName);
        softAssert.assertAll();
    }
    public void deleteButtonIcon() {
        recruitmentMenu.click();
        deleteButtonIcon.click();
    }
    public void addNewCandidate(){
        JSONObject newCandidate = Utils.loadJsonFile("./src/test/resources/addNewCandidate.json");
        recruitmentMenu.click();
        addButton.click();
        driver.findElement(By.name("firstName")).sendKeys((String) newCandidate.get("firstName"));
        driver.findElement(By.name("middleName")).sendKeys((String) newCandidate.get("middleName"));
        driver.findElement(By.name("lastName")).sendKeys((String) newCandidate.get("lastName"));
        vacancyDropDown.click();
        System.out.println("Total number of options in status :"+options.size());
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for(WebElement op:options)
        {
            if(op.getText().equals((String) newCandidate.get("vacancy")))
            {
                op.click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[3]/div[1]/div[1]/div[1]/div[2]/input")).sendKeys((String) newCandidate.get("email"));
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[3]/div[1]/div[2]/div[1]/div[2]/input")).sendKeys((String) newCandidate.get("mobile"));
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[5]/div[1]/div[1]/div[1]/div[2]/input")).sendKeys((String) newCandidate.get("keywords"));
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[8]/button[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")).click();//saveButton

        String candidateName= driver.findElement(By.xpath("//div[contains(@class,'oxd-grid-3 orangehrm-full-width-grid')]/div[1]/div[1]/div[2]/p")).getText().trim();
        softAssert.assertEquals((String) newCandidate.get("firstName") + " "+ (String) newCandidate.get("middleName") + " " + (String) newCandidate.get("lastName") ,candidateName);
        String vacancy = driver.findElement(By.xpath("//div[contains(@class,'oxd-grid-3 orangehrm-full-width-grid')]/div[2]/div[1]/div[2]/p")).getText().trim();
        softAssert.assertEquals((String) newCandidate.get("vacancy"),vacancy);
        String applicationStatus = driver.findElement(By.xpath("//div[contains(@class,'orangehrm-recruitment-status')]/p")).getText().trim();
        softAssert.assertTrue(applicationStatus.contains((String) newCandidate.get("status")));
        softAssert.assertAll();
    }

}


