package de.codecentric.rfselenium.advanced;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import sun.text.normalizer.CharTrie.FriendAgent;

public class PerformSimpleActionsWithWaitsTest {
	
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement helloLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("outhello")));
		assertThat(helloLabel.getText(), equalTo(expected));
	}

	private void submit() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	private void enterInInputField(String text) {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(text);
	}


	private void openCommandButtonSection() {
		driver.findElement(By.id("j_idt22")).click();
//		assertTabExistsWithCaption("Command Button Simple");
	}

	private void assertTabExistsWithCaption(String caption) {
		Assert.assertThat(driver.findElement(By.cssSelector(".rf-tab-hdr-tabs .rf-tab-lbl")).getText(),CoreMatchers.equalTo(caption));
	}

	WebDriver initDriver() {
		return new FirefoxDriver();
	}

	@After
	public void tearDownWebDriver(){
		driver.close();
	}

}