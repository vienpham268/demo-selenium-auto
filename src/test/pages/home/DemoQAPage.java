package pages.home;

import enums.Option;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class DemoQAPage extends BasePage {
    @FindBy(xpath = "//button[@id='toolTipButton']")
    WebElement btnTooltip;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    WebElement tooltip;

    @FindBy(xpath = "//div[@id='draggable']")
    WebElement draggable;

    @FindBy(xpath = "//div[@id='droppable']")
    WebElement droppable;

    @FindBy(xpath = "//button[@id='windowButton']")
    WebElement btnNewWindow;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement titleh1;

    @FindBy(xpath = "//iframe[@id='frame2']")
    WebElement frame2;

    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    WebElement select;

    @FindBy(xpath = "//select[@id='cars']")
    WebElement select2;

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement select3;


    public DemoQAPage() {
        PageFactory.initElements(driver, this);
    }

    public void hoverOnTooltip() {
        hoverOnElement(btnTooltip);
    }

    public void verifyTooltip() {
        getCsa().assertEquals(getText(tooltip), "You hovered over the Button");
    }

    public void dragAndDrop() {
        dragAndDropElement(draggable, droppable);
    }

    public void switchToNewWindowTab() {
        clickToElement(btnNewWindow);
        switchToWindow();
        getCsa().assertEquals(driver.getCurrentUrl(), "https://demoqa.com/sample");
        System.out.println("Window URL:" + driver.getCurrentUrl());
    }

    public void switchToIFrame() {
        scrollToElement(frame2);
        driver.switchTo().frame("frame2");
        doubleClickElement(titleh1);
        getCsa().assertEquals(getText(titleh1), "This is a sample page");
    }

    public void selectItem(Option option) {
        selectItemDropdown(select3, option.getName());
        getCsa().assertEquals(getAttribute(select3, "value"), option.getValue());
    }
}
