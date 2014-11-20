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
		 * Page Object für die linke Navigationsleiste implementieren
		 * Test:
		 * 1. Den a4j:commandButton Bereich öffnen
		 * 2. Prüfen, ob die Tabüberschrift angezeigt wird
		 */
	}
	
	@Test
	public void commandButtonTestFluentWithPageObjectFactory(){
		
		/*
		 * Alle nötigen Page Objects mit Fluent API implementieren und über
		 * die PageFactory initialisieren.
		 * Test:
		 * 1. a4j:commandButton Bereich öffnen
		 * 2. Namen in das Eingabefeld eingeben
		 * 3. Sumbitten
		 * 4. Ergebnis prüfen
		 */
	}
	
	@After
	public void shutdown(){
		driver.quit();
	}

}
