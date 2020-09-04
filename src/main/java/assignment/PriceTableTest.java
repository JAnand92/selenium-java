package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PriceTableTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        Path chromePath = Paths.get("resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromePath.toString());
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void minPriceTest() {
        PriceTable p = new PriceTable(driver);
        p.goTo();
        p.selectMinPriceRow();
        Assert.assertEquals("PASS", p.getStatus());
    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }


}
