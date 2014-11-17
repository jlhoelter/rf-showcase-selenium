package de.codecentric.rfselenium.testsuite;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSeleniumTest {
	
	private WebDriver driver;
	
	@Before
	public void initDriver(){
		driver = DriverFactory.getConfiguredDriver();
	}
	
	@After
	public void shutdown(){
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
