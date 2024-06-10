package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	static WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;

	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();

	}

	public WebElement waitForElement(WebElement element,long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public  void mouseHover(WebElement element,long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);	
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}
	public  WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}


	public  WebElement javaScriptScrollandwait(WebElement element,long durationInSeconds) throws InterruptedException{

		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);

		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return element;
	}


}
