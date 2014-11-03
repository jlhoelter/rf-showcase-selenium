package de.codecentric.rfselenium.basics;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PerformSimpleActionsTest {
	
	private static final String BASE_URL = "http://localhost:8080/showcase";
	WebDriver driver;
	
	@Before
	public void init(){
		driver = initDriver();
		driver.get(BASE_URL);
	}

	@Test
	public void testUseSimpleCommandButton(){
		openCommandButtonSection();
		
	}


	private void openCommandButtonSection() {
		driver.findElement(By.id("j_idt22")).click();
		assertTabExistsWithCaption("Command Button Simple");
	}

	private void assertTabExistsWithCaption(String caption) {
		Assert.assertThat(driver.findElement(By.cssSelector(".rf-tbp.navigation")).getText(),CoreMatchers.equalTo(caption));
	}

	WebDriver initDriver() {
		return new FirefoxDriver();
	}

	@After
	public void tearDownWebDriver(){
		driver.close();
	}

}
