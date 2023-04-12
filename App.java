package com.selenium.test2.selenium1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions co=new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");
    	WebDriver driver=new ChromeDriver(co);
    	driver.get("https://www.amazon.in/");
    	driver.manage().window().maximize();
    	String name = driver.getTitle();
		System.out.println(name);
		String title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(name.equals(title)) {
			System.out.println("Page Title is verified");
		}
		driver.get("https://www.amazon.in/Boult-Audio-Wireless-Playtime-Bluetooth/dp/B0BQN2RMJF/ref=sr_1_1_sspa?keywords=realme%2Bearbuds&qid=1681292045&s=electronics&sprefix=realme%2Bear%2Celectronics%2C318&sr=1-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		addToCart.click();
		String addedCheck = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
		String addMessage = "Added to Cart";
		if(addMessage.equals(addedCheck)) {
			System.out.println("Added to cart");
		}
    }
}
