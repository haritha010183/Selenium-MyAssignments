package week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSecondLargest {

	public static void main(String[] args) {
		
		Integer arr[] = {3,2,11,4,6,7};
		Arrays.sort(arr);
		
		List<Integer> number = new ArrayList<Integer>();
		for (Integer secondLargest : arr) {
			number.add(secondLargest);
		}

		Integer result = number.get(number.size()-2);
		System.out.println("The second largest number in the array is: " + result);
		
	}

}
