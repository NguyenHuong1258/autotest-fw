package ui.pom;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    WebDriver driver;
    private static Logger logger = LogManager.getLogger(SignInPage.class.getName());

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Page Locators
     */
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTxt;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTxt;

    @FindBy(xpath = "//a[@class='col-login__btn']")
    private WebElement loginBtn;

    /**
     * Page Methods
     */
    public void inputUserInfo(String email, String password) throws InterruptedException {
        sendKeyToTextBox(emailTxt, email);
        sendKeyToTextBox(passwordTxt, password);
    }

    public void clickLogin() throws InterruptedException {
        clickButton(loginBtn);
        Thread.sleep(2000);
    }
}
