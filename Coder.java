/**
 * Class that encrypts and decrypts a text by rotating every letter by n places.
 * n is the number of letters in each word.
 * 
 * @author Oskar Kraak
 */

public abstract class Coder {

	private static char[] lowercaseLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' },
			uppercaseLetters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
					'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * Method that encodes a text.
	 * 
	 * @param text is the text to encrypt.
	 * @return A String containing the encrypted text.
	 */
	public static String encode(String text) {
		// Split
		String[][] words = splitText(text);

		// Rotate
		for (int i = 0; i < words.length; i++) {
			for (int k = 0; k < words[i].length; k++) {
				// Count the number of letters in the current "word".
				// This is necessary in order to leave out any non-letter characters.
				int rot = 0;
				for (char a : words[i][k].toCharArray()) {
					for (char b : lowercaseLetters) {
						if (a == b)
							rot++;
					}
					for (char b : uppercaseLetters) {
						if (a == b)
							rot++;
					}
				}

				// Rotate words
				words[i][k] = rotate(words[i][k], rot);
			}
		}

		// Assemble
		String encoded = assembleText(words);

		return encoded;
	}

	/**
	 * Method that decodes a text.
	 * 
	 * @param text is an encrypted text.
	 * @return A String containing the decrypted text.
	 */
	public static String decode(String text) {
		// Split
		String[][] words = splitText(text);

		// Rotate back
		for (int i = 0; i < words.length; i++) {
			for (int k = 0; k < words[i].length; k++) {
				// Count the number of letters in the current "word".
				// This is necessary in order to leave out any non-letter characters.
				int rot = 0;
				for (char a : words[i][k].toCharArray()) {
					for (char b : lowercaseLetters) {
						if (a == b)
							rot++;
					}
					for (char b : uppercaseLetters) {
						if (a == b)
							rot++;
					}
				}

				// Rotate words
				words[i][k] = rotate(words[i][k], -rot);
			}
		}

		// Assemble
		String decoded = assembleText(words);

		return decoded;
	}

	/**
	 * Method that rotates all letters of the English alphabet in a text.
	 * 
	 * @param text is the text of which the letters should be substituted.
	 * @param rot  specifies how far each letter should be rotated. For example: 1
	 *             will rotate from A to B. It will also take negative numbers.
	 * @return A String with all letters of the given text substituted.
	 */
	public static String rotate(String text, int rot) {
		// Convert text to char array
		char[] characters = text.toCharArray();

		// Substitute (rotate) letters
		for (int i = 0; i < characters.length; i++) {
			for (int k = 0; k < lowercaseLetters.length; k++) {
				// Make sure the new index "k + rot" is not out of bounds
				int newIndex = k + rot;
				while (newIndex > lowercaseLetters.length - 1)
					newIndex -= lowercaseLetters.length;
				while (newIndex < 0)
					newIndex += lowercaseLetters.length;

				// Check if the current char is a lowercase letter
				if (lowercaseLetters[k] == characters[i]) {
					characters[i] = lowercaseLetters[newIndex];
					break;
				}

				// Check if the current char is a uppercase letter
				if (uppercaseLetters[k] == characters[i]) {
					characters[i] = uppercaseLetters[newIndex];
					break;
				}

			}
		}

		// Save substituted chars as String
		String result = "";
		for (char c : characters)
			result += c;

		return result;
	}

	private static String[][] splitText(String text) {
		// Split the text into lines
		String[] lines = text.split("\n");

		// Split the lines into words
		String[][] words = new String[lines.length][];
		for (int i = 0; i < lines.length; i++)
			words[i] = lines[i].split(" ");

		return words;
	}

	private static String assembleText(String[][] words) {
		// Assemble the words to lines
		String[] lines = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			lines[i] = "";
			for (String word : words[i])
				lines[i] += word + " ";
			// Remove the last space that was added
			if (lines[i].length() > 0)
				lines[i] = lines[i].substring(0, lines[i].length() - 1);
		}

		// Assemble the lines to a text
		String text = "";
		for (String line : lines)
			text += line + "\n";

		return text;
	}

}
