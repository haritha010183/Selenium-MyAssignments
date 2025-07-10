package week3.day2;

public class LoginTestData extends TestData {
	
	public void enterUsername() {
		System.out.println("Please enter your username ------ LoginTestData subclass");
	}
	
	public void enterPassword() {
		System.out.println("Please enter your password ------ LoginTestData subclass");
	}

	public static void main(String[] args) {
		
		LoginTestData test = new LoginTestData();
		test.enterCredentials();
		test.enterUsername();
		test.enterPassword();
		test.navigateToHomePage();

	}

}
