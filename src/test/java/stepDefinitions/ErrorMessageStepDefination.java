package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.SearchFlight;
import utils.TestContextSetup;

public class ErrorMessageStepDefination {
	TestContextSetup testContextSetup;
	SearchFlight searchflight;
	public ErrorMessageStepDefination(TestContextSetup testContextSetup ) {
		this.testContextSetup=testContextSetup;
		this.searchflight=testContextSetup.pageObjectManager.getSearchFlight();
	}

	@Then("^User selects passengers with adults (.+) childs (.+) then Error message (.+) should be displayed$")
	public void User_clicks_on_multicity_option(int adults,int childs,String errorMesg) throws InterruptedException {
		searchflight.selectPassenger(adults,childs,testContextSetup);
		String alertMesg=searchflight.getErrorMesg();
		Assert.assertEquals(alertMesg, errorMesg);
		System.out.println(alertMesg);
	}
}
