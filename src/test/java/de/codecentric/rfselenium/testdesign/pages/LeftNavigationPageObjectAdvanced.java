package de.codecentric.rfselenium.testdesign.pages;

import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftNavigationPageObjectAdvanced {
	
	@FindBy(id="j_idt22")
	private WebElement commandButtonExampleMenuItem;
	
	private WebDriver driver;
	
	public LeftNavigationPageObjectAdvanced(WebDriver driver){
		this.driver = driver;
		initElements(driver, this);
	}
	
	
	public CommandButtonExampleArea openCommandButtonExampleArea(){
		commandButtonExampleMenuItem.click();
		return new CommandButtonExampleArea(driver);
	}

}
