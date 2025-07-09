package week3.day1;

import java.util.Arrays;

public class FindMissingElement {
	
	public void missing() {
		
		int input[] = {1,4,3,2,8,6,7};
		Arrays.sort(input);
		//input after sorted is {1,2,3,4,6,7,8}
		
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i + 1] != input[i] + 1) {
				System.out.println(input[i] + 1);
				
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		FindMissingElement element = new FindMissingElement();
		element.missing();
		

	}

}
