package almosafer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

public class almosafer {
	
	WebDriver driver= new ChromeDriver();
	
	SoftAssert myAssertion=new SoftAssert();
	
	String ExpectLangauge="English";
	String Expectcurrency="SAR";
	
	@BeforeTest
	public void myBeforeTest() {
     
		driver.get("https://global.almosafer.com/ar");
		
	}

	@Test()
	public void defaultIsArabic() {
		String defaultLangauge=driver.findElement(By.xpath("//a[normalize-space()='English']")).getText();
		myAssertion.assertEquals(defaultLangauge, ExpectLangauge,"sure that the default langauge is Arabic");
		myAssertion.assertAll();

		
	}
	
	@Test()
	public void defaultcurrency() {
		String defaultcurr=driver.findElement(By.cssSelector(".sc-dRFtgE.dWRKFC")).getText();
		myAssertion.assertEquals(defaultcurr, Expectcurrency,"sure that the default currency is SAR");
		myAssertion.assertAll();

	}
	
	@Test()
	public void flightsTabClicked() {
		String flightsClicked=driver.findElement(By.id("uncontrolled-tab-example-tab-flights")).getAttribute("aria-selected");
		System.err.println(flightsClicked);
	    myAssertion.assertEquals("true", flightsClicked,"sure that the flight tab is clicked by default");
		myAssertion.assertAll();

	}


	

	@AfterTest
	public void myAfterTest() {
		
		driver.manage().window().maximize();

	}
		

}
