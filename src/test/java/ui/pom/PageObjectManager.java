package ui.pom;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private SignInPage signInPage;
    private PortalPage portalPage;

    public PageObjectManager (WebDriver driver){
        this.driver = driver;
    }

    public SignInPage getSignInPage(){
        return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
    }

    public PortalPage getPortalPage(){
        return (portalPage == null) ? portalPage = new PortalPage(driver) : portalPage;
    }
}
