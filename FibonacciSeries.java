package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		
		System.out.println(a);
		System.out.println(b);	
		
		for (int i = 0; i <= 8; i++) {			
			int n = a + b;
			System.out.println(n);
			a = b;
			b = n;
			
			}
			
		}
		
	}


