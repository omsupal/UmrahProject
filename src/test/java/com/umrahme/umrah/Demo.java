package com.umrahme.umrah;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static WebDriver driver;

	@Test
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.umrahme.com/home/en-sa");
		driver.navigate().refresh();
		SearchPage list = new SearchPage(driver);
		list.ClickOnSelectDestination("makkah");
		list.StartDate();
//		list.Staymadinah();
		list.Staymecca();
		list.traveller_and_rooms();

	}

}
