package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCart {

	public static void main(String[] args) {
	
		//Opening eCommerce site
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Taking the count of cart before adding the product to cart
		WebElement bCart = driver.findElement(By.id("nav-cart-count"));
		String beforeCart = bCart.getText();
		
		//Adding product to the cart
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Toys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Gooyo DB2060')])[1]")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Taking the count of cart after adding the product to cart
		WebElement aCart = driver.findElement(By.id("nav-cart-count"));
		String afterCart = aCart.getText();
		
		//Validating if the product is added to cart
		if (afterCart != beforeCart) {
			System.out.println("Product added to cart");
		}
		else {
			System.out.println("Product not added to cart");
		}
		
		//Closing the browser
		driver.close();
		
	}

}
