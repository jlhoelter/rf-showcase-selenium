package de.codecentric.rfselenium.testsuite;

public class SeleniumConfiguration {

	public enum Property {
		SELENIUM_TARGET_HOST_NAME("selenium.target.hostName"), SELENIUM_BROWSER(
				"selenium.browser"), ;
		private String key;

		public String getKey() {
			return key;
		}

		private Property(String key) {
			this.key = key;
		}
	}

	public static String baseUrl() {
		return "http://" + hostName() + ":8080/showcase";
	}

	public static String hostName() {
		String hostName = getProperty(Property.SELENIUM_TARGET_HOST_NAME);
		return hostName == null ? "localhost" : hostName;
	}

	public static Browser getBrowser() {
		String browserValue = getProperty(Property.SELENIUM_BROWSER);
		Browser browser = (browserValue == null || browserValue.isEmpty()) ? Browser.FIREFOX
				: Browser.valueOf(browserValue);
		return browser;
	}


	private static String getProperty(Property property) {
		String key = property.getKey();
		String value = System.getProperty(key);
		return value;
	}

}
