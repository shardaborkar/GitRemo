package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HolidayPackage;
import pageObjects.SearchFlight;
import utils.TestContextSetup;

public class HolidayPackageStepDefinition {
	
	TestContextSetup testContextSetup;
	HolidayPackage holidayPackage;
	SearchFlight searchflight;
	public HolidayPackageStepDefinition(TestContextSetup testContextSetup ) {
		this.testContextSetup=testContextSetup;
		this.holidayPackage=testContextSetup.pageObjectManager.getHolidayPackage();
		this.searchflight=testContextSetup.pageObjectManager.getSearchFlight();
	}
	
	@Given("User clicks on holidaypackage option")
	public void User_clicks_on_holidaypackage_option() throws InterruptedException {
		searchflight.clickOnHolidayPackage();
	}
	
	@When("^User clicks on destination option (.+)$")
	public void User_clicks_on_destination_option(String desti) throws InterruptedException {
		holidayPackage.selectDestination(desti,testContextSetup);
		}
	
	@And("^User enters departure city (.+) and return city (.+)$")
	public void User_enters_departure_city_and_return_city(String departureCity,String returnCity) throws InterruptedException{
		holidayPackage.selectDeparture(departureCity,returnCity,testContextSetup);
	}
	
	@And("^User selects the departure date with month (.+) and date (.+)$")
	public void User_clicks_on_departDate(String month,int dateMonth) throws InterruptedException {
		holidayPackage.selectDepartDate(month, dateMonth,testContextSetup);
	}
	
	@And("User clicks on search button")
	public void User_clicks_on_search_button() throws InterruptedException {
		holidayPackage.search(testContextSetup);
	}
	
		
	
}
