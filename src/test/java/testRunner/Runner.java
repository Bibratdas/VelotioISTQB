package testRunner;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Factory.DriverFactory;
import Pages.AffiliatedCompanies;
import Pages.HomePage;
import utils.ConfigReader;

public class Runner {

	static WebDriver driver ;


	@BeforeTest
	public void setup() {

		Properties prop = new ConfigReader().intializeProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

	@Test
	public void RunTest() {
		driver = DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);

		homepage.HoverOnElement();
		homepage.clickOnAffiliatedCompanies();
		AffiliatedCompanies affiliatedCompanies=new AffiliatedCompanies(driver);
		affiliatedCompanies.getListOfCompanies();
		System.out.println("----------------------------------");

	}

}
