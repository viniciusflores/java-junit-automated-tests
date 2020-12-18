package zchat.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import zchat.test.GooglePageTest;
import zchat.test.HomePageTest;

@RunWith(Suite.class)
@SuiteClasses({ HomePageTest.class, GooglePageTest.class })
public class SuiteGeral {

}
