package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	private static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//Precondition:
		//Creating an object, with the new object opening an URL and mazimizing the window
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on the "Basic Checkbox.”
		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		
		//Click on the "Notification Checkbox."
		driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget'])[2]")).click();
		
		
		//Verify that the expected message is displayed.
		WebElement message = driver.findElement(By.className("ui-growl-title"));
		String verificationMessage = message.getText();
		
		if (verificationMessage.contains("Checked")) {
			System.out.println("Expected message displayed");
		}
		else {
			System.out.println("Expected message not displayed");
		} 
		
		//Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(By.xpath("//label[text()='Python']")).click();
		driver.findElement(By.xpath("//label[text()='Javascript']")).click();
		
		//Click on the "Tri-State Checkbox first time."
		WebElement check1 = driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ']/parent::div"));
		check1.click();
		
		WebElement popup1 = driver.findElement(By.xpath("//p[text()='State = 1']"));
		String state1 = popup1.getText();
		
		//Verify tri-state 1 is chosen
		if (state1.contains("State = 1")) {
			
			System.out.println("Tri State Checkbox is selected and " + state1);
		}
		
		//Click on the "Tri-State Checkbox second time."
		WebElement check2 = driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ui-icon ui-icon-check']"));
		check2.click();
		
		
		WebElement popup2 = driver.findElement(By.xpath("//p[text()='State = 2']"));
		String state2 = popup2.getText();
		
		
		//Verify tri-state 2 is chosen
		if (state2.contains("State = 2")) {
			System.out.println("Tri State Checkbox is selected and " + state2);
		}

		//Click on the "Tri-State Checkbox third time."
		WebElement check3 = driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ui-icon ui-icon-closethick']"));
		check3.click();
		
		
		WebElement popup3 = driver.findElement(By.xpath("//p[text()='State = 0']"));
		String state3 = popup3.getText();
		
		//Verify tri-state 3 is chosen
		if (state3.contains("State = 0")) {
			System.out.println("Tri State checkbox is selected and " + state3);
		}
		
		//Click on the "Toggle Switch to turn it on."
		WebElement toggle = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
		toggle.click();
		
		WebElement alert1 = driver.findElement(By.xpath("//span[text()='Checked']"));
		String alertOn = alert1.getText();
		
		//Verify that the expected message is displayed.
		if (alertOn.contains("Checked")) {
			System.out.println("Toggle switch is turned on");
		}
		
		//Click on the "Toggle Switch to turn it off."
		toggle.click();
		
		//Click on the "Toggle Switch to turn it off."
		WebElement alert2 = driver.findElement(By.xpath("//span[text()='Unchecked']"));
		String alertOff = alert2.getText();
		
		//Verify that the expected message is displayed.
		if (alertOff.contains("Unchecked")) {
			System.out.println("Toggle switch is turned off");
		}
		
		//Verify if the Checkbox is disabled.
		WebElement box = driver.findElement(By.xpath("//input[@type='checkbox'][@disabled]"));
		
		if (box.isEnabled()) {
			System.out.println("Checkbox is enabled");
		}
		else {
			System.out.println("Checkbox is disabled");
		}
		
		
		//Select multiple options on the page (details may be needed).
		WebElement dd = driver.findElement(By.xpath("//ul[contains(@class,'multiple')]"));
		dd.click();
	
		
		WebElement paris = driver.findElement(By.xpath("(//label[text()='Paris'])[2]"));
		paris.click();
		
		System.out.println("Paris checkbox is selected");
		
		WebElement rome = driver.findElement(By.xpath("(//label[text()='Rome'])[2]"));
		rome.click();
		
		System.out.println("Rome checkbox is selected");
		
		
		//To scroll the bar in drop down to the end
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0,300)");
		Thread.sleep(1000);
		
		WebElement amsterdam = driver.findElement(By.xpath("(//label[text()='Amsterdam'])[2]"));
		amsterdam.click();
		
		System.out.println("Amsterdam checkbox is selected");
		
		
		//Displaying the checked cities
		WebElement checked = driver.findElement(By.xpath("//ul[@data-label='Cities']"));
		String cities = checked.getText();
		
		System.out.println("The checkboxes selected in multiple options are: \n" +  cities);
		
		//Close the browser
		driver.close();

	}

}
