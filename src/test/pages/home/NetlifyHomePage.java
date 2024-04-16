package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class NetlifyHomePage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='enter github user name']")
    WebElement iptSearch;

    @FindBy(xpath = "//button[text()='search']")
    WebElement btnSearch;

    public NetlifyHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void doASearch(String text) {
        sendTextToElement(iptSearch, text);
        getCsa().assertEquals("aa", text, "Verify line1");
        clickToElement(btnSearch);
        getCsa().assertEquals("bb", text, "Verify line2");
    }


    public void clearSearch() {
        clearTextInElement(iptSearch);
    }

}
