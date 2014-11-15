package de.codecentric.rfselenium.testsuite;

import static de.codecentric.rfselenium.testsuite.SeleniumConfiguration.baseUrl;

import org.junit.Test;

public class SeleniumTest extends AbstractSeleniumTest {


	@Test
	public void test(){
		getDriver().navigate().to(baseUrl());
	}
}
