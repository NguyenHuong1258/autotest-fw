package ui.tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.pom.PageObjectManager;
import ui.pom.PortalPage;
import ui.pom.SignInPage;
import utilities.property.PropertyReaderManager;

public class Tests extends BaseTest {
    private PageObjectManager pageObjectManager;
    private SignInPage signInPage;
    private PortalPage portalPage;
    private static Logger logger = LogManager.getLogger(Tests.class.getName());

    @Test(description = "Verify sorting of First Name column", alwaysRun = true, priority = 1)
    @Story("Karros Challenge - Verify sorting of First Name column")
    @Feature("Exploratory testing")
    @Severity(SeverityLevel.CRITICAL)
    public void verifySortedByFirstName() throws InterruptedException {
        pageObjectManager = new PageObjectManager(driver);
        signInPage = pageObjectManager.getSignInPage();
        portalPage = pageObjectManager.getPortalPage();
        driver.navigate().to(PropertyReaderManager.getInstance().getConfigPropertiesReader().getApplicationURL());
        signInPage.inputUserInfo("admin@test.com", "test123");
        signInPage.clickLogin();
        Assert.assertTrue(portalPage.verifyPortalIsDisplayed());

        portalPage.getNamesBeforeSort();
        portalPage.sortByFirstName();
        portalPage.getNamesAfterSort();
        Assert.assertEquals(portalPage.verifyFirstNameIsSorted(), true);
    }

    @Test(description = "Verify filter Student Access Request with INACTIVE", alwaysRun = true, priority = 2)
    @Story("Karros Challenge - Verify filter Student Access Request with INACTIVE")
    @Feature("Exploratory testing")
    @Severity(SeverityLevel.NORMAL)
    public void verifyFilerInactiveStatus() throws InterruptedException {
        pageObjectManager = new PageObjectManager(driver);
        signInPage = pageObjectManager.getSignInPage();
        portalPage = pageObjectManager.getPortalPage();
        driver.navigate().to(PropertyReaderManager.getInstance().getConfigPropertiesReader().getApplicationURL());
        signInPage.inputUserInfo("admin@test.com", "test123");
        signInPage.clickLogin();
        Assert.assertTrue(portalPage.verifyPortalIsDisplayed());

        portalPage.clickFiltersButton();
        portalPage.selectInactive();
        portalPage.clickApplyFiltersBtn();
        Assert.assertEquals(portalPage.verifyTagInactiveIsDisplayed(), true);
    }
}
