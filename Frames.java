package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	private static WebElement webElement;

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame("iframeResult");
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		String demoAccept = driver.findElement(By.id("demo")).getText();
		
		/*alert.dismiss();
		String demoDismiss = driver.findElement(By.id("demo")).getText();*/
		
		if (demoAccept.contains("You pressed OK")) {
			System.out.println("The alert is accepted");
		}
		/*else if (demoDismiss == "You pressed Cancel!") {
			System.out.println("The alert is cancelled");
		}*/
		
		else {
			System.out.println("Alert is not handled");
		}

	}

}
