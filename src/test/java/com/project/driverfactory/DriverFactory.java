package com.project.driverfactory;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.project.utils.CommonUtils;



public class DriverFactory {
	
	static WebDriver driver = null;
	private static Logger logger = LogManager.getLogger(DriverFactory.class);
	
	public static WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
			logger.info("chrome driver initialized");
			
		}else if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
			logger.info("firefox  driver initialized");
		}else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
			logger.info("Edge driver initialized");
		}else if(browserName.equals("safari")) {
			
			driver = new SafariDriver();
			logger.info("safari driver initialized");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	

}
