package de.codecentric.rfselenium.remote;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.codecentric.rfselenium.util.StaticHelper;

public class RemoteWebDriverTest {
	
	@Test
	public void testShowcaseRunning() throws MalformedURLException{
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), 
				DesiredCapabilities.internetExplorer());

		
		driver.get(StaticHelper.BASE_URL);
		assertThat(driver.getTitle(), is("RichFaces Showcase"));
		driver.quit();
		
	}

}
