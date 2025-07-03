package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		
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
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		//Click on  Leads Tab
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		
		//Click on Create Lead in Shortcuts
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		
		//Entering CompanyName, FirstName, LastName, FirstName (Local), Department, Description, Areacode, 
		//Phonenumber, email, stateDD
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Test Leaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Account");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Selenium Test");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("IT Quality Assurance");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Selenium Testing Test Lead creation");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneAreaCode']")).sendKeys("222");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("3334444");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("testaccount@gmail.com");
		WebElement state = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select st = new Select(state);
		st.selectByValue("NY");
		
		//Click on Create Lead button
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//Click on Edit button
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Clearing the Description field
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		
		//Fill the Important Note Field with Any text
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("Entering a note after clearing description field");
		
		//Click on the update button
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		
		//Get the Title of the Resulting Page
		String title = driver.getTitle();
		System.out.println(title);
		
		//Closing the browser
		driver.close();
	}

}
