package week5day2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Pre-condition
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Click on "Shop by Category".
		driver.findElement(By.xpath("(//span[contains(text(),'Category')])[2]")).click();
		Thread.sleep(500);
		
		//Instantiating action class
		Actions actions = new Actions(driver);
		
		//Mouse over "Foodgrains, Oil & Masala"
		WebElement foodgrainsCategory = driver.findElement(By.xpath("(//a[contains(text(),'Foodgrains')])[2]"));
		actions.moveToElement(foodgrainsCategory).perform();
		Thread.sleep(500);
		
		//Mouse over "Rice & Rice Products".
		WebElement riceCategory = driver.findElement(By.xpath("//a[contains(text(),'Rice & Rice Products')]"));
		actions.moveToElement(riceCategory).perform();
		Thread.sleep(500);
		
		//Click on "Boiled & Steam Rice"
		WebElement steamedRiceCategory = driver.findElement(By.xpath("//a[contains(text(),'Boiled & Steam Rice')]"));
		actions.moveToElement(steamedRiceCategory).click().perform();
		Thread.sleep(500);
		
		//Filter the results by selecting the brand "bb Royal".
		
		WebElement brand = driver.findElement(By.id("i-bbRoyal"));
		actions.scrollToElement(brand);
		Thread.sleep(3000);
		actions.click(brand).build().perform();
		
		//Click on "Tamil Ponni Boiled Rice"
		WebElement boiledRice = driver.findElement(By.xpath("//h3[text() = 'Tamil Ponni Boiled Rice']"));
		actions.scrollToElement(boiledRice);
		WebElement elementResurface = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text() = 'Tamil Ponni Boiled Rice']")));
		elementResurface.click();
		
		//Navigating to child window
		Set<String> window2 = driver.getWindowHandles();
		List<String> riceWindow = new ArrayList<String>(window2);
		driver.switchTo().window(riceWindow.get(1));
		Thread.sleep(2000);
		
		//Select the 5 Kg bag
		driver.findElement(By.xpath("(//span[contains(text(),'5 kg')])[2]")).click();
		
		//Check and note the price of the rice.
		WebElement price = driver.findElement(By.xpath("(//span[contains(@class,'StyledLabel4')])[4]"));
		System.out.println("The price for 5Kg of bb Royal Tamil Ponni Boiled Rice, 5 kg (12-17 Months Old) is: " + price.getText());
		
		//Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("(//button[contains(text(),'Add to basket')])[1]")).click();
		
		//Verify the success message that confirms the item was added to your cart.
		WebElement success = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']"));
		Thread.sleep(1000);
		boolean successMessage = success.isDisplayed();
		
		Thread.sleep(3000);
		System.out.println("The success message is displayed: " + successMessage);
		
		
		//Take a snapshot of the current page
		WebElement page = driver.findElement(By.xpath("(//div[contains(@class,'container')])[1]"));
		actions.moveToElement(page).perform();
		
		//Store the screenshot image in a folder
		File source = page.getScreenshotAs(OutputType.FILE);
		File target = new File("./addToCart_image.png");
		FileHandler.copy(source, target);
		
		System.out.println("The screenshot of the item added to the basket is stored in the path: " + target.getAbsolutePath());
		
		//Close the child window browser
		driver.close();
		
		//Switching the control to the parent window
		driver.switchTo().window(riceWindow.get(0));
		
		//Close the parent window browser
		driver.close();
				
		
		
	}

}
