package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    private final WebDriver driver;

    @FindBy(css = "[ng-click='addCust()']")
    private WebElement addCustomerButton;


    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажали на кнопку добавления клиента")
    public CustomerRequisitesPage clickAddCustomerButton() {
        Waiters.waitForVisibility(5, driver,addCustomerButton);
        addCustomerButton.click();
        return new CustomerRequisitesPage(driver);
    }
}
