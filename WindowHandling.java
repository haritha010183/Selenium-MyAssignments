package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//img[@id='disha-banner-close']")).click();
		
		driver.findElement(By.xpath("(//li[@class='menu-list header-icon-menu'])[3]")).click();
		Set<String> flightWindow = driver.getWindowHandles();
		
		List<String> childWindow = new ArrayList<String>(flightWindow);
		driver.switchTo().window(childWindow.get(1));
		String windowAddress = driver.getWindowHandle();
		System.out.println(windowAddress);
		Thread.sleep(500);
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.switchTo().window(childWindow.get(0));
		driver.close();

	}

}
