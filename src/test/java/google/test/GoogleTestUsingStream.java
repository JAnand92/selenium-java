package google.test;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTestUsingStream extends BaseTest {

    /*Do not allow blank link
     * do not allow links containing s
     * convert link text to upper case
     * print on the console*/

   @Test
    public void googleTest() {
       this.driver.get("https://www.google.com/");

       List<WebElement> list = this.driver.findElements(By.tagName("a"));

       /*One Way*/
       list.stream()
               .filter(e -> e.getText().trim().length() > 0)
               .filter(e -> !e.getText().contains("s"))
               .map(e -> e.getText().toUpperCase())
               .forEach(e -> System.out.println(e));


       /*Another way*/
       list.stream()
               .map(element -> element.getText())
               .map(String::trim)
               .filter(s -> s.length() > 0)
               .filter(s -> !s.contains("s"))
               .map(String::toUpperCase)
               .forEach(s -> System.out.println(s));
   }
}
