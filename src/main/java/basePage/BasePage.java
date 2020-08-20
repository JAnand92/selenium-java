package basePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;
    private Alert alert;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);
    }

    /*Click Method*/
    public void click(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /*Enter Keys Method*/
    public void sendKeys(WebElement element, String value) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    /*Submit Method*/
    public void submit(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.submit();
    }

    /*Get text Method*/
    public String getText(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /*Get Tag Name Method*/
    public String getTagName(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        return element.getTagName();
    }

    /*Get Attribute Method*/
    public String getAttribute(WebElement element, String attribute) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    /*Keyboard Actions*/

    /*Click in the middle of the given element*/
    public void mouseClick(WebElement element) {

    }

    /*Clicks (without releasing) at the current mouse location*/
    public void mouseClickAndHold(WebElement element) {

    }

    /*Perform a context-click at middle of the given element.
    * First perform mouse move to the location of the element*/
    public void mouseContextClick(WebElement element) {

    }

    /*Perform the double-click at the middle of the given element*/
    public void mouseDoubleClick(WebElement element) {

    }

    /*A convenience method that performs click-and-hold at the location of the source element,
    * moves the location of the target element, then release the mouse.*/
    public void mouseDragAndDrop(WebElement source, WebElement target) {

    }

    /*A convenience method that performs click-and-hold at the location of the source element,
     * move by a given offset, then release the mouse.*/
    public void mouseDragAndDropBy(WebElement element, int xOffset, int yOffset) {
        this.wait.until(ExpectedConditions.visibilityOf(element));

    }

    /*Move the mouse to the middle of the element*/
    public void mouseMoveToElement(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        this.actions.moveToElement(element).perform();
    }

    /*Moves the mouse to an offset from top-left corner of the element*/
    public void mouseMoveToElementBy(WebElement element, int xOffset, int yOffset) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        this.actions.moveToElement(element, xOffset, yOffset).perform();
    }

    /*Release Method*/
    public void mouseRelease() {
        this.actions.release();
    }

    /*Keyboard Interactions */

    /*Perform a modifier key press*/
    public void keyDown(CharSequence key) {

    }

    /*Perform a modifier key release*/
    public void keyUp(CharSequence key) {

    }

    /*Send keys to the active element*/
    public void sendKeys(CharSequence key) {

    }

    /*Javascripts Executor*/
    public void javaClick(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        this.js = (JavascriptExecutor) driver;
        this.js.executeScript("arguments[0].click();", element);
    }

    /*Windows & Frames*/

    public void switchToWindow() {
        String originalWindow = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        if(handles.size() > 1) {
            handles.remove(originalWindow);
            String nextWindow = String.valueOf(handles.iterator().next());
            driver.switchTo().window(nextWindow);
        }
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().defaultContent();
        this.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public void switchToAlert() {
        this.alert = this.wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /*Download and Upload file test using rest-assured api*/






}
