package com.umrahme.umrah;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.umrahme.com/home/en-sa");
//		driver.navigate().refresh();
		SearchPage list = new SearchPage(driver);
		list.ClickOnSelectDestination("Makkah");
		list.giveStartDate();

	}

}
