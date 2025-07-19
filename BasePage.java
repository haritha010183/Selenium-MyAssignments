package week4.day1;

public class BasePage {
	
	public void findElement() {
		System.out.println("This method is to find an Element");
	}
	
	public void clickElement() {
		System.out.println("This method is to click an Element");
	}
	
	public void enterText() {
		System.out.println("This method is to define and enter Text");
	}
	
	public void performCommonTasks() {
		System.out.println("This method is to perform tasks for Base Page class");
	}

	public static void main(String[] args) {
		
		BasePage object = new BasePage();
		object.findElement();
		object.clickElement();
		object.enterText();
		object.performCommonTasks();
	}

}
