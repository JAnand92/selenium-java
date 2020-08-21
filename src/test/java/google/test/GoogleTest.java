package google.test;

import baseTest.BaseTest;
import google.main.GoogleMainPage;
import google.result.GoogleResultPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @Before
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test
    public void googleWorkflow() {

        String keyword = "Selenium Webdriver";
        int index = 4;

        googleMainPage.goTo("https://www.google.com/");
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        System.out.println(
                googleResultPage.getResultStat().getStats()
        );

    }

    /*@DataProvider
    public Object[][] getData() {

        return new Object[][] {
                {"selenium", 3},
                {"docker", 2}
        };
    }*/
}
