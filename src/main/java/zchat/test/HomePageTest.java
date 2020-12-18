package zchat.test;

import static zchat.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;

import zchat.core.BaseTest;

public class HomePageTest extends BaseTest {
    @Test
    public void accessGoogle() {
	getDriver().get("https://www.google.com/");
	String title = getDriver().getTitle();
	Assert.assertEquals("Google", title);
    }

    @Test
    public void accessFacebook() {
	getDriver().get("https://www.facebook.com/");
	String title = getDriver().getTitle();
	Assert.assertEquals("Facebook - Log In or Sign Up", title);
    }

    @Test
    public void accessAmazon() {
	getDriver().get("https://www.amazon.com.br/");
	String title = getDriver().getTitle();
	Assert.assertEquals("Amazon.com.br | Compre livros, Kindle, Echo, Fire Tv e mais.", title);
    }
}
