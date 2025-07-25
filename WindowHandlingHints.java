package week5.day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WindowHandlingHints {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Opening the browswer as a guest
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//Pre-condition
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username and password.
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on the Login button.
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on the CRM/SFA link.
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		//Click on the Contacts button.
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//Click on Merge Contacts.
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		
		//Click on the widget of the "From Contact".
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//Navigating the control to new window
		Set<String> childWindow1 = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(childWindow1);
		Thread.sleep(5000);
		driver.switchTo().window(window1.get(1));
		
		//Click on the first resulting contact.
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).click();
		Thread.sleep(1000);
		
		//Navigating the control to parent window
		driver.switchTo().window(window1.get(0));
		
		//Click on the widget of the "To Contact".
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		//Navigating the control to new window
		Set<String> childWindow2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(childWindow2);
		driver.switchTo().window(window2.get(1));
		
		//Click on the second resulting contact.
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]")).click();
		
		//Navigating the control to parent window
		driver.switchTo().window(window1.get(0));
		
		//Click on the Merge button.
		driver.findElement(By.xpath("//table/tbody/tr[4]/td/a[@class='buttonDangerous']")).click();
		
		//Accept the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify the title of the page.
		String title = driver.getTitle();
		System.out.println(title);
	}

}
