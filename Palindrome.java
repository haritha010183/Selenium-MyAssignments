package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int input = 121; 
		int output = 0; 
		int rem;
		for (int i = input; i > 0; i /= 10) {
			rem = i % 10;
			output = output * 10 + rem;
		}
		if (output == input) {
			System.out.println(input + " is a palindrome");
		}
		else {
			System.out.println(input + " is not a palindrome");
		}

	}

}
