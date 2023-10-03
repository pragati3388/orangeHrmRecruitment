package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static setup.OrangeHrmSetup.driver;
import static setup.OrangeHrmSetup.softAssert;

public class RecruitmentVacanciesSearchPage {
    public RecruitmentVacanciesSearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[normalize-space()='Recruitment'])")
    WebElement recruitmentMenu;
    @FindBy(xpath="//li/a[contains(text(), 'Vacancies')]")
    WebElement vacanciesPage;
    @FindBy(xpath="//div[contains(@class,'oxd-grid-4')]/div[1]//div[2]/div/div[contains(@class,'oxd-select-text')]")
    WebElement jobTitle;
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> options;
    @FindBy(css="[type=submit]")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")
    WebElement recordCount;
    @FindBy(xpath="//div[contains(@class,'oxd-grid-4')]/div[4]//div[2]/div/div[contains(@class,'oxd-select-text')]")
    WebElement status;
    @FindBy(xpath = "//button[text()=' Reset ']")
    WebElement resetButton;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")
    WebElement selectAllVacancies;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]/div[1]/button[contains(@type,'button')]")
    WebElement deleteSelectedButton;
    @FindBy(xpath="//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")
    WebElement firstRowSelect;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[contains(@class,'oxd-checkbox-wrapper')]")
    WebElement secondRowSelect;
    @FindBy(xpath = "//div[@class='orangehrm-paper-container']/div[2]/div/span[@class='oxd-text oxd-text--span']")
    WebElement recordFound;
    @FindBy(xpath = "//div[contains(@class,'oxd-dialog-container-default--inner')]/div[1]/div[3]/button[contains(@class,'oxd-button--label-danger')]")
    WebElement deleteConfirmButton;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[6]/div/button[1]")
    WebElement deleteButtonIcon;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[6]/div/button[2]")
    WebElement editButtonIcon;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-container')]/div[1]/div[2]/div[1]/div[1]/div[2]")
    WebElement vacancyName;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-card-container')]/h6")
    WebElement editPageTitle;
    @FindBy(xpath = "//div[contains(@class,'orangehrm-header-container')]/button")
    WebElement addButton;
    @FindBy(xpath = "//div[contains(@class,'oxd-grid-3')]/div/div/div[2]/div/div[contains(@class,'oxd-select-text')]")
    WebElement jobTitleDropDown;

    public void vacanciesSearchWithoutFilter(){
        recruitmentMenu.click();
        vacanciesPage.click();
        softAssert.assertTrue(searchButton.isEnabled());
        searchButton.click();

    }
    public void vacanciesSearchWithSingleFilter() {
        recruitmentMenu.click();
        vacanciesPage.click();
        jobTitle.click();
        System.out.println("Total number of options in jobTitle :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals("Account Assistant"))
            {
                op.click();
                break;
            }
        }
        softAssert.assertTrue(searchButton.isEnabled());
        searchButton.click();

    }
    public void vacanciesSearchWithMultiFilter() {
        recruitmentMenu.click();
        vacanciesPage.click();
        jobTitle.click();
        System.out.println("Total number of options in jobTitle :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals("Account Assistant"))
            {
                op.click();
                break;
            }
        }
        status.click();
        System.out.println("Total number of options in Status :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals("Active"))
            {
                op.click();
                break;
            }
        }
        searchButton.click();

    }
    public void vacanciesResetButton() {
        recruitmentMenu.click();
        vacanciesPage.click();
        jobTitle.click();
        System.out.println("Total number of options in jobTitle :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals("Account Assistant"))
            {
                op.click();
                break;
            }
        }
        status.click();
        System.out.println("Total number of options in Status :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals("Closed"))
            {
                op.click();
                break;
            }
        }
        resetButton.click();

    }
    public void vacanciesSelectAllRecords() {
        recruitmentMenu.click();
        vacanciesPage.click();
        selectAllVacancies.click();
    }
    public void vacanciesSingleSelect() {
        recruitmentMenu.click();
        vacanciesPage.click();
        firstRowSelect.click();
    }
    public void deleteMultiSelectVacancies(){
        recruitmentMenu.click();
        vacanciesPage.click();
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
    }
    public void deleteIconOfVacancies(){
        recruitmentMenu.click();
        vacanciesPage.click();
        deleteButtonIcon.click();
    }
    public void editIconOfVacancies(){
        recruitmentMenu.click();
        vacanciesPage.click();
        editButtonIcon.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(editPageTitle.getText());
        softAssert.assertEquals("Edit Vacancy",editPageTitle.getText());
    }
    public void addNewVacancy() {
        JSONObject newVacancy = Utils.loadJsonFile("./src/test/resources/addNewVacancy.json");
        recruitmentMenu.click();
        vacanciesPage.click();
        addButton.click();
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[1]/div[1]/div[1]/div[2]/input[contains(@class,'oxd-input oxd-input--active')]")).sendKeys((String) newVacancy.get("vacancy"));
        jobTitleDropDown.click();
        System.out.println("Total number of options in status :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals((String) newVacancy.get("job")))
            {
                op.click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[2]/div[1]/div[1]/div[2]/textarea[1]")).sendKeys((String) newVacancy.get("description"));
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[3]/div[1]/div[1]/div[2]/div/div/input")).sendKeys(((String) newVacancy.get("hiringManager")).substring(0,4));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Total number of options in Hiring Manager :"+options.size());
        for(WebElement op:options)
        {
            if(op.getText().equals((String) newVacancy.get("hiringManager")))
            {
                op.click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/input")).sendKeys((String) newVacancy.get("positions"));
        driver.findElement(By.xpath("//div[contains(@class,'orangehrm-card-container')]/form/div[7]/button[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")).click();
        softAssert.assertEquals("Edit Vacancy",editPageTitle.getText());
    }

}
