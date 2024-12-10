package pages.home;

import enums.Option;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.io.File;

@Slf4j
public class DemoQAPage extends BasePage {
    private static final Logger logger = Logger.getLogger(DemoQAPage.class);

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

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement btnAlert;

    @FindBy(xpath = "//p[@id='result']")
    WebElement result;

    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement btnChooseFile;

    @FindBy(id = "file-submit")
    WebElement btnUpload;

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
        log.info("");
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

    public void doAlert() {
        doubleClickElement(btnAlert);
        inputAndAcceptAlert("hello world ^^!!!");
        getCsa().assertEquals(getText(result), "You entered: hello world ^^!!!");
        System.out.println(getText(result));

        doubleClickElement(btnAlert);
        cancelAlert();
        getCsa().assertEquals(getText(result), "You entered: null");
        System.out.println(getText(result));
    }

    public void fileUploader(String path) {
        File f = new File(path);
        sendTextToElement(btnChooseFile, f.getAbsolutePath());
        clickToElement(btnUpload);
        log.info("Uploaded file!");
    }
}
