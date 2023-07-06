package com.automate.withMe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BeforeAfterTest {
	WebDriver driver = null;

	@BeforeTest
	@Parameters({ "Browser" })
	public void beforeTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			// Driver exe config
			System.setProperty("webdriver.chrome.driver",
					"D:\\eclipse\\Projects\\chromedriver.exe");

			// Instansiation the WebDriver Instance
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("EDGE")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\eclipse\\Projects\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\eclipse\\Projects\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Headless")) {
			WebDriver driver = new HtmlUnitDriver();
		}
	}

	@AfterTest
	@Parameters({ "Browser" })
	public void afterTest(String browser) {
		try {
			driver.close();

			if (!browser.equalsIgnoreCase("FF")) {
				driver.quit();
			} else {
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("FF issue");
		}
	}

}
