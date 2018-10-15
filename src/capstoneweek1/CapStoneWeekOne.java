package capstoneweek1;

import java.util.Scanner;

public class CapStoneWeekOne {
	
	//Dealing with multiple methods, it's safest to declare most of these variables here.
	static String origWORD;
	static String origWord;
	static String[] passWORDArr;
	static String[] passWordArr;
	static String transWordUnForm;
	static String transWordForm;
	static int j;
	static int i;
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Hi, kids. We're going to translate your text into Pig Latin! (Enter to continue) \n");
		read.nextLine();
		System.out.println("Just enter a word, a phrase, hell, even a sentence, and we'll get that translated for you right in a jiffy! (Enter)\n");
		origWORD = read.nextLine();
//		for (i = 0; origWord.equals("\n"); i++) {
//			System.out.println("Try again.");
//			origWord = read.nextLine();
//		}
//		if (origWORD.charAt(origWORD.length()) == '.' ) {
			
	//	}
		
		origWord = (origWORD.toLowerCase());
		passWORDArr = origWORD.split("\\s+");
		passWordArr = origWord.split("\\s+");
//		System.out.println(origWord);
//		System.out.println(passWordArr);
		for (j = 0; j <= passWordArr.length -1; j++) {
			pigLatTrans(passWordArr[j]);
		
		
//		pigLatTrans(passWordArr);
		cases(passWORDArr[j]);
		
		System.out.print(transWordForm + " ");
		}}
	private static String pigLatTrans(String passWordArr) {		
		if ((passWordArr.charAt(0) == 'a') || (passWordArr.charAt(0) == 'e') || (passWordArr.charAt(0) == 'i') || (passWordArr.charAt(0) == 'o') || (passWordArr.charAt(0) == 'u')) {
			transWordUnForm = passWordArr + "way";
		}
		else {
			for (i = 1; ((passWordArr.charAt(i) != 'a') && (passWordArr.charAt(i) != 'e') && (passWordArr.charAt(i) != 'i') && (passWordArr.charAt(i) != 'o') && (passWordArr.charAt(i) != 'u') && (passWordArr.charAt(i) != 'y')) && i < passWordArr.length(); i++) {
			}
			String pushaT = passWordArr.substring(0, i);
			String noMalice = passWordArr.substring(i);
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
					noTricks(passWordArr[j]);
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
					noTricks(passWordArr[j]);
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
		System.out.println("\n\nYou gave me strangely formatted text in there. So, you're getting getting it back in in lowercase. Hope you're happy. (Enter)\n\n");
		read.nextLine();
		transWordForm = transWordUnForm;
		
	}
}
