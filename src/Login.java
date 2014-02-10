import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Login {

	
	@Test
	public static void loginAction () throws InterruptedException {
		
		// 1. Log into the Web version of Base.
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://core.futuresimple.com/sales/users/login");
		
		WebElement email = driver.findElementById("user_email");
		email.sendKeys("WincentyMajewski@dayrep.com");
		
		WebElement password = driver.findElementById("user_password");
		password.sendKeys("Sahta7ein");
		
		WebElement button = driver.findElementByTagName("Button");
		button.click();
		
		
		// 2. Create a new Lead.
		driver.get("https://app.futuresimple.com/leads/new");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(6500);
		//Name
		WebElement first_name = driver.findElementById("lead-first-name");
		
		first_name.sendKeys("Włodek");
		WebElement last_name = driver.findElementById("lead-last-name");
		last_name.sendKeys("Olszewski");
		// Company Name 
		WebElement company_name = driver.findElementById("lead-company-name");
		company_name.sendKeys("Sholl's Colonial Cafeteria");
		
		// Title,
		WebElement lead_title = driver.findElementById("lead-title");
		lead_title.sendKeys("Credit clerk");
		// Email Address
		WebElement lead_email = driver.findElementById("lead-email");
		lead_email.sendKeys("WodekOlszewski@dayrep.com");
		// Phone
		WebElement lead_mobile = driver.findElementById("lead-mobile");
		lead_mobile.sendKeys("666 666 666");
		WebElement lead_phone = driver.findElementById("lead-phone");
		lead_phone.sendKeys("79 401 47 61");
		
		// Address
		WebElement lead_street = driver.findElementById("lead-street");
		lead_street.sendKeys("Lazurowa 69");
		WebElement lead_city = driver.findElementById("lead-city");
		lead_city.sendKeys("Warszawa");
		WebElement lead_region = driver.findElementById("lead-region");
		lead_region.sendKeys("Mazowieckie");
		WebElement lead_zip = driver.findElementById("lead-zip");
		lead_zip.sendKeys("01-314");
		// Country, selektuj 
		/*
		WebElement country = driver.findElementByClassName("chzn-results");
		List<WebElement> allOptions = country.findElements(By.tagName("option"));
		System.out.println(allOptions.size());
		*/
		//selWP0_chzn
		
		//selWP0_chzn_o_177
		//WebElement polska = driver.findElementByClassName("controls inline country_select");
		// polska.click();
		// Tags ??
		/*
		WebElement lead_status = driver.findElementByClassName("status-select");
		List<WebElement> allOptions = lead_status.findElements(By.tagName("option"));
		System.out.println(allOptions.size());
		*/
		
		
		


		
		
		
		// 3. Check that its Lead status is "New"
		
		
		
		WebElement status = driver.findElementByXPath(".//*[@id='container']/div/div[2]/div/div/form/div/fieldset/div[2]/div/div[4]/div/div/div/select");
		status.sendKeys("New");
		WebElement save = driver.findElementByCssSelector(".save.btn.btn-large.btn-primary");
		save.click();
		
		
		
		
		
		// 4. Go into Settings / Leads / Lead statuses and change the name of the "New" status to a different name.
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement edit = driver.findElementByCssSelector(".btn.btn-mini.detail-edit");
		edit.click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement nowy = driver.findElementByCssSelector(".status-select>div>select");
		nowy.sendKeys("Working");
		WebElement save2 = driver.findElementByXPath(".//*[@id='container']/div/div[1]/div/div/div[2]/a[2]");
		save2.click();
		
		
		
		// 5. Go back to the Lead to check if the name change is reflected.
		
		// i tu mamy błąd 
		//driver.get("https://app.futuresimple.com/leads");
		
		WebElement w = driver.findElementByXPath(".//*[@id='details']/div/ul/div/div/a/span[1]");
		String powinno_byc = w.getText();
		Assert.assertEquals(powinno_byc,"Working");
		
		
		
		

	}
	

	
	
	
	

}
