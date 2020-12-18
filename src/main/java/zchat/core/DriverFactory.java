package zchat.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    /*
     * private static String REGION; private static String RUNNER; private static
     * String BROWSER; private static String BROWSER_VERSION; private static String
     * OS; private static String OS_VERSION; private static String RESOLUTION;
     * private static String USERNAME_BS; private static String ACCESSKEY_BS;
     * private static String BROWSERSTACK_REMOTE_URL; private static String
     * USERNAME_SAUCELABS; private static String ACCESSKEY_SAUCELABS; private static
     * String SAUCELABS_REMOTE_URL; private static String USERNAME_LAMBDATEST;
     * private static String ACCESSKEY_LAMBDATEST; private static String
     * LAMBDATEST_REMOTE_URL; private static String SELENIUM_GRID_URL;
     */

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
	@Override
	protected synchronized WebDriver initialValue() {
	    return initDriver();
	}
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
	return threadDriver.get();
    }

    public static WebDriver initDriver() {
	WebDriver driver = null;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();

	// DesiredCapabilities options = new DesiredCapabilities();
	/* initFields(); */
	/*
	 * switch (RUNNER) { case "LOCAL": switch (BROWSER) { case "CHROME": driver =
	 * createLocalChromeDriver(driver, options); break; case "FIREFOX": driver =
	 * createLocalFirefoxDriver(driver, options); break; default: break; } case
	 * "BROWSERSTACK": driver = createBrowserstackDriver(driver, options); break;
	 * default: break; }
	 */
	return driver;
    }

    /*
     * public static void initFields() { REGION = System.getProperty("REGION",
     * Properties.REGION); RUNNER = System.getProperty("RUNNER", Properties.RUNNER);
     * BROWSER = System.getProperty("BROWSER", Properties.BROWSER); BROWSER_VERSION
     * = System.getProperty("BROWSER_VERSION", Properties.BROWSER_VERSION); OS =
     * System.getProperty("OS", Properties.OS); OS_VERSION =
     * System.getProperty("OS_VERSION", Properties.OS_VERSION); RESOLUTION =
     * System.getProperty("RESOLUTION", Properties.RESOLUTION); USERNAME_BS =
     * System.getProperty("USERNAME_BS", Properties.USERNAME_BS); ACCESSKEY_BS =
     * System.getProperty("ACCESSKEY_BS", Properties.ACCESSKEY_BS);
     * BROWSERSTACK_REMOTE_URL = System.getProperty("BROWSERSTACK_REMOTE_URL",
     * Properties.BROWSERSTACK_REMOTE_URL); USERNAME_SAUCELABS =
     * System.getProperty("USERNAME_SAUCELABS", Properties.USERNAME_SAUCELABS);
     * ACCESSKEY_SAUCELABS = System.getProperty("ACCESSKEY_SAUCELABS",
     * Properties.ACCESSKEY_SAUCELABS); SAUCELABS_REMOTE_URL =
     * System.getProperty("SAUCELABS_REMOTE_URL", Properties.SAUCELABS_REMOTE_URL);
     * USERNAME_LAMBDATEST = System.getProperty("USERNAME_LAMBDATEST",
     * Properties.USERNAME_LAMBDATEST); ACCESSKEY_LAMBDATEST =
     * System.getProperty("ACCESSKEY_LAMBDATEST", Properties.ACCESSKEY_LAMBDATEST);
     * LAMBDATEST_REMOTE_URL = System.getProperty("LAMBDATEST_REMOTE_URL",
     * Properties.LAMBDATEST_REMOTE_URL); SELENIUM_GRID_URL =
     * System.getProperty("SELENIUM_GRID_URL", Properties.SELENIUM_GRID_URL); }
     * 
     * public static WebDriver createLocalChromeDriver(WebDriver driver,
     * DesiredCapabilities options) { options.setCapability("start-maximized", );
     * driver = new ChromeDriver(options); driver.manage().window().maximize();
     * return driver; }
     * 
     * public static WebDriver createLocalFirefoxDriver(WebDriver driver,
     * DesiredCapabilities options) { WebDriverManager.firefoxdriver().setup();
     * 
     * 
     * options.getCapability("start-maximized");
     * 
     * driver = new FirefoxDriver(options); driver.manage().window().maximize();
     * return driver; }
     * 
     * public static WebDriver createBrowserstackDriver(WebDriver driver,
     * DesiredCapabilities options) {
     * 
     * options.setCapability("browserName", "Chrome");
     * options.setCapability("browserVersion", "80"); options.setCapability("os",
     * "Windows"); options.setCapability("os_version", "10");
     * options.setCapability("resolution", "1920x1200"); // driver = new
     * RemoteWebDriver(new URL("123112.com"), options);
     * 
     * return driver; }
     */

    public static void killDriver() {
	WebDriver driver = getDriver();
	if (driver != null) {
	    driver.quit();
	    driver = null;
	}
	if (threadDriver != null) {
	    threadDriver.remove();
	}
    }
}
