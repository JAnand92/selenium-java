package streamdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class DataTablePage {

    private final WebDriver driver;

    public DataTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    }

    public void testRows(String gender) {
        List<WebElement> list = this.driver.findElements(By.tagName("tr"));

        list.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(tdList -> tdList.size() == 4)
                .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase(gender))
                .map(tdList -> tdList.get(3))
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }

    public void testRows(Predicate<List<WebElement>> predicate) {
        List<WebElement> list = this.driver.findElements(By.tagName("tr"));

        list.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(tdList -> tdList.size() == 4)
                .filter(predicate)
                .map(tdList -> tdList.get(3))
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }
}
