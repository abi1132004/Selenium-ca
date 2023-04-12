package com.selenium.test2.selenium1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CA3 {

	    public static void main( String[] args ) throws InterruptedException
	    {
	    	WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(co);
			driver.get("https://www.amazon.in/ref=nav_logo");
			driver.manage().window().maximize();
			String title=driver.getTitle();
			System.out.println(title);
			if(title.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
				System.out.println("Verified title of the page");
			}else {
				System.out.println("Title not matched");
			}
			
			driver.findElement(By.id("nav-link-accountList")).click();
	    	
	    	
			driver.findElement(By.id("ap_email")).sendKeys("abishekkuttalam2004@gmail.com");
			driver.findElement(By.id("ap_email")).sendKeys(Keys.ENTER);
			driver.findElement(By.id("ap_password")).sendKeys("abis@2004");
			driver.findElement(By.id("ap_password")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String name=driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
			if(name.equals("Hello, Abishek")) {
				System.out.println("Successfully, signed in");
			}else {
				System.out.println("Sign in failed");
			}
			System.out.println("Testing Ended");
			
	    	driver.quit();
	    }
	}

