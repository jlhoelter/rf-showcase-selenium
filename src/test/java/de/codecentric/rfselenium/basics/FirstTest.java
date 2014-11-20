package de.codecentric.rfselenium.basics;

import static de.codecentric.rfselenium.util.StaticHelper.BASE_URL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
		openWebsiteWith(BASE_URL);
		String expectedWelcomeText = "Welcome To RichFaces 4.x Demo";
		assertThatWelcomeTextMatches(expectedWelcomeText);
	}

	private void assertThatWelcomeTextMatches(String expectedWelcomeText) {
		String actualWelcomeText = "";
		//TODO: Willkommenstext auslesen		
		//TODO: Text überprüfen
		
		assertThat(actualWelcomeText, is(expectedWelcomeText));
	}

	private void openWebsiteWith(String baseUrl) {
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
