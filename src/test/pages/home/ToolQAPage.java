package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ToolQAPage extends BasePage {
    @FindBy(xpath = "//span[text()='Tutorials']")
    WebElement btnMenu;

    @FindBy(xpath = "//span[text()='QA Practices']")
    WebElement btnItem;

    @FindBy(xpath = "//input[@class='navbar__search--input']")
    WebElement btnSearch;

    @FindBy(xpath = "//body")
    WebElement root;

    WebElement getBtnSWTesting(String itemName) {
        return root.findElement(By.xpath(String.format("//span[text()='QA Practices']/ancestor::div//following-sibling::div[@class='second-generation']/ul/li/a[@title='%s']", itemName)));
    }

    public ToolQAPage(){
        PageFactory.initElements(driver,this);
    }

    public void accessSWTestingPage(){
        clickToElement(btnMenu);
        clickToElement(btnItem);
        clickToElement(getBtnSWTesting("Software Testing"));
    }

    public void Search(){
        sendTextToElement(btnSearch,"testing");
        btnSearch.sendKeys(Keys.ENTER);
    }
}
