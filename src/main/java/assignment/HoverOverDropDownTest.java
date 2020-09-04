package assignment;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HoverOverDropDownTest {

    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    public void setup() {
        Path path = Paths.get("resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());
        this.driver = new ChromeDriver();
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        this.driver.manage().window().maximize();
        this.actions = new Actions(driver);
    }

    @Test(dataProvider = "linkProvider")
    public void hoverOverDropDownTest(String path) {
        String[] split = path.split("=>");
        Arrays.stream(split)
                .map(s -> s.trim())
                .map(s -> By.linkText(s))
                .map(by -> driver.findElement(by))
                .map(ele -> actions.moveToElement(ele))
                .forEach(a -> a.perform());
    }

    @DataProvider(name = "linkProvider")
    public Object[] testData() {
        return new Object[] {
                "Dropdown => Dropdown Link 2",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2",
        };
    }

    @AfterTest
    public void teardown() {
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        this.driver.quit();
    }
}
