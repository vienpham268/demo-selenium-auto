package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class SWTestingTutorialPage extends BasePage {
    @FindBy(xpath = "//h1[text()='Software Testing Tutorial']")
    WebElement title;

    @FindBy(xpath = "//span[text()='Facebook']")
    WebElement FBlink;

    public SWTestingTutorialPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifySWTestingPage() {
        getCsa().assertEquals(getText(title), "Software Testing Tutorial");
        getCsa().assertEquals(driver.getCurrentUrl(), "https://toolsqa.com/software-testing/software-testing-tutorial/");
        System.out.println("Verify access SWTestingPage successful.");
        rightClickElement(FBlink);
    }

    public void directToFBPage() {
        doubleClickElement(FBlink);
        getCsa().assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/tools.qa");
        System.out.println("Verify access FB Page successful.");
    }

    public void getFBAttribute() {
    }
}
