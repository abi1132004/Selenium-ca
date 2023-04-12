package com.selenium.test2.selenium1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CA1i {

	public static void main(String args[]) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String name = driver.getTitle();
		System.out.println(name);
		String title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(name.equals(title)) {
			System.out.println("Validated Page Title");
		}
		driver.get("https://www.amazon.in/s?hidden-keywords=B0BYJ8HR19+%7C+B0BYJ6ZMTS&_encoding=UTF8&_ref=dlx_gate_sd_dcl_tlt_ba182560_dt&content-id=amzn1.sym.a532052b-26f3-4811-a261-3b35ffa57237&pd_rd_r=29cc3f4c-d6b9-4854-9f5f-407e46a19d0b&pd_rd_w=mnH7y&pd_rd_wg=MMCW5&pf_rd_p=a532052b-26f3-4811-a261-3b35ffa57237&pf_rd_r=WGD1XTX6G3J84HSK440G&ref=pd_gw_unk");
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		addToCart.click();
		String addToCartCheck = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
		String addToCartMessage = "Added to Cart";
		if(addToCartMessage.equals(addToCartCheck)) {
			System.out.println("Added to cart");
		}
		driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
		driver.findElement(By.cssSelector("[value='Delete']")).click();  
		
		driver.findElement(By.name("submit.addToCart")).click();  
		driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
		System.out.println("Product Updated");
		
		driver.findElement(By.name("proceedToRetailCheckout")).click();  
		System.out.println("To proceed to purchase,You need to sign in");
	}
}