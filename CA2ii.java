package com.selenium.test2.selenium1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CA2ii {
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
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("realme earbuds");
		search.sendKeys(Keys.ENTER);
		String resultPage = "https://www.amazon.in/s?k=realme+earbuds&ref=nb_sb_noss";
		String currentPage = driver.getCurrentUrl();
		if(resultPage.equals(currentPage)) {
			System.out.println("Product details displayed");
		}
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int i=0;
		for(WebElement link:list) {
			System.out.println(link.getText());
			i++;
			if(i==10) {
				break;
			}
		}
		WebElement category = driver.findElement(By.xpath("//*[@id=\"n/1389401031\"]/span/a/span"));
		category.click();
		WebElement categoryResult = driver.findElement(By.cssSelector("[class='a-price-whole']"));
		String categoryCurrent = categoryResult.getText();
		if(categoryCurrent.equals("1,099")) {
			System.out.println("Filter using category is accessible");
		}
		driver.navigate().back();
		WebElement price = driver.findElement(By.xpath("//*[@id=\"p_36/1318503031\"]/span/a/span"));
		category.click();
		WebElement priceResult = driver.findElement(By.cssSelector("[class='a-price-whole']"));
		String priceCurrent = priceResult.getText();
		if(priceCurrent.equals("299")) {
			System.out.println("Filter using price is accessible");
		}
		driver.navigate().back();
		WebElement review = driver.findElement(By.xpath("//*[@id=\"p_72/1318476031\"]/span/a/section/i"));
		category.click();
		WebElement reviewResult = driver.findElement(By.cssSelector("[class='a-price-whole']"));
		String reviewCurrent = reviewResult.getText();
		if(reviewCurrent.equals("389")) {
			System.out.println("Filter using review is accessible");
		}
	}
}

