package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cinemas {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='cities-placed'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Chennai'])[3]")).click();
		
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();


		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0,300)");
		Thread.sleep(1000);
		//Select Cinema
		driver.findElement(By.xpath("//span[contains(text(),'PVR VR Chennai Anna Nagar')]")).click();
		//Select Date
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[2]")).click();
		//Select Movie
		Thread.sleep(500);
		//driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[5]")).click();
		driver.findElement(By.xpath("(//span[text()='SITAARE ZAMEEN PAR'])[2]")).click();
		//Select Timing
		Thread.sleep(250);
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[1]")).click();
		//Book button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Click Accept on Terms and conditions
		driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
		//Click on any one available seat
		driver.findElement(By.xpath("//span[@id='PR.PRIME|C:8']")).click();
		//Click on Proceed button
		driver.findElement(By.xpath("//div[@class='register-btn']")).click();
		//Print seat info
		WebElement seat=driver.findElement(By.xpath("//div[@class='seat-number']"));
		System.out.println("My booked seat is: " + seat.getText());
		
		//Print Grand total
		WebElement total=driver.findElement(By.xpath("//div[@class='grand-total']"));
		System.out.println("Total amount is: " + total.getText());
		
		//Click on proceed button
		driver.findElement(By.xpath("//button[@class='fb-added-btndesk']")).click();
		
		//Close popup
		Thread.sleep(500);
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		
		//Print the title
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);
		
		//Close the browser
		driver.close();
		
		
		
		


	}

}
