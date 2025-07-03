package week2.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FacebookAccount {

	public static void main(String[] args) {
		

		//Creating an object, opening facebook page and maximizing the window
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com");
		driver.manage().window().maximize();
		
		//Adding an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on the Create new account button
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		
		//Enter first name
		driver.findElement(By.name("firstname")).sendKeys("Test");
		
		//Enter surname
		driver.findElement(By.name("lastname")).sendKeys("Account");
		
		//Enter mobile number or email address
		driver.findElement(By.name("reg_email__")).sendKeys("testaccount@gmail.com");
		
		//Enter the New password.
		driver.findElement(By.id("password_step_input")).sendKeys("Password123!");
		
		//Handle all three dropdowns in Date of birth
		//Handling day dropdown in DOB
		WebElement dayDD = driver.findElement(By.id("day"));
		Select day = new Select(dayDD);
		day.selectByVisibleText("28");
		
		//Handling month dropdown in DOB
		WebElement monthDD = driver.findElement(By.id("month"));
		Select month = new Select(monthDD);
		month.selectByIndex(5);
		
		//Handling year dropdown in DOB
		WebElement yearDD = driver.findElement(By.id("year"));
		Select year = new Select(yearDD);
		year.selectByValue("2017");
		
		//Select the radio button in Gender.
		driver.findElement(By.xpath("(//input[@id='sex'])[2]")).click();
		
		//Getting the title of the browser
		String title = driver.getTitle();
		System.out.println(title);
		
		//Closing the browser
		driver.close();
		
	}

}
