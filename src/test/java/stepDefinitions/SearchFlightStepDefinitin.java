package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchFlight;
import utils.TestContextSetup;

public class SearchFlightStepDefinitin {
	TestContextSetup testContextSetup;
	SearchFlight searchflight;
	public SearchFlightStepDefinitin(TestContextSetup testContextSetup ) {
		this.testContextSetup=testContextSetup;
		this.searchflight=testContextSetup.pageObjectManager.getSearchFlight();
	}

	@Given("^User clicks on journeyType option (.+)$")
	public void User_clicks_on_multicity_option(String journeyType) throws InterruptedException {
		searchflight.selectOption(journeyType,testContextSetup);
	}
	
	@When ("^User enters departure city (.+) and arrival city (.+)$")
	public void user_enters_departure_city_and_arrival_city(String departCity,String arrivalCity) throws InterruptedException
	{
		searchflight.selectCity(departCity, arrivalCity,testContextSetup);
	}
	
	@And("User clicks on departDate")
	public void user_clicks_on_departDate() throws InterruptedException{
		searchflight.departureDate(testContextSetup);
	}
	
	@And("^User selects depart date with month (.+) and date (.+)$")
	public void User_selects_depart_date_with_month(String month,int dateMonth) throws InterruptedException {
		
		searchflight.selectJourneyDate(month, dateMonth,testContextSetup);
	}
	
	@When("^User selects passengers with adults (.+) childs (.+) infants (.+)$")
	public void user_selects_passengers(int adults,int childs,int infants) throws InterruptedException {
		searchflight.selectPassenger(adults, childs, infants,testContextSetup);
	}
	@When("^User selects currency as (.+)$")
	public void user_selects_currency(String curr) throws InterruptedException {
		searchflight.selectCurrency(curr,testContextSetup);
	}
	@When("User clicks on search")
	public void user_clicks_on_search() throws InterruptedException {
		searchflight.search(testContextSetup); 
	}
	@Then("Available flights for the given search criteria should be displayed")
	public void available_flights_for_the_given_search_criteria_should_be_displayed() {
	    
	}
	
	@Given("^User clicks on returndate option with month (.+) and date (.+)$")
	public void user_clicks_on_returndate_option_with_month_and_date(String month,int dateMonth) throws InterruptedException {
		searchflight.returnDate(testContextSetup);
		searchflight.selectJourneyDate(month, dateMonth,testContextSetup);
	}
	



}
