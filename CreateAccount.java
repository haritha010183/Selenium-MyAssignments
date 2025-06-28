package week2.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;




public class CreateAccount {

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
		
		//Clicking on a Link and navigating to create an account
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.className("selected")).sendKeys("Test Account");
		
		//Entering mandatory information to create a Lead
		driver.findElement(By.id("accountName")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("50");
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.className("smallSubmit")).click();
		
		//Getting the title of the URL
		String title = driver.getTitle();
		System.out.println(title);
		
		//Closing the browser
		driver.close();

	}

}
