/*package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {
	JavascriptExecutor js;
	WebDriver driver;
	public Highlighter(WebDriver driver) {
		this.driver=driver;
	}
	
	public void highlightElement(WebElement ele) throws InterruptedException {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.background= 'yellow'; arguments[0].style.border= '2 px solid black'",ele);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border= 'solid 2 px white'",ele);
		
	}

}
*/
