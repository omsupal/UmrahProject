package com.umrahme.umrah;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListingPage {
		public WebDriver driver;
		@FindBy(id="RouteCode-error")
		private WebElement sel_dest_error;
		
		@FindBy(xpath="//small[@id='meccaCityNight-error']")
		private WebElement meccastay_error;
		
		@FindBy(id="Nationality-error")
		private WebElement nationality_error;
		
		@FindBy(xpath="//*[@id=\"frmHomeSearch\"]/div/div/div[1]/span") 
		private WebElement select_destination;
		
		@FindBy(xpath="//input[@class='select2-search__field']")
		private WebElement selctdest_search;
		
		@FindBy(id="StartDate") 
		private WebElement startdate;

		@FindBy(xpath="//span[@aria-labelledby='select2-meccaCityNight-container']") 
		private WebElement makkah_stay;
		
		@FindBy(xpath="//input[@class='select2-search__field']")
		private WebElement mecca_search;
		
		@FindBy(xpath="//span[@aria-labelledby='select2-madinaCityNight-container']")
		WebElement madina_stay;

		@FindBy(xpath="//div[@class='all-traveller show-occupancy']")
		private WebElement travellers_rooms;

		@FindBy(xpath="//label[contains(.,'Adults')]/preceding-sibling::select")
		private WebElement adult_select;

		@FindBy(xpath="//label[contains(.,'Children')]/preceding-sibling::select")
		private WebElement child_select;
		
		private WebElement child_age_select;

		
		public WebElement getAge(int i) {
			String str = "//ul[@class=\"age-wrap\"]/li["+i+"]/select";
			child_age_select = driver.findElement(By.xpath(str));
			return child_age_select;
		}
//		
		@FindBy(xpath="//label[contains(.,'Country Of Residence')]/preceding-sibling::span") 
		private WebElement countryofresidence;
		
		@FindBy(xpath="//input[@aria-controls='select2-CountryOfResidence-results']")
		private WebElement searchCon;
//
		@FindBy(id="select2-Nationality-container") 
		private WebElement nationality;
		
		@FindBy(xpath="//input[@aria-controls='select2-Nationality-results']")
		private WebElement search_nationality;

		@FindBy(id="btnSearchPackage") 
		private WebElement searchbtn;
		
		public WebElement getSelectDestinationerror(){

			return sel_dest_error;
		}
		
		public WebElement getmeccaerror(){

			return meccastay_error;
		}
		
		public WebElement getSelectNationalityerror(){

			return nationality_error;
		}

		public WebElement getSelectDestination(){

			return select_destination;
		}
		
		public WebElement getSearchBox() {
			return selctdest_search;
		}

		public WebElement getStartDate(){

			return startdate;
		}
		
		public WebElement getMakkahStay(){

			return makkah_stay;
		}
		
		public WebElement getMeccaSearch() {
			return mecca_search;
		}
		
		public WebElement getMadinaStay(){

			return madina_stay;
		}
	
		public WebElement getTravellersRooms(){

			return travellers_rooms;
		}

		public WebElement getAdults(){

			return adult_select;
		}

		public WebElement getChilds(){

			return child_select;
		}
		

		public WebElement getCountryOfResidence(){

			return countryofresidence;
		}
		
		public WebElement getSearchCON() {
			return searchCon;
		}

		public WebElement getNationality(){

			return nationality;
		}
		
		public WebElement getSearchNationality(){

			return search_nationality;
		}
	
		public WebElement getSearch(){

			return searchbtn;
		}
		
		public ListingPage(WebDriver driver) {
			this.driver=driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			PageFactory.initElements(driver, this); // pagefactory.initElements is use to initialize the @FindBy
		}
				
}