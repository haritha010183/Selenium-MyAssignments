package week3.day2;

public class LoginButton extends LoginTestData{
	
	public void clickSubmit() {
		System.out.println("Please click on this button to login ----LoginButton Subclass");
	}
	
	public void verifylogin() {
		System.out.println("Verify if the application is logged in ------ LoginButton subclass");
	}

	public static void main(String[] args) {
		
		LoginButton button = new LoginButton();
		button.enterCredentials();
		button.enterUsername();
		button.enterPassword();
		button.clickSubmit();
		button.verifylogin();
		button.navigateToHomePage();
		
	}

}
