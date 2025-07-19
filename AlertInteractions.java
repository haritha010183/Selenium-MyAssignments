package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertInteractions {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//span[contains(text(),'Show')])[5]")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello there!!");
		alert.dismiss();
		WebElement action = driver.findElement(By.xpath("//span[@id='confirm_result']"));
		String result = action.getText();
		System.out.println(result);
		
		if (result.contains("User cancelled the prompt.")) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
		
	}

}
