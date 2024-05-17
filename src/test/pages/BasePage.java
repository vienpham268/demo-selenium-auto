package pages;

import asserts.CustomSoftAssert;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import scripts.BaseTest;

import java.time.Duration;

public class BasePage {
    final long EXPLICIT_TIMEOUT = 20;
    WebDriverWait wait;
    @Getter
    CustomSoftAssert csa;
    protected WebDriver driver;
    Actions act;

    public BasePage() {
        this.driver = BaseTest.driverThread.get();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
        this.csa = new CustomSoftAssert();
        this.act = new Actions(this.driver);
    }

    public void waitForElementAvailable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

    protected String getText(WebElement element) {
        waitForElementAvailable(element);
        return element.getText();
    }

    public void scrollToEndPage() {
        ((JavascriptExecutor) this.driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUpToPage() {
        ((JavascriptExecutor) this.driver)
                .executeScript("window.scrollBy(0,-350)", "");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) this.driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void doubleClickElement(WebElement element) {
        waitForElementAvailable(element);
        act.doubleClick(element).perform();
    }

    protected void rightClickElement(WebElement element) {
        waitForElementAvailable(element);
        act.contextClick(element).perform();
    }

    protected void hoverOnElement(WebElement element) {
        waitForElementAvailable(element);
        act.moveToElement(element).perform();
    }

    protected void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
        waitForElementAvailable(sourceElement);
        act.clickAndHold(sourceElement).moveToElement(targetElement).release(targetElement)
                .build().perform();
    }

    protected String getAttribute(WebElement element, String attribute) {
        waitForElementAvailable(element);
        return element.getAttribute(attribute);
    }

    protected void switchToWindow() {
        for (String windowhandle : this.driver.getWindowHandles()) {
            this.driver.switchTo().window(windowhandle);
        }
    }

    protected void selectItemDropdown(WebElement element, String text) {
        waitForElementAvailable(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}
