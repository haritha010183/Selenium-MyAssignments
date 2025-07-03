package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountDD {

	public static void main(String[] args) throws InterruptedException {
		
		//Creating a new method to Ignore Chrome popup
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//Precondition:
		//Creating an object, with the new object opening an URL and mazimizing the window
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		
		//Requirements
		
		//Handling Login page
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//Click on  Accounts Tab
		driver.findElement(By.linkText("Accounts")).click();
		
		//Click on Create Account button in Shortcuts
		driver.findElement(By.linkText("Create Account")).click();
		
		//Entering account name
		String accountName = "Selenium Testing Account";
		driver.findElement(By.id("accountName")).sendKeys(accountName);
		
		//Entering description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		
		//Selecting Computer Software as the Industry
		WebElement industryDD = driver.findElement(By.name("industryEnumId"));
		Select ind = new Select(industryDD);
		ind.selectByVisibleText("Computer Software");
		
		//Selecting "S-Corporation" as ownership using SelectByVisibleText
		WebElement ownershipDD = driver.findElement(By.name("ownershipEnumId"));
		Select owner = new Select(ownershipDD);
		owner.selectByVisibleText("S-Corporation");
		
		//Selecting "Employee" as the source using SelectByValue.
		WebElement sourceDD = driver.findElement(By.id("dataSourceId"));
		Select source = new Select(sourceDD);
		source.selectByValue("LEAD_EMPLOYEE");
		
		//Selecting "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
		WebElement marketingCampaignDD = driver.findElement(By.id("marketingCampaignId"));
		Select marketing = new Select(marketingCampaignDD);
		marketing.selectByIndex(6);
		
		//Selecting "Texas" as the state/province using SelectByValue.
		WebElement stateDD = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select state = new Select(stateDD);
		state.selectByValue("TX");
		
		//Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();
		
		//Verifying the account name is displayed correctly
		driver.findElement(By.linkText("Find Accounts")).click();
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys("Selenium Testing Account");
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		
		//Waiting for the search criteria to be displayed
		Thread.sleep(5000);
		
		//Storing the account name from the results to a variable
		WebElement record = driver.findElement(By.xpath("//a[contains(text(),'Selenium Testing Account')]"));
		String output = record.getText();
		
		//Verifying the account name is displayed correctly
		if (accountName.contains(output)) {
			System.out.println("Account Name is displayed correctly");
		}
		else {
			System.out.println("Account Name is not displayed as expected");
		}
		
		//Getting the Title
		String title = driver.getTitle();
		System.out.println(title);
	
		//Closing the browser
		driver.close();
	}

}
