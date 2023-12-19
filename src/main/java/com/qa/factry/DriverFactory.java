package com.qa.factry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is"+browser);
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("please pass the correct browser value:"+browser);
		}
		getdDriver().manage().deleteAllCookies();
		getdDriver().manage().window().maximize();
		return getdDriver();

		
	}
	public static synchronized WebDriver getdDriver() {
		return tdriver.get();
	}
}



