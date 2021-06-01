package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHook {
	
	private WebDriver driver;
	private DriverFactory driverFactory;

	@Before(order = 0)
	public void getProperty() {
		ConfigReader configReader = new ConfigReader();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = ConfigReader.getBrowser();

		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario s) {
		if (s.isFailed()) {
			// Take Screenshot
			String screenshotName = s.getName().replaceAll(" ", "_");
			byte[] screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			s.attach(screenshotPath, "image/png", screenshotName);
		}
	}
}
