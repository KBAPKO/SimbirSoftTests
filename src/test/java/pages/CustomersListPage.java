package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomersListPage {
    private final WebDriver driver;

    @FindBy(css = "[ng-model='searchCustomer']")
    private WebElement searchCustomerField;

    @FindAll(@FindBy(xpath = "//tr[contains(@ng-repeat,'cust')]"))
    private List<WebElement> listOfCustomers;

    @FindBy(xpath = "//a[contains(text(),'First Name')]")
    private  WebElement sortingCustomerNameButton;

    @FindBy(xpath = ".//tr//td[1][contains(@class,'ng-binding')]")
    private WebElement nameCustomerInSortedList;

    public CustomersListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод имени клиента в поле поиска")
    public CustomersListPage inputNameToFind(String firstName) {
        Waiters.waitForVisibility(10, driver, searchCustomerField);
        searchCustomerField.sendKeys(firstName);
        return new CustomersListPage(driver);
    }

    @Step("Удалилили созданного клиента")
    public void deleteCustomer() {
        listOfCustomers.get(0)
                .findElement(By.xpath(".//button"))
                .click();
    }

    @Step("Нажали на кнопку сортировки по имени")
    public CustomersListPage clickSortingCustomerNameButton(){
        Waiters.waitForVisibility(20, driver, sortingCustomerNameButton);
        sortingCustomerNameButton.click();
        return this;
    }

    @Step("Проверили имя на совпадение")
    public String getNameCustomerFromSortedList() {
        return nameCustomerInSortedList.getText();
    }

    public int getCustomerCount() {
        return listOfCustomers.size();
    }

    public String getFirstCustomerName() {
        return listOfCustomers.get(0)
                .findElement(By.xpath(".//td"))
                .getText();
    }


}
