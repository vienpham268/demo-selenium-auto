package pages.register;

import dto.RegisterPaidTraining;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//a[@class='btn btn-primary-shadow btn-block']")
    WebElement enrollBtn;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement iptFirstname;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement iptLastname;

    @FindBy(xpath = "//input[@id='city']")
    WebElement iptcity;

    @FindBy(xpath = "//select[@name='country']")
    WebElement iptcountry;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement iptmessage;

    @FindBy(xpath = "//input[@id='email']")
    WebElement iptemail;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Perform register")
    public void performRegister(RegisterPaidTraining register) {
        clickToElement(enrollBtn);
        scrollUpToPage();
        inputFirstName(register.getFirstName());
        verifyFirstName(register.getFirstName());
        inputLastName(register.getLastName());
        verifyLastName(register.getLastName());
        inputEmail(register.getEmail());
        verifyEmail(register.getEmail());
        inputCity(register.getCity());
        inputCountry(register.getCountry());
        inputMessage(register.getMessage());
    }

    @Step("Verify form after submitted")
    public void verifyFormAfterSubmitted(RegisterPaidTraining register) {
        verifyFirstName(register.getFirstName());
    }

    @Step("Verify lastname")
    private void verifyLastName(String lastName) {
        getCsa().assertEquals(getAttribute(iptLastname, "value"), lastName);
    }

    @Step("Verify firstName")
    private void verifyFirstName(String firstName) {
        getCsa().assertEquals(getAttribute(iptFirstname, "value"), firstName);
    }

    @Step("Verify email")
    private void verifyEmail(String email) {
        getCsa().assertEquals(getAttribute(iptemail, "value"), email);
    }

    @Step("Input first name")
    private void inputFirstName(String firstName) {
        sendTextToElement(iptFirstname, firstName);
    }

    @Step("Input last name")
    private void inputLastName(String lastName) {
        sendTextToElement(iptLastname, lastName);
    }

    @Step("Input city")
    private void inputCity(String city) {
        sendTextToElement(iptcity, city);
    }

    @Step("Input Country")
    private void inputCountry(String country) {
        sendTextToElement(iptcountry, country);
        this.iptcountry.sendKeys(Keys.ENTER);
    }

    @Step("Input message")
    private void inputMessage(String message) {
        sendTextToElement(iptmessage, message);
    }

    @Step("Input email")
    private void inputEmail(String email) {
        sendTextToElement(iptemail, email);
    }
}
