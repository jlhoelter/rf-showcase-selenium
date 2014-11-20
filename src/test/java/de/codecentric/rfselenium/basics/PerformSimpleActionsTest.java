package de.codecentric.rfselenium.basics;

import static de.codecentric.rfselenium.util.StaticHelper.BASE_URL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformSimpleActionsTest {
	
	WebDriver driver;
	
	@Before
	public void init(){
		driver = initDriver();
		driver.get(BASE_URL);
	}

	@Test
	public void testUseSimpleCommandButton(){
		openCommandButtonSection();
		String myName = "Your Name...";
		enterInInputField(myName);
		submit();
		assertOutputTextIs("Hello "+myName+" !");		
	}

	private void assertOutputTextIs(String expected) {
		// Die Grußfromel prüfen		
	}

	private void submit() {
		// Submitbutton klicken/ Formular submitten
	}

	private void enterInInputField(String text) {

	}


	private void openCommandButtonSection() {
		// TODO: Menüpunkt Ajax Action -> a4j:commandButton anklicken
		assertTabExistsWithCaption("Command Button Simple");
	}

	private void assertTabExistsWithCaption(String caption) {
		//TODO Tabüberschrift im Command Button Bereich ermitteln und überprüfen
	}

	WebDriver initDriver() {
		//TODO
		return null;
	}

	@After
	public void tearDownWebDriver(){
		//TODO
	}

}
