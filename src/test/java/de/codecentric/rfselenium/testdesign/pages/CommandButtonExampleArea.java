package de.codecentric.rfselenium.testdesign.pages;

import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CommandButtonExampleArea {
	
	@FindBy(css=".navigation .rf-tab-hdr-act .rf-tab-lbl")
	private WebElement commandButtonExampeTab;
	
	@FindBys({
		@FindBy(className="example-cnt"),
		@FindBy(xpath="//input[@type='submit']")
	})
	private WebElement submitButton;
	
	@FindBys({
		@FindBy(className="example-cnt"),
		@FindBy(xpath="//input[@type='text']")
	})
	private WebElement inputField;
	
	@FindBy(className="outhello")
	private WebElement greetingField;

	public CommandButtonExampleArea(WebDriver driver) {
		initElements(driver, this);
	}
	
	public CommandButtonExampleArea typeNameInInputField(String text){
		inputField.clear();
		inputField.sendKeys(text);
		return this;
	}
	
	public CommandButtonExampleArea submit(){
		submitButton.click();
		return this;
	}
	
	public String getTabTitle(){
		return commandButtonExampeTab.getText();
	}
	
	public String getGreetingText(){
		return greetingField.getText();
	}
	
}
