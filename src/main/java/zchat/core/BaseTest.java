package zchat.core;

import static zchat.core.DriverFactory.getDriver;
import static zchat.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
    private String destDir = "";

    @Rule
    public final TestName testName = new TestName();

    @Rule
    public final TestRule watchman = new TestWatcher() {

	@Override
	public Statement apply(Statement base, Description description) {
	    return super.apply(base, description);
	}

	@Override
	protected void succeeded(Description description) {
	    destDir = "screenshots/Success";
	    getScreenshot(description);
	}

	@Override
	protected void failed(Throwable e, Description description) {
	    destDir = "screenshots/Failures";
	    getScreenshot(description);
	}

	@Override
	protected void skipped(AssumptionViolatedException e, Description description) {
	    destDir = "screenshots/Skipped";
	    getScreenshot(description);
	}

	@Override
	protected void starting(Description description) {
	    super.starting(description);
	}

	@Override
	protected void finished(Description description) {
	    super.finished(description);
	    killDriver();
	}
    };

    @Before
    public void initialTest() {
	System.out.println("Começou o test: " + testName.getMethodName());
    }

    @After
    public void finnalyTest() {

    }

    public void getScreenshot(Description description) {
	// To capture screenshot.
	File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

	// To create folder to store screenshots
	new File(destDir).mkdirs();

	// Set file name with combination of test class name + date time.
	String destFile = description.getDisplayName() + " - " + dateFormat.format(new Date()) + ".png";

	try {
	    // Store file at destination folder location
	    FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
