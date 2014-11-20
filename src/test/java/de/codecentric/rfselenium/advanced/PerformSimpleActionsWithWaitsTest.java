package de.codecentric.rfselenium.advanced;

import static de.codecentric.rfselenium.util.StaticHelper.BASE_URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PerformSimpleActionsWithWaitsTest {
	
	WebDriver driver;
	
	@Before
	public void init(){
		driver = new FirefoxDriver();
		driver.get(BASE_URL);
	}

	@Test
	public void testUseSimpleCommandButton(){
		openCommandButtonSection();
		String myName = "Jan";
		enterInInputField(myName);
		submit();
		assertOutputTextIs("Hello "+myName+" !");		
	}

	private void assertOutputTextIs(String expected) {
		// Prüfen mit Explicit Wait
	}

	private void submit() {
		
	}

	private void enterInInputField(String text) {
		
	}


	private void openCommandButtonSection() {
		assertTabExistsWithCaption("Command Button Simple");
	}

	private void assertTabExistsWithCaption(String caption) {
		// Prüfen mit Explicit Wait
	}

	@After
	public void tearDownWebDriver(){
		driver.quit();
	}

}
