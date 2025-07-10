package week3.day2;

public class TextField extends WebElement {
	
	public void getText() {
		
		System.out.println("This method is to get a text ---- TextField subclass");
	}

	public static void main(String[] args) {
		
		TextField field = new TextField();
		field.click();
		field.setText();
		field.getText();
	
	}

}
