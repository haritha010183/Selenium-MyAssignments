package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				continue;
			}
			else {
				System.out.println(i + " is a Prime Number");
			}
		}

	}

}
