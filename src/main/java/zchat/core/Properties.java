package zchat.core;

public class Properties implements IProperties {
    public static final String REGION = String.valueOf(region.PT);
    public static final String RUNNER = String.valueOf(runner.LOCAL);
    public static final String BROWSER = String.valueOf(browser.CHROME);
    public static final String BROWSER_VERSION = "80";
    public static final String OS = "WINDOWS";
    public static final String OS_VERSION = "10";
    public static final String RESOLUTION = "1280x800";
    public static final String USERNAME_BS = "vinicius115";
    public static final String ACCESSKEY_BS = "WqwCdys6pvCayLgh4hHy";
    public static final String BROWSERSTACK_REMOTE_URL = "https://" + USERNAME_BS + ":" + ACCESSKEY_BS
	    + "@hub-cloud.browserstack.com/wd/hub";
    public static final String USERNAME_SAUCELABS = "viniciusflores";
    public static final String ACCESSKEY_SAUCELABS = "89444b6f-566b-44a0-9937-b9b4a6d472d1";
    public static final String SAUCELABS_REMOTE_URL = "https://" + USERNAME_SAUCELABS + ":" + ACCESSKEY_SAUCELABS
	    + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public static final String USERNAME_LAMBDATEST = "vinicius.flores";
    public static final String ACCESSKEY_LAMBDATEST = "5WXX7gwz7Pzn5Ivxiqequ10BlsYFFAojoojZTldNYXFHcMbYqE";
    public static final String LAMBDATEST_REMOTE_URL = "https://" + USERNAME_LAMBDATEST + ":" + ACCESSKEY_LAMBDATEST
	    + "@hub.lambdatest.com/wd/hub";
    public static final String SELENIUM_GRID_URL = "http://10.0.2.15:4444/wd/hub";

    private enum region {
	PT, ES, EN
    }

    private enum runner {
	LOCAL, GRID, BROWSERSTACK, SAUCELABS, LAMBDATEST
    }

    private enum browser {
	CHROME, FIREFOX, SAFARI, IE, EDGE
    }
}
