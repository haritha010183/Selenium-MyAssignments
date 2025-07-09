package week3.day1;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String text = "We learn Java basics as part of java sessions in java week1";
		
		int count = 0;
	
		String output[] = text.split(" ");
		for (int i = 0; i < output.length; i++) {
			for (int j = i + 1; j < output.length; j++) {
				if (output[i].equalsIgnoreCase(output[j])) {
				output[j] =  "";
				count++;
				}
			}
		}
		
		if (count > 0) {
			for (String word : output) {
				if (!word.equals("")) {
					System.out.print(word + " ");
				}
			}
		}
		
		else {
			System.out.println("No duplicate words found");
		}
	}

}
