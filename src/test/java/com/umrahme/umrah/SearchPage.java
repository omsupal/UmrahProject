package com.umrahme.umrah;

import java.util.Date;
import static org.testng.Assert.assertEquals;


import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public Select occupancy;
//**************************WebElements***********************************************************
	@FindBy(id = "RouteCode-error")
	private WebElement sel_dest_error;

	@FindBy(xpath = "//ul[@id='select2-RouteCode-results']")
	private WebElement dropdown_dest;

	@FindBy(xpath = ".//select[@title='Select Destination']")
	private WebElement Select_destination_selectTag;

	@FindBy(xpath = "//span[@title='Select Destination']")
	private WebElement select_destination;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement selctdest_search;
	
	@FindBy(id="select2-RouteCode-results")
	private WebElement destination_result;

	@FindBy(id = "StartDate")
	private WebElement startdate;

	@FindBy(xpath = "//span[@aria-labelledby='select2-meccaCityNight-container']")
	private WebElement makkah_stay;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement mecca_search;

	@FindBy(xpath = ".//ul[@id='select2-meccaCityNight-results']")
	private WebElement mecca_dropdown;
	
	@FindBy(id="select2-meccaCityNight-container")
	private WebElement selected_no_of_night;
	
	@FindBy(xpath="//span[@aria-labelledby='select2-madinaCityNight-container']")
	WebElement madina_stay;
	
	@FindBy(xpath=".//input[@aria-controls='select2-madinaCityNight-results']")
	private WebElement madina_search;
	
	@FindBy(id="select2-madinaCityNight-container")
	private WebElement selected_no_of_nightsMadina;
	
	@FindBy(xpath="//label[contains(.,'Travellers & Rooms')]/..")
	private WebElement travellers_rooms;
	
	@FindBy(xpath=".//label[contains(.,'Adults')]/preceding-sibling::select")
	private WebElement adult_select;
	
	@FindBy(xpath=".//label[contains(.,'Children')]/preceding-sibling::select")
	private WebElement child_select;
	
	@FindBy(xpath="//label[contains(.,'Country Of Residence')]/preceding-sibling::span") 
	private WebElement countryofresidence;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement searchCon;
	
	@FindBy(id="select2-CountryOfResidence-results")
	private WebElement Country_result;
	
	@FindBy(id="select2-Nationality-container") 
	private WebElement nationality;

//*****************Explicit Wait Method**********************************************
	public void elementCall(final WebElement ele) {
		wait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {

				boolean dis = ele.isDisplayed();
				return dis;
			}
		});
	}

// ********-- Click on Select Destination Element and search for destination--***********
	public void ClickOnSelectDestination(String dest) {
		
		if (wait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {

				boolean dis = sel_dest_error.isDisplayed();
				return dis;
			}
		})) {
			String str = sel_dest_error.getText();
			assertEquals(str, "Please select your destination.", "Validation Message is not appropriate");
			System.out.println(str + "");
		}
		elementCall(select_destination);
		select_destination.click();
		elementCall(dropdown_dest);
		System.out.println("Select Destination Dropdown is visible");
		elementCall(selctdest_search);
		selctdest_search.sendKeys(dest);
		elementCall(destination_result);
		assertEquals(destination_result.getText(), dest);
		selctdest_search.sendKeys(Keys.ENTER);
	}

//*************************************************************************************************

	public void StartDate() {
		elementCall(startdate);
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
		assertEquals("" + i + Active_date.substring(2), startdate.getAttribute("value"));
		System.out.println(startdate.getAttribute("value"));

	}

//********************************Mecca Stay**************************************************
	public void Staymecca() {
		String str = "5";
		elementCall(makkah_stay);
		makkah_stay.click();
		elementCall(mecca_search);
		mecca_search.sendKeys(str, Keys.ENTER);
		assertEquals(selected_no_of_night.getText(), str+" Nights");
		System.out.println(selected_no_of_night.getText());
		
	}

//********************************Maddina Stay**************************************************
	public void Staymadinah() {
		String str = "5";
		elementCall(madina_stay);
		madina_stay.click();
		elementCall(madina_search);
		madina_search.sendKeys(str, Keys.ENTER);
		assertEquals(selected_no_of_nightsMadina.getText(), str+" Nights");
		System.out.println(selected_no_of_nightsMadina.getText());
		
	}
	
//****************************Travellers and Rooms*************************************************
	public void traveller_and_rooms() {
		elementCall(travellers_rooms);
		travellers_rooms.click();
		elementCall(adult_select);
		occupancy = new Select(adult_select);
		adult_select.click();
		occupancy.selectByVisibleText("4");
		assertEquals(occupancy.getFirstSelectedOption().getText(), "4");
		elementCall(child_select);
		occupancy = new Select(child_select);
		occupancy.selectByVisibleText("2");
		assertEquals(occupancy.getFirstSelectedOption().getText(), "2");
	}
//********************************Select Country Of Residence*****************************************
	public void selectcountryOfResidence(String country) {
		elementCall(countryofresidence);
		countryofresidence.click();
		elementCall(searchCon);
		searchCon.sendKeys(country);
		elementCall(Country_result);
		System.out.println(Country_result.getText());
		assertEquals(Country_result.getText(), country);
		searchCon.sendKeys(Keys.ENTER);
	}
//*********************************************************************************************	
	public void selectNationality(String nation) {
		elementCall(nationality);
		
	}
//*********************************************************************************************
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this); // pagefactory.initElements is use to initialize the @FindBy
	}

}