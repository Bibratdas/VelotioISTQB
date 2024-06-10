package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.ElementUtils;

public class AffiliatedCompanies {

	WebDriver driver;
	private ElementUtils elementUtils;
	public AffiliatedCompanies (WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//span[@class='fas fa-angle-right']")
	private WebElement nextBtn;

	@FindBy(xpath="//h3[@class='sp-simpleportfolio-title']")
	private List<WebElement> ListOfCompanies;


	public WebElement getNextBtn() {
		return nextBtn;
	}

	public  void getListOfCompanies() {


		try {	
			while(nextBtn.isEnabled()) {
				JavascriptExecutor js1=(JavascriptExecutor)driver;
				js1.executeScript("window.scrollTo(0,500)", "");	
				Thread.sleep(3000);

				List<WebElement> Companies = ListOfCompanies;

				for(WebElement name:Companies) {

					System.out.println(name.getText());
				}	


				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
			}






		}
		catch(Exception e) {

			System.out.println(e.getMessage());
		}


		//		try {	
		//			while(nextBtn.isEnabled()) {
		//				
		//				ScrollAndwait();
		//			
		//			
		//			for(WebElement ls:ListOfCompanies) {
		//				
		//				System.out.println(ls.getText());
		//			}	
		//			
		//				
		//				
		//				nextBtn.click();
		//			}
		//			}
		//			catch(Exception e) {
		//				
		//				System.out.println(e.getMessage());
		//			}
		//			

	}

	public void ScrollAndwait() throws InterruptedException {

		elementUtils.javaScriptScrollandwait(nextBtn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void ListOfAffiliatedCompanies() {


	}

}

















