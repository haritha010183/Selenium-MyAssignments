package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) {
		
		//Creating a new object
		ChromeDriver driver = new ChromeDriver();
		
		//Opening an URL and maximizing the browser window
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		//Entering username and password and Logging in
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Clicking on a Link and navigating to create a lead
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Entering mandatory information to create a Lead
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Lead");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Automation Tester");
		driver.findElement(By.name("submitButton")).click();
		
		//Getting the title of the URL
		String title = driver.getTitle();
		System.out.println(title);
		
		//Closing the browser
		driver.close();

	}

}
