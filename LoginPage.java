package week4.day1;

public class LoginPage extends BasePage {

	public void performCommonTasks() {
		System.out.println("This method performs the tasks from LoginPage class");
	}
	public static void main(String[] args) {
		
		LoginPage object = new LoginPage();
		object.findElement();
		object.clickElement();
		object.enterText();
		object.performCommonTasks();

	}

}
