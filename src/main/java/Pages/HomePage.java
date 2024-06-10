package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	public HomePage (WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}


	@FindBy(xpath="(//a[text()='ABOUT US'])[1]")
	private WebElement aboutus;

	@FindBy(linkText="AFFILIATED COMPANIES")
	private WebElement links;



	public WebElement getLinks() {
		return links;
	}

	public void HoverOnElement() {

		elementUtils.mouseHover(aboutus,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnAffiliatedCompanies() {

		elementUtils.clickOnElement(links,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}
