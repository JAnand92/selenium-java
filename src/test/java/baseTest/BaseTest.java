package baseTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }
}
