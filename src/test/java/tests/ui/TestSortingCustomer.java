package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersListPage;

public class TestSortingCustomer extends BaseTest {


    private final String[] namesOfCustomers = {"Albus", "Ron"};

    @Test(description = "Проверка сортировки клиентов")
    public void sortingCustomerTest() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
        CustomersListPage customersListPage = new CustomersListPage(driver)
                .clickSortingCustomerNameButton();

        Assert.assertEquals(customersListPage.getNameCustomerFromSortedList(), namesOfCustomers[1]);

        new CustomersListPage(driver)
                .clickSortingCustomerNameButton();

        Assert.assertEquals(customersListPage.getNameCustomerFromSortedList(), namesOfCustomers[0]);
    }
}
