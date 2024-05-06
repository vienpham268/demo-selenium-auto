package pages.home;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import scripts.BaseTest;

public class NetlifyHomePage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='enter github user name']")
    WebElement iptSearch;

    @FindBy(xpath = "//button[text()='search']")
    WebElement btnSearch;

    public NetlifyHomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Do a search with  {text}")
    public void doASearch(String text) {
        sendTextToElement(iptSearch, text);
        getCsa().assertEquals("aa", text, "Verify line1");
        clickToElement(btnSearch);
        getCsa().assertEquals("bb", text, "Verify line2");
    }

    @Step("Clear search")
    public void clearSearch() {
        clearTextInElement(iptSearch);
    }
}
