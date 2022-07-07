package com.umrahme.umrah;

import java.util.Date;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;
	@FindBy(id = "RouteCode-error")
	private WebElement sel_dest_error;

	@FindBy(xpath = "//ul[@id='select2-RouteCode-results']")
	private WebElement dropdown_dest;


	@FindBy(xpath = "//*[@id=\"frmHomeSearch\"]/div/div/div[1]/span")
	private WebElement select_destination;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement selctdest_search;

	@FindBy(id = "StartDate")
	private WebElement startdate;


// ********-- Click on Select Destination Element and search for destination--***********
	public void ClickOnSelectDestination(String dest) {
		try {
			if (sel_dest_error.isDisplayed()) {
				String str = sel_dest_error.getText();
				assertEquals(str, "Please select your destination.", "Validation Message is not appropriate");
			}
		} catch (NoSuchElementException e) {
			System.err.println("\"Select Destination Error\" Element not found");
		}

		select_destination.click();
		if (dropdown_dest.isDisplayed()) {
			System.out.println("Select Destination Dropdown is visible");
		}
		if (selctdest_search.isDisplayed()) {
			selctdest_search.sendKeys(dest, Keys.ENTER);
		}
	}

//*************************************************************************************************

	public void giveStartDate() {
		if (startdate.isDisplayed()) {
			String Active_date = startdate.getAttribute("value");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String current_date = formatter.format(date);
			int j = Integer.parseInt(current_date.substring(0, 2));
			j = j + 2;
			String temp = "";
			if (j <= 9) { 
				temp = "0" + j;
			} else {
				temp = "" + j;
			}
			assertEquals(Active_date, temp + current_date.substring(2));

			int i = Integer.parseInt(Active_date.substring(0, 2));
			i = i + 5;
			startdate.clear();
			startdate.sendKeys("" + i + Active_date.substring(2), Keys.ENTER);

		}
	}

//*************************************************************************************************
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this); // pagefactory.initElements is use to initialize the @FindBy
	}

}