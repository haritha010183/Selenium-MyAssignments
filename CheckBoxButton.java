package week3.day2;

public class CheckBoxButton extends Button {
	
	public void clickCheckButton() {
		
		System.out.println("This method is to click on the check button ----- Checkbox button Subclass");
		
	}
	
	public static void main(String[] args) {
		
		CheckBoxButton box = new CheckBoxButton();
		box.clickCheckButton();
		
	}

}
