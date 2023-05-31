package com.base;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Baseclass {
	
	
	public static WebDriver driver;
	public static 	Actions a;
	public static JavascriptExecutor js;
	public static Robot r;

	public static WebDriver browserlaunch(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		
	WebDriverManager.chromedriver().setup();
	ChromeOptions ch = new ChromeOptions();
	ch.addArguments("Incognito");
	driver = new ChromeDriver(ch);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		return driver;
	}
	public static void geturl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}
	public static void clickonelement(WebElement element) {
		
		if(element.isDisplayed() ) {
			element.click();
			
		}
	}
		public static void input(WebElement element, String ans) {
			if(element.isDisplayed()) {
			element.sendKeys(ans);
			}
		}
		public static void transfer(String option) {
			
			if(option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}
			else if(option.equalsIgnoreCase("back")){
				driver.navigate().back();
			}
			else if(option.equalsIgnoreCase("refresh")){
				driver.navigate().refresh();
			}
}
		public static void stay(long sec) throws InterruptedException {
			Thread.sleep(sec);
		}
		public static void shut() {
			
			driver.quit();
		}
		public static void pointtoelement(WebElement element) {
			a = new Actions(driver);
			a.moveToElement(element);
			
			
		}
		public static void screenshot(String filename) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\santh\\eclipse-workspace\\Selenium\\Screenshots\\"+ filename+".png");
			FileHandler.copy(src, dest);		
		}
		public static void tabaddress(int index) {
			
			Set<String> alltabs = driver.getWindowHandles();
			List<String> singletab = new LinkedList<>(alltabs);
			WebDriver lasttab = driver.switchTo().window(singletab.get(index));
			
		}
		public static void keyboard() throws AWTException{
			
			r.keyPress(KeyEvent.VK_ENTER);
		}
		
		public static void clicke () {
			driver.close();
		}
}



