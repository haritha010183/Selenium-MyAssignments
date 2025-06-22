package week1.day2;

public class CheckNumberIsPositive {

	public static void main(String[] args) {
		
		for (int i = -5; i <= 5; i++) {
			if (i < 0) {
				System.out.println(i + " is a Negative number");
			}
			else if (i == 0) {
				System.out.println(i + " is zero");
			}
			else {
				System.out.println(i + " is a Positive number");
			}
		}

	}

}
