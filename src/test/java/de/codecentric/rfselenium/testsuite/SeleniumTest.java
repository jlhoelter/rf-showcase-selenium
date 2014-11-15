package de.codecentric.rfselenium.testsuite;

import org.junit.Test;

public class SeleniumTest extends AbstractSeleniumTest {


	@Test
	public void test(){
		getDriver().get(SeleniumConfiguration.getBaseUrl());
	}
}
