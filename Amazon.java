package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the browser, open the site and maximize the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//Initializing implicit wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Search for Bags for boys
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys",Keys.ENTER);
		//Select a bag from the result
		
		/*JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0,5000)");*/
		Thread.sleep(500);
		
		
		//Print the total number of results
		WebElement search=driver.findElement(By.xpath("//h2[contains(@class,'a-size-base a-spacing')]"));
		String result = search.getText();
		System.out.println("The total number of search results: " + result);
		//Click on See more link under Brands
		driver.findElement(By.className("a-expander-prompt")).click();
		//Select 2 brands from the list
		driver.findElement(By.xpath("//span[contains(text(),'Tommy Hilfiger')]/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//span[contains(text(),'FUR JADEN')]")).click();
		//Choose new arrivals from sort
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("(//a[@class='a-dropdown-link'])[4]")).click();
		//Print first resulting bag info(name, discounted price) 
		WebElement firstItem = driver.findElement(By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal'])[1]"));
		String searchResult = firstItem.getText();
		System.out.println("The first resulting bag name is: " + searchResult);
		WebElement firstItemPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String displayPrice = firstItemPrice.getText();
		System.out.println("The first resulting bag price is: " + displayPrice);
		//Choose the item in the result 
		driver.findElement(By.xpath("//span[contains(text(),'Unisex Polyester 15 Inch Laptop Backpack - Navy')]")).click();
		//Page Title
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);
		//Close browser
		driver.close();
	}

}
