package utilities.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Logger;

public class WebElementVerifications extends WebElementWaits {
    private final static Logger LOGGER = Logger.getLogger(WebElementVerifications.class.getName());

    public WebElementVerifications(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Check if element is visible or not
     *
     * @param webElement
     * @param message
     */
    protected void verifyElementIsVisible(final WebElement webElement, final String message) {
        waitForElementToBeVisible(webElement);
        LOGGER.info("Verify element to be visible");
        Assert.assertTrue(webElement.isDisplayed(), message);
    }
}
