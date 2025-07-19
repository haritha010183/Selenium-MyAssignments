package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjioAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.className("desktop-searchBar")).sendKeys("bags",Keys.ENTER);
		
		driver.findElement(By.xpath("(//div[@class='common-radioIndicator']/parent::label)[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[3]")).click();
		Thread.sleep(200);
		WebElement resultTitle = driver.findElement(By.xpath("//h1[@class='title-title']"));
		String title = resultTitle.getText();
		WebElement resultCount = driver.findElement(By.xpath("//h1[@class='title-title']/following-sibling::span"));
		String printResult = resultCount.getText();
		System.out.println(title + printResult);
		Thread.sleep(3000);
		List<WebElement> brand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		for(WebElement brandName: brand) {
			System.out.println(brandName.getText());
		}
		
		List<WebElement> Names = driver.findElements(By.xpath("//h4[@class='product-product']"));
		for(WebElement productNames : Names) {
			System.out.println(productNames.getText());
		}
		
		
	}
}
