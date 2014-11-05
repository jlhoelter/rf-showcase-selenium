package de.codecentric.rfselenium.basics;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

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
		String myName = "Jan";
		enterInInputField(myName);
		submit();
		assertOutputTextIs("Hello "+myName+" !");		
	}

	private void assertOutputTextIs(String expected) {
//		waitSomeTime();
		String actualText = driver.findElement(By.className("outhello")).getText();
		assertThat(actualText, equalTo(expected));
	}

	private void waitSomeTime() {
		// Don't do it that way
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void submit() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	private void enterInInputField(String text) {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(text);
	}


	private void openCommandButtonSection() {
		driver.findElement(By.id("j_idt22")).click();
		assertTabExistsWithCaption("Command Button Simple");
	}

	private void assertTabExistsWithCaption(String caption) {
		Assert.assertThat(driver.findElement(By.cssSelector(".navigation .rf-tab-hdr-act .rf-tab-lbl")).getText(),CoreMatchers.equalTo(caption));
	}

	WebDriver initDriver() {
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return firefoxDriver;
	}

	@After
	public void tearDownWebDriver(){
		driver.close();
	}

}
