package de.codecentric.rfselenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FistTestWithIE extends FirstTest {

	@Override
	WebDriver initDriver() {
		return new InternetExplorerDriver();
	}

	
}
