package pages;

import asserts.CustomSoftAssert;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    final long EXPLICIT_TIMEOUT = 1;
    WebDriverWait wait;
    @Getter
    CustomSoftAssert csa;

    public BasePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
        this.csa = new CustomSoftAssert();
    }

    void waitForElementAvailable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void sendTextToElement(WebElement element, String text) {
        waitForElementAvailable(element);
        element.click();
        element.sendKeys(text);
        System.out.println("Sent text " + text + " to element " + element);
    }

    protected void clearTextInElement(WebElement element) {
        waitForElementAvailable(element);
        element.clear();
        System.out.println("Cleared text of element " + element);
    }

    protected void clickToElement(WebElement element) {
        waitForElementAvailable(element);
        element.click();
        System.out.println("Clicked to element " + element);
    }
}
