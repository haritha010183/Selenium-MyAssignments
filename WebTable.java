package week5.day1;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		//Precondition 
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Entering From Station
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MAS",Keys.TAB);
	
		//Entering To Station
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("MDU",Keys.TAB);
		
		//Verifying Sort on Date and unchecking 
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']"));
		if (checkBox.isSelected()) {
			checkBox.click();
		}
		
		//Train Names from the table
		List<WebElement> trains = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));
		
		//Train Name Header
		WebElement colhead = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/th[2]"));
		String header = colhead.getText();
		System.out.println("The list of trains from MAS to MDU are: ");
		
		System.out.println("---------------------------------------");
		
		//Creating sets to validate duplicates
		Set<String> uniqueNames = new HashSet<String>();
		Set<String> duplicate = new HashSet<String>();
		
		for(WebElement trainNames : trains) {
			String name = trainNames.getText();
			System.out.println(name);
		
		//Validating duplicates
			if(!uniqueNames.add(name)) {
				duplicate.add(name);
			}
		}
		
		System.out.println("----------------------------------------");
		
		if (!duplicate.isEmpty()) {
			System.out.println("There are duplicates");
			for(String dup : duplicate) {
				System.out.println(dup);
			}
		}
		else {
			System.out.println("There are no duplicates");
		}
		
		//Close Browser
	
	}

}
