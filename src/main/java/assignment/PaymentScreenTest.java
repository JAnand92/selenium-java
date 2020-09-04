package assignment;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static assignment.PaymentScreenActions.*;

public class PaymentScreenTest {

    private WebDriver driver;
    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void setup() {
        Path path = Paths.get("resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testData() {
        return new Object[] {
                validCC.andThen(buy).andThen(successfulPurchase),
                freeCoupon.andThen(buy).andThen(successfulPurchase),
                discountedCoupon.andThen(validCC).andThen(successfulPurchase),
                invalidCC.andThen(buy).andThen(unSuccessfulPurchase),
                invalidCC.andThen(discountedCoupon).andThen(buy).andThen(unSuccessfulPurchase),
                buy.andThen(unSuccessfulPurchase)
        };
    }
    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
