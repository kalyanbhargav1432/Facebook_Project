package com.facebook.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.facebook.qa.utility.UtilityClass;
import com.facebook.qa.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties properties;
	public static EventFiringWebDriver eventFiringWebdriver;
	public static WebEventListener eventListener;
	ChromeOptions options = new ChromeOptions();

	public BaseClass() {
		properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(
					"C:\\Users\\LENOVO T470\\eclipse-workspace\\Selenium\\FacebookPage\\src\\main\\java\\com\\facebook\\qa\\config\\config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\LENOVO T470\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// Capture screenshot when test failed
		eventFiringWebdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventFiringWebdriver.register(eventListener);
		driver = eventFiringWebdriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		options.addArguments("--disable-notifications");
		driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));

	}

}
