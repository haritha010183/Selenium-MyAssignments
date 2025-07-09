package week3.day1;

public class ReverseOddWords {

	public static void main(String[] args) {
		
		String test = "I am a software tester";
		
		String output[] = test.split(" ");
		
		for (int i = 0; i < output.length; i++) {
			if (i % 2 != 0) {
				char[] letters = output[i].toCharArray();
				for (int j = letters.length - 1; j >= 0; j--) {
					System.out.print(letters[j]);
				}
			}
			else {
				System.out.print(output[i]);
			}
			if (i < output.length -1) {
				System.out.print(" ");
			}
		}

	}

}
