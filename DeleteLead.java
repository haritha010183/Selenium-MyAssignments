package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		//Creating a new method to Ignore Chrome popup
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//Precondition:
		//Creating an object, with the new object opening an URL and mazimizing the window
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		//Requirements
		
		//Handling Login page
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//Click on  Leads Tab
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on Find Leads in Shortcuts
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//Click on Phone tab 
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter the phone number
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("222");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("3334444");
		
		//Click the "Find leads" button.
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		//Waiting for the search results to be displayed
		Thread.sleep(3000);
		
		//Capture the lead ID of the first resulting lead and storing it in a variable
		WebElement id = driver.findElement(By.xpath("(//a[contains(text(),'14487')])[1]"));
		
		//Converting the web element to string
		String leadID = id.getText();
		System.out.println(leadID);
		
		//Click the first resulting lead
		driver.findElement(By.xpath("(//a[contains(text(),'14487')])[1]")).click();
		
		//Click the "Delete" button
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
		//Click "Find leads" again
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//Enter the captured lead ID.
		driver.findElement(By.name("id")).sendKeys("14484");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		//Waiting for the search results to be displayed
		Thread.sleep(5000);
		
		//Verify the presence of the message "No records to display" in the Lead List. This message confirms the successful deletion.
		WebElement message = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		String verification = message.getText();
		String verificationMessage = "No records to display";
		if (verification.equals(verificationMessage)) {
			System.out.println("This message confirms the successful deletion");
		}
		else {
			System.out.println("Record is not deleted");
		}
		
		//Closing the browser
		driver.close();
		
	}

}
