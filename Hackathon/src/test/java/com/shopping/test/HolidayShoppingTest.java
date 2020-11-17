package com.shopping.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.test.helper.GlobalVariables;
import com.test.pageobjects.MainPage;
import com.test.pageobjects.ProductDetailsPage;

public class HolidayShoppingTest {
	private EyesRunner runner;
	private Eyes eyes;
	private static WebDriver driver;
	private static BatchInfo BatchInfo = new BatchInfo("Testing Lifecycle");

	@Before
	public void beforeEach() {

		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		runner = new VisualGridRunner(1);
		eyes = new Eyes(runner);
		setUp(eyes);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void setUp(Eyes eyes) {

		Configuration config = new Configuration();
		config.setApiKey(GlobalVariables.apikey);
		config.addBrowser(1200, 800, BrowserType.CHROME);
		config.addBrowser(1200, 800, BrowserType.FIREFOX);
		config.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
		config.addBrowser(1200, 600, BrowserType.SAFARI);
		config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
		eyes.setConfiguration(config);

	}

	/* Test for Main Page */
	@Test
	public void testMainPage() throws InterruptedException {
		driver.get(GlobalVariables.applicationURL);
		MainPage mainPage = new MainPage(driver);
		mainPage.waitFor(mainPage.getMainPageMenu("HOME").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("MEN").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("WOMEN").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("RUNNING").waitUntilVisible());
		eyes.open(mainPage.getDriver(), "AppliFashion", "Test 1", null);
		eyes.setBatch(BatchInfo);
		eyes.setForceFullPageScreenshot(true);
		eyes.check(Target.window().fully().withName("main page"));
		eyes.closeAsync();
	}
	
	/* Test for Filtered Product Grid */

	@Test
	public void testFilteredProductGrid() throws InterruptedException {
		driver.get(GlobalVariables.applicationURL);
		MainPage mainPage = new MainPage(driver);
		mainPage.waitFor(mainPage.getMainPageMenu("HOME").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("MEN").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("WOMEN").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("RUNNING").waitUntilVisible());
		eyes.open(mainPage.getDriver(), "AppliFashion", "Test 2", null);
		eyes.setBatch(BatchInfo);
		eyes.setForceFullPageScreenshot(true);
		mainPage.waitFor(mainPage.getBackColorFilter());
		mainPage.getBackColorFilter().click();
		mainPage.waitFor(mainPage.getMainPageButtons("Filter"));
		mainPage.getMainPageButtons("Filter").click();
		mainPage.waitFor(mainPage.getProductGrid());
		eyes.checkRegion(mainPage.getProductGrid(), 30000, "filter by color");
		eyes.closeAsync();
	}
	
	/* Test for Product Details */
	
	@Test
	public void testProductDetails() throws InterruptedException {
		driver.get(GlobalVariables.applicationURL);
		MainPage mainPage = new MainPage(driver);
		mainPage.waitFor(mainPage.getMainPageMenu("HOME").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("MEN").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("WOMEN").waitUntilVisible());
		mainPage.waitFor(mainPage.getMainPageMenu("RUNNING").waitUntilVisible());
		eyes.open(mainPage.getDriver(), "AppliFashion", "Test 3", null);
		eyes.setBatch(BatchInfo);
		eyes.setForceFullPageScreenshot(true);
		mainPage.waitFor(mainPage.getMainPageProduct("Appli Air x Night"));
		mainPage.getMainPageProduct("Appli Air x Night").click();		
		ProductDetailsPage ProductDetailsPage = new ProductDetailsPage(driver);
		ProductDetailsPage.waitFor(ProductDetailsPage.getProductName("Appli Air x Night"));
		eyes.check(Target.window().fully().withName("product details"));
		eyes.closeAsync();
	}

	@After
	public void tearDown() {
		driver.quit();
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);
	}
}
