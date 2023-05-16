package pageObjects;

import org.openqa.selenium.WebDriver;

import stepDefinitions.ErrorMessageStepDefination;
import utils.TestContextSetup;


public class PageObjectManager {
	
	public SearchFlight searchflight;
	public HolidayPackage holidayPackage;
//	public Highlighter highlighter;
	
	public WebDriver driver;
	public TestContextSetup testContextSetup;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public SearchFlight getSearchFlight()
	{
	
	 searchflight= new SearchFlight(driver);
	 return searchflight;
	}



	public HolidayPackage getHolidayPackage() {
		holidayPackage= new HolidayPackage(driver);
		 return holidayPackage;
		}



/*	public Highlighter getHighlighter() {
		highlighter= new Highlighter(driver);
		return highlighter;
	}
	*/



	
	
}
