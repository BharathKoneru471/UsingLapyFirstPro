package com.qa.pack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launch {
	
	public static void main(String [] args) {
	

	System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,15);//providing an explicit wait
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

	driver.get("https://www.google.com");
	
	driver.findElement(By.xpath("//div/input[@name='q']")).sendKeys("facebook");
	
//	try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	List<WebElement> list= driver.findElements(By.xpath("//div/ul[contains(@role,'listbox')]/li/div/descendant::div[contains(@class,'sbl1')]"));
	
	System.out.println("the number of suggestions present are:"+list.size());


	for(int j=0 ; j<list.size(); j++) {
		System.out.println(list.get(j).getText());
		if(list.get(j).getText().contains("facebook login")) {
			list.get(j).click();
			break;
		}
	}

	System.out.println(driver.getTitle());

	}

}
