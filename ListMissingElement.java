package week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMissingElement {

	public static void main(String[] args) {
		
		
		Integer arr[] = {1,2,3,4,10,6,8};
		Arrays.sort(arr);
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(Integer missing : arr) {
			list.add(missing);
			//System.out.println(list);
		}
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) != i+1 ) {
				System.out.println("The missing element is: " + (i+1));
			}
		}
			

	}

}
