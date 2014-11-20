package de.codecentric.rfselenium.basics;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DifferentSelectorsTest {
	
	private WebDriver driver;
	
	private static final String[] EXPECTED_NAVIGATION_ITEMS = new String[]{"a4j:ajax", "a4j:commandButton", "a4j:commandLink", "a4j:actionListener", "a4j:jsFunction", "a4j:poll", "a4j:push", "a4j:param"};
	private static final int EXPECTED_LENGTH = EXPECTED_NAVIGATION_ITEMS.length;
	
	@Before
	public void init(){
		//TODO: WebDriver initialisieren, Showcase URL aufrufen
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
		// TODO: Texte aller Navigationslinks aus dem Bereich "Ajax Action" über Id ermitteln
		return new String[]{};
	}
	
	private String[] getAjaxActionSectionValuesByCssClass() {
		// TODO: Texte aller Navigationslinks aus dem Bereich "Ajax Action" über CSS Klasse ermitteln
		return new String[]{};
	}
	
	private String[] getAjaxActionSectionValuesByCssSelector() {
		// TODO: Texte aller Navigationslinks aus dem Bereich "Ajax Action" über CSS Selektor ermitteln
		return new String[]{};
	}
	
	
	private void assertExpectedValueArrayMatches(String[] actualValueArray){
		Assert.assertThat(actualValueArray.length, is(EXPECTED_LENGTH));
		Assert.assertThat(actualValueArray, equalTo(EXPECTED_NAVIGATION_ITEMS));
	}
	
	@After
	public void shutdown(){
		//TODO Webdriver beenden
	}

}
