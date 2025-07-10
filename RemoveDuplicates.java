package week3.day1;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String text = "We learn Java basics as part of java sessions in java week1";
	
		String output[] = text.split(" ");
		for (int i = 0; i < output.length; i++) {
			for (int j = i + 1; j < output.length; j++) {
				if (output[i].equalsIgnoreCase(output[j])) {
				output[j] =  " ";		
				}
			}
		}
		
		for (int i = 0; i < output.length; i++) {
					System.out.print(output[i] + " ");
			}
	}

}
