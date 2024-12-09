package pages.home;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

@Slf4j
public class SearchPage extends BasePage {
    @FindBy(xpath = "//h1[@class='articles__list--heading']")
    WebElement result;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void VerifySearchingResult() {
        waitForElementAvailable(result);
        getCsa().assertTrue(getText(result).contains("Search - "));
        getCsa().assertTrue(driver.getCurrentUrl().contains("https://toolsqa.com/search?keyword="));
        log.info("Verify Searching text successful.");
    }
}
