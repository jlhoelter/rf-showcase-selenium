package de.codecentric.rfselenium.basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FirstTest {
	
	WebDriver driver;
	
	@Before
	public void init(){
		driver = initDriver();
	}

	@Test
	public void checkShowcaseIsRunning(){
		navigateToBaseUrl(driver);
		String expectedWelcomeText = "Welcome To RichFaces 4.x Demo";
		assertThatWelcomeTextMatches(expectedWelcomeText);
	}

	private void assertThatWelcomeTextMatches(String expectedWelcomeText) {
		//TODO: Willkommenstext auslesen		
		//TODO: Text überprüfen
	}

	private void navigateToBaseUrl(WebDriver driver) {
		// TODO
	}

	WebDriver initDriver() {
		// TODO 
		return null;
	}

	@After
	public void tearDownWebDriver(){
		// TODO
	}
}
