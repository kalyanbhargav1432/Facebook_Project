package com.facebook.qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.facebook.qa.base.BaseClass;

public class UtilityClass extends BaseClass {
	public static long PAGE_LOAD_TIME = 45;
	public static long IMPLICIT_WAIT_TIME = 35;

	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty(
				"webdriver.chrome.driver\",\"C:\\Users\\LENOVO T470\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "./Screenshots/" + System.currentTimeMillis() / 1000 + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
