package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRequisitesPage {

    private final WebDriver driver;

    @FindBy(css = "[placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(css = "[placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(css = "[placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(css = "[type='submit']")
    private WebElement addCustomerButton;

    @FindBy(css = "[ng-click='showCust()']")
    private WebElement customersListButton;

    public CustomerRequisitesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Вставили {firstName} в поле ввода имени")
    public CustomerRequisitesPage inputFirstName(String firstName) {
        Waiters.waitForVisibility(20,driver,firstNameField);
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Вставили {lastName} в поле ввода фамилии ")
    public CustomerRequisitesPage inputLastName(String lastName) {
        Waiters.waitForVisibility(20,driver,lastNameField);
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Вставили {postCode} в поле ввода почтового кода")
    public CustomerRequisitesPage inputPostCode(String postCode) {
        Waiters.waitForVisibility(20,driver,postCodeField);
        postCodeField.sendKeys(postCode);
        return this;
    }

    @Step("Нажали кнопку добавления клиента")
    public CustomerRequisitesPage clickAddCustomerButton() {
        Waiters.waitForVisibility(20,driver,addCustomerButton);
        addCustomerButton.click();
        return this;
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Step("Перешли на вкладку списка клиентов")
    public CustomersListPage clickCustomersListButton() {
        Waiters.waitForVisibility(20,driver,customersListButton);
        customersListButton.click();
        return new CustomersListPage(driver);

    }
}
