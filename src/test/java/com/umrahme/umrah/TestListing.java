package com.umrahme.umrah;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestListing {
	private static WebDriver driver;
	private static ListingPage listing;
	private static int ch = 2;

	@Test
	public void SelectDestinationerrorfetch() {
		String str = listing.getSelectDestinationerror().getText();
		System.out.println(str);
	}

	@Test
	public void SelectNationalityerrorfetch() {
		String str = listing.getSelectNationalityerror().getText();
		System.out.println(str);
	}

	@Test
	public void SelectDestination() {
		listing.getSelectDestination().click();
		listing.getSearchBox().sendKeys("Makkah Only Package", Keys.ENTER);
	}

	@Test
	public void meccaerror() {
		System.out.println(listing.getmeccaerror().getText());
	}
	
	@Test
	public void SelectDate() {
		listing.getStartDate().click();
		listing.getStartDate().clear();
		listing.getStartDate().sendKeys("07-07-2022", Keys.ENTER);
	}
	
	@Test
	public void SelectmeccaStay() {
		listing.getMakkahStay().click();
		listing.getMeccaSearch().sendKeys("5", Keys.ENTER);
	}
	
	@Test
	public void clickOnTravellers() {
		listing.getTravellersRooms().click();
		this.selectAdult();
		
	}
	
	@Test
	public void selectAdult() {
		Select adult = new Select(listing.getAdults());
		adult.selectByVisibleText("4");
		this.selectChild();
		
	}
	
	@Test
	public void selectChild() {
		int i = 2;
		Select child = new Select(listing.getChilds());
		child.selectByVisibleText(""+i+"");
		this.selectage();
		
	}
	
	@Test
	public void selectage() {
		for (int i = 1; i <= ch; i++) {
			Select age = new Select(listing.getAge(i));
			age.selectByIndex(3);
		}
	}
	
	@Test
	public void selectCountryOfResidence() {
		
		listing.getCountryOfResidence().click();
		listing.getSearchCON().sendKeys("United States Of America", Keys.ENTER);
		
	}
	
	@Test
	public void selectNationality() {
		listing.getNationality().click();
		listing.getSearchNationality().sendKeys("United States Of America", Keys.ENTER);
		
	}
	
	@AfterTest
	public void clickOnSearch() {
		try {
		listing.getSearch().click();
		}catch (Exception e) {
			System.out.println("Exception Occured Because of version mismatch");
		}
	}

	@BeforeSuite
	public void driverInitialize() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.umrahme.com/home/en-sa");
		listing = new ListingPage(driver);
	}
	@AfterSuite
	public void driverclose() throws Exception {

		driver.quit();
	}


}
