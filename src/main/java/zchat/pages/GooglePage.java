package zchat.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import zchat.core.BasePage;

public class GooglePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(xpath = "//div/cite[contains(.,'www.selenium.dev')]")
    private List<WebElement> resultOfSearchSelenium;

    private String resultSelenium;

    public String getResultSelenium() {
	return resultSelenium;
    }

    public GooglePage(WebDriver driver) {
	super(driver);
    }

    public boolean isInitialized() {
	return searchField.isDisplayed();
    }

    public GooglePage makeASearch(String search) {
	this.searchField.sendKeys(search);
	this.searchField.sendKeys(Keys.ENTER);
	return this;
    }

    public GooglePage verifyResultSelenium() {
	this.resultSelenium = this.resultOfSearchSelenium.get(0).getText();
	return this;
    }

    public String getTitle() {
	return driver.getTitle();
    }

}
