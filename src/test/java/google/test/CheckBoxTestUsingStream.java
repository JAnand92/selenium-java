package google.test;

import baseTest.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import streamdemo.pages.DataTablePage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxTestUsingStream extends BaseTest {

    DataTablePage dataTablePage;

    @Test
    public void checkboxTest() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");

        List<WebElement> list = this.driver.findElements(By.tagName("input"));

        list.stream()
                .forEach(element -> element.click());
    }

    @Test(dataProvider = "gender")
    public void checkboxBasedOnGenderTest(String gender) {
        dataTablePage =  new DataTablePage(driver);
        dataTablePage.goTo();
        dataTablePage.testRows(gender);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "criteriaProvider")
    public void checkboxBasedOnGenderTest1(Predicate<List<WebElement>> searchCriteria) {
        dataTablePage =  new DataTablePage(driver);
        dataTablePage.goTo();
        dataTablePage.testRows(searchCriteria);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @DataProvider(name = "gender")
    public Object[] testData() {
        return new Object[] {
                "male",
                "female"
        };
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] genericTestData() {
        return new Object[] {
                SearchCriteriaFactory.getCriteria("male"),
                SearchCriteriaFactory.getCriteria("female"),
                SearchCriteriaFactory.getCriteria("allGender"),
                SearchCriteriaFactory.getCriteria("countryAU"),
                SearchCriteriaFactory.getCriteria("allFemaleAU")
        };
    }
}
