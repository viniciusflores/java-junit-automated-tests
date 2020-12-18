package zchat.test;

import static org.junit.Assert.assertEquals;
import static zchat.core.DriverFactory.getDriver;

import org.junit.Test;

import zchat.core.BaseTest;
import zchat.pages.GooglePage;

public class GooglePageTest extends BaseTest {
    @Test
    public void googleSearch() {
	getDriver().get("https://www.google.com/");
	GooglePage page = new GooglePage(getDriver());
	String result = page.makeASearch("webdriver").verifyResultSelenium().getResultSelenium();
	assertEquals("www.selenium.dev › documentation", result);

    }
}
