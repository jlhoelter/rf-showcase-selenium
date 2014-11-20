package de.codecentric.rfselenium.advanced;

import static de.codecentric.rfselenium.util.StaticHelper.BASE_URL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {

	private WebDriver driver;
	
	@ Before
	public void initDriver(){
		// Driver mit implizitem Warten initialisieren
	}
	
	@Test
	public void dragFromSourceAndDropToPHPFrameworks(){
		openDragAndDropSection();
		dragAndDropFirstElementToPHPFrameworks();
		
		// Prüfen, dass die Liste der PHP Frameworks nun einen Eintrag enthält
	}


	private void dragAndDropFirstElementToPHPFrameworks() {
		/* 
		 * Erstes Element aus der Auswahlliste nehmen und per Drag and Drop auf
		 * die Liste der PHP Frameworks ziehen 
		 */
		
		
	}


	private void openDragAndDropSection() {
		// Drag and Drop Bereich öffnen
		// Prüfen, ob der Bereich geöffnet wurde
	}


	
	@After
	public void shutdown(){
		driver.quit();
	}

}
