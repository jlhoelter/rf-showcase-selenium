package de.codecentric.rfselenium.testsuite;

import static org.openqa.selenium.remote.DesiredCapabilities.firefox;
import static org.openqa.selenium.remote.DesiredCapabilities.internetExplorer;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Kapselt die Erzeugung verschiedener WebDriver-Browser-Implementierungen
 */
public class DriverFactory {
	
	private static final String SELENIUM_HUB_ADRESS = "http://localhost:4444/wd/hub";

	public static final WebDriver getConfiguredDriver() {
		Browser browser = SeleniumConfiguration.getBrowser();
		switch (browser) {
			case IE:
				return ieDriver();
			case FIREFOX:
				return installedFirefoxDriver();
			case HTMLUNIT:
				return htmlUnitDriver();
			case REMOTE_FIREFOX:
				return firefoxRemoteDriver();
			case REMOTE_IE:
				return ieRemoteDriver();
		}
		throw new RuntimeException("browser '" + browser + "' not expected");
	}
	

	private static WebDriver htmlUnitDriver() {
		return new HtmlUnitDriver(DesiredCapabilities.htmlUnitWithJs());
	}

	private static RemoteWebDriver firefoxRemoteDriver(){
		return getRemoteDriverFor(firefox());
	}
	
	private static RemoteWebDriver ieRemoteDriver(){
		return getRemoteDriverFor(internetExplorer());
	}


	private static RemoteWebDriver getRemoteDriverFor(
			DesiredCapabilities capabilities) {
		try {
			return new RemoteWebDriver(new URL(SELENIUM_HUB_ADRESS),capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Unable to reach Selenium Grid Hub at "+SELENIUM_HUB_ADRESS);
		}
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
