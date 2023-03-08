

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoSuggestDD {
    @Test
	public void browserStack() throws InterruptedException, MalformedURLException {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap=new DesiredCapabilities();
		WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),cap);
        String countryName="United";
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/");
		driver.findElement(By.cssSelector("a[href*='Automation']")).click();
		driver.findElement(By.id("autocomplete")).sendKeys(countryName);
		Thread.sleep(3000);
		List<WebElement> ele=driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for(int i=0;i<ele.size();i++) {
			if(ele.get(i).getText().equalsIgnoreCase("United States (USA)")) {
				
		ele.get(i).click();
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
//		System.out.println(driver.findElement(By.id("autocomplete")).getText()); this wont give any result hence we have to use getattribut only
			break;
		}}
		
		
		System.out.println(driver.getTitle());
	}

}
