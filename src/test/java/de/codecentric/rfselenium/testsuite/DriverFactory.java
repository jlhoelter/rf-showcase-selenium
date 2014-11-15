package de.codecentric.rfselenium.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Kapselt die Erzeugung verschiedener WebDriver-Browser-Implementierungen
 */
public class DriverFactory {
	
	public static final WebDriver getConfiguredDriver() {
		Browser browser = SeleniumConfiguration.getBrowser();
		switch (browser) {
			case IE:
				return ieDriver();
			case FIREFOX:
				return installedFirefoxDriver();
			case HTMLUNIT:
				return htmlUnitDriver();
		}
		
		throw new RuntimeException("browser '" + browser + "' not expected");
	}
	

	private static WebDriver htmlUnitDriver() {
		return new HtmlUnitDriver(DesiredCapabilities.htmlUnitWithJs());
	}


	private static FirefoxDriver installedFirefoxDriver() {
		return new FirefoxDriver(firefoxCapabilities());
	}

	private static DesiredCapabilities firefoxCapabilities() {
		DesiredCapabilities capabillities = DesiredCapabilities.firefox();
		capabillities.setJavascriptEnabled(true);
		return capabillities;
	}

	private static InternetExplorerDriver ieDriver() {
		DesiredCapabilities capabillities = DesiredCapabilities
				.internetExplorer();
		capabillities.setCapability("version", "11");
		return new InternetExplorerDriver(capabillities);
	}

}
