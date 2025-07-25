package week5day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class AmazonActions {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Precondition
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Search for oneplus 9 pro phone
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro phone",Keys.ENTER);
		
		//Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price for the first product in the list is: " + price);
		
		//Print the number of customer ratings for the first displayed product
		String customer = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("The number of customer ratings for the first displayed product is: " + customer);
		
		//Print the ratings for the first displayed product
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]")).click();
		String rating = driver.findElement(By.id("acr-popover-title")).getText();
		System.out.println("The rating for the first product in the list is: " + rating);
		
		//Click the first text link of the first image.
		driver.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]")).click();
		WebElement image = driver.findElement(By.id("a-page"));
		
		//Take a screenshot of the product displayed.
		Actions screenshot = new Actions(driver);
		screenshot.moveToElement(image).perform();
		
		//Store the screenshot image in a folder
		File source = image.getScreenshotAs(OutputType.FILE);
		File target = new File("./phone_image.png");
		FileHandler.copy(source, target);
		System.out.println("The screenshot of the phone is saved in: " + target.getAbsolutePath());
		
		//Scroll page down and Click the 'Add to Cart' button.
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		WebElement addToCart = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
		Thread.sleep(3000);
		actions.moveToElement(addToCart).click().build().perform();
		
		//Get the cart subtotal
		WebElement cart = driver.findElement(By.xpath("//span[@id='sw-subtotal-item-count']"));
		WebElement cartPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String cartSubtotal = cartPrice.getText();
		System.out.println(cart.getText() + cartSubtotal );
		
		//Verify if cart subtotal is matching the product price
		if (price.equals(cartSubtotal)) {
			System.out.println("The product price and cart price are equal");
		}
		else {
			System.out.println("The product price and cart price are not equal. Please check!!!");
		}
		
		//Close the browser
		driver.close();

	}

}
