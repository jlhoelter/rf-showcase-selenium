package de.codecentric.rfselenium.basics;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FistTestWithIE extends FirstTest {

	private static final String BASE_URL = "http://localhost:8080/showcase";
	private WebDriver driver;
	
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
		String welcomeText = driver.findElement(By.className("content-container")).getText();
		Assert.assertThat(welcomeText, equalTo(expectedWelcomeText));
	}

	private void navigateToBaseUrl(WebDriver driver) {
		driver.get(BASE_URL);
	}

	private WebDriver initDriver() {
		return new InternetExplorerDriver();
	}

	@After
	public void tearDownWebDriver(){
		driver.close();
	}
	
}
