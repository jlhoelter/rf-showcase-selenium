package de.codecentric.rfselenium.basics;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DifferentSelectorsTest {
	
	private static final String BASE_URL = "http://localhost:8080/showcase";
	private WebDriver driver;
	
	private static final String[] EXPECTED_VALUES = new String[]{"a4j:ajax", "a4j:commandButton", "a4j:commandLink", "a4j:actionListener", "a4j:jsFunction", "a4j:poll", "a4j:push", "a4j:param"};
	private static final int EXPECTED_LENGTH = EXPECTED_VALUES.length;
	
	@Before
	public void init(){
		driver = initDriver();
		driver.get(BASE_URL);
	}
	
	@Test
	public void testValuesById(){
		assertExpectedValueArrayMatches(getAjaxActionSectionValuesById());
	}
	
	@Test
	public void testValuesByCssClass(){
		assertExpectedValueArrayMatches(getAjaxActionSectionValuesByCssClass());
	}
	
	@Test
	public void testValuesByCssSelektor(){
		assertExpectedValueArrayMatches(getAjaxActionSectionValuesByCssSelector());
	}
	

	private String[] getAjaxActionSectionValuesById() {
		return driver.findElement(By.id("j_idt20:cnt")).getText().split("\n");
	}
	
	private String[] getAjaxActionSectionValuesByCssClass() {
		return textsFrom(driver.findElements(By.className("rf-pm-itm-lbl")));
	}
	
	private String[] getAjaxActionSectionValuesByCssSelector() {
		return textsFrom(driver.findElements(By.cssSelector(".rf-pm-top-gr-cnt .rf-pm-itm-lbl")));
	}
	
	
	private String[] textsFrom(List<WebElement> elements){
		ArrayList<String> texts = new ArrayList<String>();
		for(WebElement element : elements){
			if(element.isDisplayed()){
				texts.add(element.getText());
			}
		}
		
		return texts.toArray(new String[texts.size()]);
	}
	
	private void assertExpectedValueArrayMatches(String[] actualValueArray){
		Assert.assertThat(actualValueArray.length, is(EXPECTED_LENGTH));
		Assert.assertThat(actualValueArray, equalTo(EXPECTED_VALUES));
	}
	
	WebDriver initDriver() {
		return new FirefoxDriver();
	}

	@After
	public void tearDownWebDriver(){
		driver.close();
	}

}
