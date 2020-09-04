package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void brokenLinkTest() {
     this.driver.get("https://the-internet.herokuapp.com/broken_images");
     this.driver.findElements(By.xpath("//*[@src]"))
             .stream()
             .map(e -> e.getAttribute("src"))
            /* .map(src -> LinkUtil.getResponseCode(src))*/
             .forEach(src -> {
                 System.out.println(LinkUtil.getResponseCode(src) + "::" + src);
             });
    }

    @Test
    public void brokenLinkTest1() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        boolean result = this.driver.findElements(By.xpath("//*[@src]"))
                                .stream()
                                .map(e -> e.getAttribute("src"))
                                .map(src -> LinkUtil.getResponseCode(src))
                                .anyMatch(rc -> rc != 200);
        Assert.assertFalse(result);
    }

    @Test
    public void brokenLinkTest2() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        List<String> list =
                        this.driver.findElements(By.xpath("//*[@src]"))
                            .stream().parallel()
                            .map(e -> e.getAttribute("src"))
                            .filter(src -> LinkUtil.getResponseCode(src) != 200)
                            .collect(Collectors.toList());
        Assert.assertEquals(list.size(), 0, list.toString());

    }

    @AfterTest
    public void afterTest() {
        this.driver.quit();
    }




}
