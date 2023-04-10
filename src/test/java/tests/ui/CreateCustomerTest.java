package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomerRequisitesPage;
import pages.CustomersListPage;

public class CreateCustomerTest extends BaseTest {


    private static final String firstName = "Draco";
    private static final String lastName = "Malfoy";
    private static final String postCode = "E01337";

    protected CustomerRequisitesPage fillFields(){
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

    @Test(description = "Проверка создания нового клиента")
    public void createCustomerTest() {
        fillFields().clickAddCustomerButton();

        Assert.assertTrue(new CustomerRequisitesPage(driver).getAlertText()
                .contains("Customer added successfully with customer id"));

        driver.switchTo().alert().accept();
        deleteCreatedCustomer(firstName);
    }





}
