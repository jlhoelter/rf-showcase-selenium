package de.codecentric.rfselenium.basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PerformSimpleActionsTest {
	
	WebDriver driver;
	
	@Before
	public void init(){

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


	@After
	public void tearDownWebDriver(){
		//TODO
	}

}
