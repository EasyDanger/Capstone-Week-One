package capstoneweek1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapStoneWeekOne {

	// Dealing with multiple methods, it's safest to declare most of these variables
	// here.
	// It became necessary to have a version of the phrase before and after the
	// translation was done in order to recreate formatting. variableWITHCAPS became
	// those variables. Consistent naming helped keep track.
	// Takes original input to be translated.
	static String origWORD;
	// Formats text into lowercase for ease of translation.
	static String origWord;
	// These became arrays to allow for multiple broken up strings from the original
	// input. One is for passing to maintain formatting.
	static String[] passWORDArr;
	// This one is for passing to translator.
	static String[] passWordArr;
	// Returns as as unformatted text to go to formatter.
	static String transWordUnForm;
	// Returns to be printed.
	static String transWordForm;
	// Variables for loop counts.
	static int j;
	static int i;
	// Character to store punctuation marks.
	static char punc;
	// Scanner
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		// User Prompts.
		System.out.println("Hi, kids. We're going to translate your text into Pig Latin! (Enter to continue) \n");
		read.nextLine();
		System.out.println(
				"Just enter a word, a phrase, hell, even a sentence, and we'll get that translated for you right in a jiffy! (Enter)\n");

		// Takes in the user word or sentence.
		origWORD = read.nextLine();
		
		// Converts to lowercase for the sake of translator method.
		origWord = (origWORD.toLowerCase());
		// Breaks the potential sentence into two arrays. One for formating and one for
		// translating.
		passWORDArr = origWORD.split("\\s+");
		passWordArr = origWord.split("\\s+");


		// Must be before the loop, or will print each time.
		System.out.println("\n\nTry saying: \n\n");
		// Loop for translating sentences. Created after the later loops for counting
		// and tracking specific letters, hence 'j.'
		for (j = 0; j <= passWordArr.length - 1; j++) {
			// Calls translator method on each word in array in sequence.
			pigLatTrans(passWordArr[j]);
			// Passes original format word to formatter to aid formating.
			cases(passWORDArr[j]);

			// Final, translated output.
			System.out.print(transWordForm + punc + " ");

		}
		System.out.println("\n\nWould you like to try again? (y/n)");
		String cont = read.nextLine();
		if (cont.equals("y")) {
//read.nextLine();
			main(null);
		} else {
			read.close();
			System.out.println("Thanks for trying us out!");
		}
	}

	// Translation method.
	private static String pigLatTrans(String passWordArr) {
		// Pattern teaches what punctuation is.
		Pattern pat = Pattern.compile("\\p{Punct}");
		// Matcher finds punctuation.
		Matcher m = pat.matcher(passWordArr);

		// If punctuation is found, statement removes punctuation from word and variable
		// holds it until word is printed, so it's not in the way for formatting.
		if (m.find()) {
			punc = passWordArr.charAt(passWordArr.length() - 1);
			passWordArr = passWordArr.substring(0, passWordArr.length() - 1);
		} else {
			punc = 0;
		}

		// Statement checks if word starts with a vowel.
		if ((passWordArr.charAt(0) == 'a') || (passWordArr.charAt(0) == 'e') || (passWordArr.charAt(0) == 'i')
				|| (passWordArr.charAt(0) == 'o') || (passWordArr.charAt(0) == 'u')) {
			transWordUnForm = passWordArr + "way";
		}
		// If no vowel, statement finds first vowel to move everything before it to end.
		else {
			for (i = 1; ((passWordArr.charAt(i) != 'a') && (passWordArr.charAt(i) != 'e')
					&& (passWordArr.charAt(i) != 'i') && (passWordArr.charAt(i) != 'o')
					&& (passWordArr.charAt(i) != 'u') && (passWordArr.charAt(i) != 'y'))
					&& i < passWordArr.length(); i++) {
			}
			// Variable 'i' stores index of first vowel, which is also where the necessary
			// clip to the string is. Variables named after members of the rap group
			// "Clipse." They are also referenced any time I open Eclipse, when I mumble
			// "flows on top of flows" under my breath.
			String pushaT = passWordArr.substring(0, i);
			String noMalice = passWordArr.substring(i);
			// Stores translated, unformatted word.
			transWordUnForm = noMalice + pushaT + "ay";
		}
		return transWordUnForm;
	}

	// Formatting method.
	private static String cases(String origWord) {
		// Counts how many letters are upper or lower case, to verify full upper or full
		// lowercase.
		int howMany = 0;
		// Finds punctuation again.
		Pattern pat = Pattern.compile("\\p{Punct}");
		Matcher m = pat.matcher(origWord);
		if (m.find()) {
			punc = origWord.charAt(origWord.length() - 1);
			origWord = origWord.substring(0, origWord.length() - 1);
		}
		// Returns words to uppercase if they started there.
		if ((Character.isUpperCase(origWord.charAt(0))) && (Character.isUpperCase(origWord.charAt(1)))) {
			for (i = 0; i <= origWord.length() - 1; i++) {
				if (Character.isUpperCase(origWord.charAt(i))) {
					howMany += 1;
				}
			}
			if (howMany == origWord.length()) {
				transWordForm = transWordUnForm.toUpperCase();
			} else {
				noTricks(passWordArr[j]);
			}
			// Returns words to lowercase if started there. Not necessary, strictly
			// speaking, but nice for consitency's sake.
		} else if (Character.isLowerCase(origWord.charAt(0))) {
			for (i = 0; i <= origWord.length() - 1; i++) {
				if (Character.isLowerCase(origWord.charAt(i))) {
					howMany += 1;
				}
			}
			if (howMany == origWord.length()) {
				transWordForm = transWordUnForm.toLowerCase();
			} else {
				noTricks(passWordArr[j]);
			}
			// Returns initial caps words to initial caps.
		} else if ((Character.isUpperCase(origWord.charAt(0))) && (Character.isLowerCase(origWord.charAt(1)))) {
			for (i = 1; i <= origWord.length() - 1; i++) {
				if (Character.isLowerCase(origWord.charAt(i))) {
					howMany += 1;
				}
			}
			if (howMany == (origWord.length()) - 1) {
				transWordForm = transWordUnForm.substring(0, 1).toUpperCase() + transWordUnForm.substring(1);
			} else {
				noTricks(transWordUnForm);
			}
			// Sends words we can't figure out to the failure method.
		} else {
			noTricks(transWordUnForm);
		}
		return transWordForm;
	}

	// Method simply returns unformatted text if we can't figure it out. Should
	// catch contractions or strange capitalization.
	private static void noTricks(String transWordUnForm) {
		System.out.println(
				"\n\nYou gave me strangely formatted text in there. So, you're getting getting it back in in lowercase. Hope you're happy. (Enter)\n\n");
		read.nextLine();
		transWordForm = transWordUnForm;

	}
}
