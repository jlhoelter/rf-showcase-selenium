package de.codecentric.rfselenium.testdesign;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageObjectsTest {
	
	private WebDriver driver;
	
	@Before
	public void initDriver(){
	
	}
	
	@Test
	public void openCommandButtonSectionTest(){
		/* 
		 * Page Object f�r die linke Navigationsleiste implementieren
		 * Test:
		 * 1. Den a4j:commandButton Bereich �ffnen
		 * 2. Pr�fen, ob die Tab�berschrift angezeigt wird
		 */
	}
	
	@Test
	public void commandButtonTestFluentWithPageObjectFactory(){
		
		/*
		 * Alle n�tigen Page Objects mit Fluent API implementieren und �ber
		 * die PageFactory initialisieren.
		 * Test:
		 * 1. a4j:commandButton Bereich �ffnen
		 * 2. Namen in das Eingabefeld eingeben
		 * 3. Sumbitten
		 * 4. Ergebnis pr�fen
		 */
	}
	
	@After
	public void shutdown(){
		driver.quit();
	}

}
