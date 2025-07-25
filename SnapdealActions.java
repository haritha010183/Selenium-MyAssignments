package week5day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapdealActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Pre-condition
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(250);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Instantiating action class
		Actions actions = new Actions(driver);
		
		//Go to "Men's Fashion".
		WebElement mensFashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		actions.moveToElement(mensFashion).perform();
		
		//Go to "Sports Shoes".
		WebElement sportsShoes = driver.findElement(By.xpath("(//span[@class='linkTest'])[1]"));
		sportsShoes.click();
		
		//Get the count of sports shoes.
		WebElement shoesCount = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println("The men sports shoes count is: " + shoesCount.getText());
		
		//Click on "Training Shoes".
		WebElement trainingShoes = driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]"));
		trainingShoes.click();
		
		//Sort the products by "Low to High".
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"));
		sort.click();
		WebElement lowToHigh = driver.findElement(By.xpath("(//li[@class='search-li'])[1]"));
		lowToHigh.click();
		
		Thread.sleep(1000);
		//
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> shoePrice = new ArrayList<Integer>();
		for (WebElement shoePriceList : priceList) {
			String price = shoePriceList.getText();
			//price.replace(",", "");
			String newPrice = price.replaceAll("\\D", "");
			int updatedPrice = Integer.parseInt(newPrice);
			shoePrice.add(updatedPrice);
		}
		System.out.println(shoePrice);
		
		//Check if the displayed items are sorted correctly.
		boolean sorted = true;
		for (int i = 0; i < shoePrice.size() - 1; i++) {
			if (shoePrice.get(i) > shoePrice.get(i+1)) {
				sorted = false;
				break;
			}
		}
		
		if (sorted) {
			System.out.println("The price list is sorted from Low to High");
		}
		else {
			System.out.println("The price list is NOT sorted correctly");
		}
		
		//Select any price range ex:(500-700).
		WebElement from = driver.findElement(By.xpath("//input[@name='fromVal']"));
		if (from.isDisplayed()) {
			from.clear();
		}
		WebElement waitUntil = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='fromVal']")));
		waitUntil.sendKeys("500",Keys.TAB);
		Thread.sleep(500);
		WebElement to = driver.findElement(By.xpath("//input[@name='toVal']"));
		if (to.isDisplayed()) {
			to.clear();
		}
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1500");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		
		//Filter by any colour.
		WebElement color = driver.findElement(By.xpath("(//a[@class='filter-name'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", color);
		Thread.sleep(1000);
		actions.moveToElement(color).click().perform();
		
		Thread.sleep(1000);
		
		//Verify all the applied filters.
		WebElement priceFilter = driver.findElement(By.xpath("(//div[@class='navFiltersPill'])[1]"));
		Thread.sleep(1000);
		WebElement colorFilter = driver.findElement(By.xpath("(//div[@class='navFiltersPill'])[2]"));
		if (priceFilter.isDisplayed() && colorFilter.isDisplayed()) {
			System.out.println("All filters are applied");
		}
		else {
			System.out.println("All filters are not applied");
		}
		
		//Mouse hover on the first resulting "Training Shoes".
		WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-tuple-description '])[1]"));
		actions.moveToElement(firstProduct).perform();
		
		//Click the "Quick View" button.
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		
		Thread.sleep(1000);
		
		//Print the cost and the discount percentage.
		WebElement price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String newPrice = price.getText();
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String discountPercent = discount.getText();
		
		System.out.println("The price of the first product in the list is: Rs." + newPrice);
		System.out.println("The discount percentage of the first product in the list is: " + discountPercent);
		
		Thread.sleep(1000);
		
		//Close the current window.
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		//Take snapshot of the shoes
		WebElement shoes = driver.findElement(By.xpath("//div[@class='comp comp-right-wrapper ref-freeze-reference-point clear']"));
		actions.moveToElement(shoes).build().perform();
		
		File source = shoes.getScreenshotAs(OutputType.FILE);
		File target = new File("./shoes.png");
		FileHandler.copy(source, target);
		
		System.out.println("The screenshot of the shoes is stored in the path:" + target.getAbsolutePath());
		
		
		//Close the main window.
		driver.close();
		
	}

}
