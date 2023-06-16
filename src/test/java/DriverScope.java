

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScope {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement miniDriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(miniDriver.findElements(By.tagName("a")).size());
		WebElement footerdriver=miniDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
        for(int i=1;i<footerdriver.findElements(By.tagName("a")).size();i++) {
        	String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
        	footerdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
        }
        Set<String> windows=driver.getWindowHandles();
       for(String id:windows) {
       	System.out.println(driver.switchTo().window(id).getTitle());
        	
        }
   /*     for(int i=0;i<windows.size();i++) {
       	System.out.println(driver.switchTo().window("windows(i)").getTitle());
        	System.out.println(driver.switchTo().window(windows(i)).getTitle());
        }*/
	}

}
