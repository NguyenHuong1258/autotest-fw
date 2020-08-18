package ui.pom;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PortalPage extends BasePage {

    WebDriver driver;
    private static Logger logger = LogManager.getLogger(PortalPage.class.getName());

    public PortalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Locators and methods
     */
    @FindBy(xpath = "//*[contains(text(), '[ Parent Portal ]')]")
    private WebElement portalHyperLink;

    @FindBy(xpath = "//table[@class = 'table table-striped table-bordered table-hover table-condensed table-body']/tbody/tr/td[2]")
    private List<WebElement> statuses;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover table-condensed table-body']/tbody/tr/td[6]")
    private List<WebElement> firstNames;

    @FindBy(xpath = "//table[@class = 'table table-hover table-bordered table-condensed table-header']//tr/th[6]")
    private WebElement firstNameSortBtn;

    @FindBy(css = "button[class='btn btn-filter module_grid__btn_filter btn btn-default']")
    private WebElement filtersBtn;

    @FindAll(@FindBy(css = "#formControlsSelect"))
    private WebElement requestStatusList;

    @FindBy(xpath = "//*[contains(text() , 'Apply Filters')]")
    private WebElement applyFiltersBtn;

    @FindBy(xpath = "//a[contains(text(), 'Request Status:')]")
    private WebElement filterTagInactive;

    /**
     * Methods
     */
    //Verify Portal page is displayed
    public boolean verifyPortalIsDisplayed() {
        return isElementDisplayedOnPage(portalHyperLink);
    }

    //Sorting by FirstName
    String[] beforeSort_name;
    public String [] getNamesBeforeSort() {
        beforeSort_name = new String[firstNames.size()];
        for (int i = 0; i < firstNames.size(); i++) {
                beforeSort_name[i] = firstNames.get(i).getText().trim();
            }
        return beforeSort_name;
    }

    public void sortByFirstName() throws InterruptedException {
        clickButton(firstNameSortBtn);
        Thread.sleep(2000);
    }

    String[] afterSort_name;
    public String [] getNamesAfterSort(){
        afterSort_name = new String[firstNames.size()];
        for (int i = 0; i < firstNames.size(); i++) {
            afterSort_name[i] = firstNames.get(i).getText().trim();
        }
        return afterSort_name;
    }

    public boolean verifyFirstNameIsSorted(){
        if (beforeSort_name != afterSort_name){
            System.out.println("FirstName Column is sorted");
            return true;
        }
        else {
            System.out.println("Not sorted");
            return false;
        }
    }

    // Filters methods
    public void clickFiltersButton(){
        clickButton(filtersBtn);
    }

    public void selectInactive() throws InterruptedException {
        Select select = new Select(requestStatusList);
        select.selectByVisibleText("Inactive");
        Thread.sleep(2000);
    }

    public void clickApplyFiltersBtn(){
        clickButton(applyFiltersBtn);
    }

    public boolean verifyTagInactiveIsDisplayed(){
        return isElementDisplayedOnPage(filterTagInactive);
    }

    // Method to print array
    public void print(String [] ar){
        for (int i = 0; i < ar.length; i++){
            System.out.println(ar[i]);
        }
    }
}
