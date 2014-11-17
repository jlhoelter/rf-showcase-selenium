package de.codecentric.rfselenium.smoketest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codecentric.rfselenium.util.StaticHelper;

public class InitalSetupSmoketest {
	
	@Test
	public void testShowcaseRunning(){
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		firefoxDriver.get(StaticHelper.BASE_URL);
		assertThat(firefoxDriver.getTitle(), is("RichFaces Showcase"));
		firefoxDriver.quit();
		
	}

}
