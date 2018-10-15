package capstoneweek1;

import java.util.Scanner;

public class CapStoneWeekOne {
	
	//Dealing with multiple methods, it's safest to declare most of these variables here.
	static String origWord;
	static String passWord;
	static String transWordUnForm;
	static String transWordForm;
	static int i;
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Hi, kids. We're going to translate your text into Pig Latin! (Enter to continue) \n");
		read.nextLine();
		System.out.println("Just enter a word, a phrase, hell, even a sentence, and we'll get that translated for you right in a jiffy! (Enter)\n");
		origWord = read.next();
//		for (i = 0; origWord.equals("\n"); i++) {
//			System.out.println("Try again.");
//			origWord = read.nextLine();
//		}
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
		int howMany = 0;
		if ((Character.isUpperCase(origWord.charAt(0))) && (Character.isUpperCase(origWord.charAt(1)))) {
			for (i = 0; i <= origWord.length()-1; i++) {
				if (Character.isUpperCase(origWord.charAt(i))) {
					howMany += 1;
				}}
				if (howMany == origWord.length()) {
			transWordForm = transWordUnForm.toUpperCase();						
				} else {
					noTricks(passWord);
				}
		}
		else if (Character.isLowerCase(origWord.charAt(0))) {
			for (i = 0; i <= origWord.length()-1; i++) {
				if (Character.isLowerCase(origWord.charAt(i))) {
					howMany += 1;
				}}
				if (howMany == origWord.length()) {
			transWordForm = transWordUnForm.toLowerCase();						
				} else {
					noTricks(passWord);
				}
		}
		else if ((Character.isUpperCase(origWord.charAt(0))) && (Character.isLowerCase(origWord.charAt(1)))) {
			for (i = 1; i <= origWord.length()-1; i++) {
				if (Character.isLowerCase(origWord.charAt(i))) {
					howMany += 1;
				}}
				if (howMany == (origWord.length())-1) {
			transWordForm = transWordUnForm.substring(0, 1).toUpperCase() + transWordUnForm.substring(1);						
				} else {
					noTricks(transWordUnForm);
				}
		}
		else {
			noTricks(transWordUnForm);
		}
		return transWordForm;		
	}
	private static void noTricks(String transWordUnForm) {
		System.out.println("\n\nYou gave me strangely formatted test in there. So, you're getting getting it back in in lowercase. Hope you're happy. (Enter)\n\n");
		read.nextLine();
		transWordForm = transWordUnForm;
		
	}
}
