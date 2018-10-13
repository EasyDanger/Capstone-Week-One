package capstoneweek1;

import java.util.Scanner;

public class CapStoneWeekOne {
	static String origWord;
	static String passWord;
	static String transWordUnForm;
	static String transWordForm;
	static int i;
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Hi, kids. We're going to translate your text into Pig Latin! (Enter to continue) \n");
		read.nextLine();
		System.out.println("Just enter a word, a phrase, hell, even a sentence, and we'll get that translated for you right in a jiffy! (Enter)\n");
		origWord = read.nextLine();
		passWord = (origWord.toLowerCase());
		pigLatTrans(passWord);
		cases(origWord);
		
		System.out.println(transWordForm);
	}
	private static String pigLatTrans(String passWord) {		
		if ((passWord.charAt(0) == 'a') || (passWord.charAt(0) == 'e') || (passWord.charAt(0) == 'i') || (passWord.charAt(0) == 'o') || (passWord.charAt(0) == 'u')) {
			transWordUnForm = passWord + "way";
		}
		else {
			for (i = 1; ((passWord.charAt(i) != 'a') && (passWord.charAt(i) != 'e') && (passWord.charAt(i) != 'i') && (passWord.charAt(i) != 'o') && (passWord.charAt(i) != 'u') && (passWord.charAt(i) != 'y')); i++) {
			}
			String pushaT = passWord.substring(0, i);
			String noMalice = passWord.substring(i);
			transWordUnForm = noMalice + pushaT + "ay";
		}
		return transWordUnForm;
	}
	private static String cases(String origWord) {
		if ((Character.isUpperCase(origWord.charAt(0))) && (Character.isUpperCase(origWord.charAt(1)))) {
			transWordForm = transWordUnForm.toUpperCase();
		}
		return transWordForm;		
	}
}
