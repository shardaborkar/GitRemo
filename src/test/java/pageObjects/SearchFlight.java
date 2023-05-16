package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.GenericUtils;
import utils.TestContextSetup;

public class SearchFlight {
//GenericUtils genericUtils;
//TestContextSetup testContextSetup;
public SearchFlight(WebDriver driver) {
//this.testContextSetup=testContextSetup;	
this.driver=driver;	
}
WebDriver driver;
WebElement ele1;
By multicityOption=By.id("ctl00_mainContent_rbtnl_Trip_2");
By onewayOption=By.id("ctl00_mainContent_rbtnl_Trip_0");
By roundtripOption= By.id("ctl00_mainContent_rbtnl_Trip_1");
By departureDD= By.name("ctl00_mainContent_ddl_originStation1_CTXT");

By arrivalDD= By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

By departDate= By.id("ctl00_mainContent_view_date1");
By returnDate=By.name("ctl00$mainContent$view_date2");
By monthYear=By.className("ui-datepicker-month");
By dates=By.cssSelector("td[data-handler='selectDay']");

By passengers= By.id("divpaxinfo");
By noOfAdults=By.id("hrefIncAdt");
By noOfChilds=By.id("hrefIncChd");
By noOfInfants=By.id("hrefIncInf");
By currency= By.name("ctl00$mainContent$DropDownListCurrency");
By search= By.name("ctl00$mainContent$btn_FindFlights");
By popUp=By.id("MultiCityModelAlert");
By next=By.cssSelector("a[data-event='click']");
By holidayPackage=By.id("hlnkholidaypacks");

public void selectOption(String journeyType, TestContextSetup testContextSetup) throws InterruptedException {
    if(journeyType.equalsIgnoreCase("multicity")) {
    Thread.sleep(3000);	
 testContextSetup.genericUtils.highlightElement(driver.findElement(multicityOption));
	driver.findElement(multicityOption).click();
testContextSetup.genericUtils.highlightElement(driver.findElement(popUp));
	driver.findElement(popUp).click();
}
    if(!(driver.findElement(onewayOption).isSelected()))
    if(journeyType.equalsIgnoreCase("oneway")) {
    	testContextSetup.genericUtils.highlightElement(driver.findElement(onewayOption));
    	driver.findElement(onewayOption).click();
    	
    }
    
    if(journeyType.equalsIgnoreCase("roundtrip")) {
    	testContextSetup.genericUtils.highlightElement(driver.findElement(roundtripOption));
    	driver.findElement(roundtripOption).click();
    	
    }

}

public void selectCity(String departCity,String arrivalCity,TestContextSetup testContextSetup) throws InterruptedException {
//	By departureCity=By.cssSelector("a[value=departCity]");
//	By destinationCity=By.cssSelector("a[value=arrivalCity]");
	testContextSetup.genericUtils.highlightElement(driver.findElement(departureDD));
	driver.findElement(departureDD).click();
	driver.findElement(departureDD).sendKeys(departCity);
	Thread.sleep(3000);
//	driver.findElement(departureCity).click();
	testContextSetup.genericUtils.highlightElement(driver.findElement(arrivalDD));
	driver.findElement(arrivalDD).clear();
	driver.findElement(arrivalDD).sendKeys(arrivalCity);
	Thread.sleep(3000);
	
}

public void departureDate(TestContextSetup testContextSetup) throws InterruptedException {
    Thread.sleep(2000);
    testContextSetup.genericUtils.highlightElement(driver.findElement(departDate));
	driver.findElement(departDate).click();
   }

public void returnDate(TestContextSetup testContextSetup) throws InterruptedException {
    Thread.sleep(2000);
    testContextSetup.genericUtils.highlightElement(driver.findElement(returnDate));
	driver.findElement(returnDate).click();
   }

public void selectJourneyDate(String month,int dateMonth,TestContextSetup testContextSetup) throws InterruptedException{
	List<WebElement> ele=driver.findElements(monthYear);
	
	Iterator<WebElement> itr=ele.iterator();
	ele1=itr.next();

		if(!(ele1.getText().equalsIgnoreCase(month))){
			ele1=itr.next();
			if(!(ele1.getText().equalsIgnoreCase(month)))
			{
			driver.findElement(next).click();
		}
			
		
			else
			{
				WebElement monthCal=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]"));
				testContextSetup.genericUtils.highlightElement(monthCal);
					List<WebElement> date=monthCal.findElements(dates);
				for(WebElement d:date) {
					if(d.getText().equalsIgnoreCase(Integer.toString(dateMonth))) {
						d.click();
						break;
					}
					
				}
				
			}

		}
		
		else
		{
			WebElement monthCal=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]"));
			testContextSetup.genericUtils.highlightElement(monthCal);
			List<WebElement> date=monthCal.findElements(dates);
			for(WebElement d:date) {
				if(d.getText().equalsIgnoreCase(Integer.toString(dateMonth))) {
					d.click();
					break;
				}
				
			}
			
		}

		
	}
	


public void selectPassenger(int adult,int child,int infant,TestContextSetup testContextSetup) throws InterruptedException {
	Thread.sleep(2000);
//	driver.findElement(passengers).click();;
	testContextSetup.genericUtils.highlightElement(driver.findElement(passengers));
	Actions a=new Actions(driver);
	a.moveToElement(driver.findElement(passengers)).click().build().perform();
	Thread.sleep(2000);
	for(int i=1;i<adult;i++) {
	testContextSetup.genericUtils.highlightElement(driver.findElement(noOfAdults));	
	driver.findElement(noOfAdults).click();
}
	for(int i=0;i<child;i++) {
		testContextSetup.genericUtils.highlightElement(driver.findElement(noOfChilds));
		driver.findElement(noOfChilds).click();
	}
	
	for(int i=0;i<infant;i++) {
		testContextSetup.genericUtils.highlightElement(driver.findElement(noOfInfants));	
		driver.findElement(noOfInfants).click();
	}
}

public void selectPassenger(int adult,int child,TestContextSetup testContextSetup) throws InterruptedException {
	Thread.sleep(2000);
	testContextSetup.genericUtils.highlightElement(driver.findElement(passengers));
//	driver.findElement(passengers).click();;
	Actions a=new Actions(driver);
	a.moveToElement(driver.findElement(passengers)).click().build().perform();
	Thread.sleep(2000);
	for(int i=1;i<adult;i++) {
		testContextSetup.genericUtils.highlightElement(driver.findElement(noOfAdults));	
	driver.findElement(noOfAdults).click();
}
	for(int i=0;i<child;i++) {
		testContextSetup.genericUtils.highlightElement(driver.findElement(noOfChilds));	
		driver.findElement(noOfChilds).click();
	}
	
	
}

public void selectCurrency(String curr,TestContextSetup testContextSetup) throws InterruptedException {
	testContextSetup.genericUtils.highlightElement(driver.findElement(currency));	
	driver.findElement(currency).click();
	Select sel=new Select(driver.findElement(currency));
	
	sel.selectByValue(curr);
	
}

public void search(TestContextSetup testContextSetup) throws InterruptedException {
	testContextSetup.genericUtils.highlightElement(driver.findElement(search));	
	driver.findElement(search).click();
}

public String getErrorMesg() {
	String alertMesg =driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	return alertMesg;
}

public void clickOnHolidayPackage() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(holidayPackage).click();
}
	
}


