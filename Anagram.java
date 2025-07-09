package week3.day1;

import java.util.Arrays;

public class Anagram {
	
	public void logic() {
		String text1 = "stops";
		String text2 = "potss";
		if (text1.length() != text2.length()) {
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		}
		char[] text1_char = text1.toCharArray();
		for (int i = 0; i < text1_char.length; i++) {
			System.out.println(text1_char[i]);
		}
		char[] text2_char = text2.toCharArray();
		for (int j = 0; j < text2_char.length; j++) {
			System.out.println(text2_char[j]);
		}
		Arrays.sort(text1_char);
		System.out.println(text1_char);
		Arrays.sort(text2_char);
		System.out.println(text2_char);
		if (Arrays.equals(text1_char, text2_char)) {
			System.out.println("The given strings are Anagram");
		}
		else {
			System.out.println("The given strings are not an Anagram");
		}
		
	}
	
	

	public static void main(String[] args) {
		
		Anagram text = new Anagram();
		text.logic();

	}

}
