package de.codecentric.rfselenium.testdesign;

import static de.codecentric.rfselenium.util.StaticHelper.BASE_URL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codecentric.rfselenium.testdesign.pages.CommandButtonExampleArea;
import de.codecentric.rfselenium.testdesign.pages.LeftNavigationPageObjectAdvanced;
import de.codecentric.rfselenium.testdesign.pages.LeftNavigationPageObjectSimple;

public class PageObjectsTest {
	
	private static final String EXPECTED_TAB_TITLE = "Command Button Simple";
	private WebDriver driver;
	
	@Before
	public void initDriver(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BASE_URL);
	}
	
	@Test
	public void openCommandButtonSectionTest(){
		LeftNavigationPageObjectSimple leftNavigation = new LeftNavigationPageObjectSimple(driver);
		leftNavigation.openCommandButtonSection();
		assertThat(leftNavigation.getActiveTab().getText(),equalTo(EXPECTED_TAB_TITLE));
	}
	
	@Test
	public void commandButtonTestFluentWithPageObjectFactory(){
		LeftNavigationPageObjectAdvanced leftNavigation = new LeftNavigationPageObjectAdvanced(driver);
		
		CommandButtonExampleArea openCommandButtonExampleArea = leftNavigation.openCommandButtonExampleArea();
		assertThat(openCommandButtonExampleArea.getTabTitle(), equalTo(EXPECTED_TAB_TITLE));
		
		openCommandButtonExampleArea.typeNameInInputField("Jan");
		openCommandButtonExampleArea.submit();
		
		assertThat(openCommandButtonExampleArea.getGreetinText(), equalTo("Hello Jan !"));
		
	}
	
	@After
	public void shutdown(){
		driver.quit();
	}

}
