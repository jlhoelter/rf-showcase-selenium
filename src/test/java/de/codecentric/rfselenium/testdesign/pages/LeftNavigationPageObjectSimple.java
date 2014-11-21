package de.codecentric.rfselenium.testdesign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeftNavigationPageObjectSimple {
	
	private WebDriver driver;
	private By commandButtonMenuItemSelector = By.id("j_idt22");
	private By activeTabSelector = By.cssSelector(".navigation .rf-tab-hdr-act .rf-tab-lbl");
	
	public LeftNavigationPageObjectSimple(WebDriver driver) {
		this.driver = driver;
	}

	public LeftNavigationPageObjectSimple openCommandButtonSection(){
		driver.findElement(commandButtonMenuItemSelector).click();
		return this;
	}
	
	public String getActiveTabText() {
		return driver.findElement(activeTabSelector).getText();
	}
}
