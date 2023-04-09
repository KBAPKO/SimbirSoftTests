package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomerRequisitesPage;
import pages.CustomersListPage;

public class TestSearchCustomer extends BaseTest {


    public static final String firstName = "Draco";
    public static final String lastName = "Malfoy";
    public static final String postCode = "E01337";

    CustomerRequisitesPage fillFields(){
        new AddCustomerPage(driver).clickAddCustomerButton()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputPostCode(postCode);
        return new CustomerRequisitesPage(driver);
    }
    private void deleteCreatedCustomer(String firstName) {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
        new CustomersListPage(driver).inputNameToFind(firstName).deleteCustomer();
    }
    private final String[] namesOfCustomers = {"Albus", "Ron"};
    @Test(description = "Проверка работы поиска клиента")
    public void searchCustomerTest(){
        CustomersListPage customersListPage = new CustomersListPage(driver);
        fillFields().clickAddCustomerButton();
        driver.switchTo().alert().accept();
        new CustomerRequisitesPage(driver).clickCustomersListButton()
                .inputNameToFind(namesOfCustomers[0]);

        Assert.assertEquals(customersListPage.getCustomerCount(),1);
        Assert.assertEquals(customersListPage.getFirstCustomerName(),namesOfCustomers[0]);

        deleteCreatedCustomer(namesOfCustomers[0]);
    }

}
