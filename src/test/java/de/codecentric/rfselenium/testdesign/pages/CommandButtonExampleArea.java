package de.codecentric.rfselenium.testdesign.pages;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
//	@FindBy(className="outhello")
//	private WebElement greetingField;
	private By greetingFieldSelector = By.className("outhello");
	
	
	private WebDriver driver;

	public CommandButtonExampleArea(WebDriver driver) {
		this.driver = driver;
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
		long start = new Date().getTime();
		WebElement greetingField = new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver d) {
				
				return d.findElement(greetingFieldSelector);
			}
		});
		long end = new Date().getTime();
		System.out.println("Dauer: "+(end-start)+" ms");
		return greetingField.getText();
	}
	
}
