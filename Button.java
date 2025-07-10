package week3.day2;

public class Button extends WebElement{
	
	public void submit() {

		System.out.println("This method is to click on Submit button ---- Button subclass");
		
	}

	public static void main(String[] args) {
		
		Button option = new Button();
		option.click();
		option.setText();
		option.submit();

	}

}
