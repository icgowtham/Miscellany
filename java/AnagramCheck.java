import java.io.*;
import java.util.Arrays;

public class AnagramCheck {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader (new InputStreamReader (System.in))) {
			String[] words = br.readLine ().split (" ");

			if (isAnagram (words[0], words[1])) {
				System.out.println (words[0] + " and " + words[1] + " are anagrams!");
			} else {
				System.out.println (words[0] + " and " + words[1] + " are NOT anagrams.");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace ();
		}
	}

	public static boolean isAnagram (String word, String anagram) {
		char[] charFromWord = word.replaceAll("[\\s]", "").toCharArray ();
		char[] charFromAnagram = anagram.replaceAll("[\\s]", "").toCharArray ();

		Arrays.sort (charFromWord);
		Arrays.sort (charFromAnagram);

		return Arrays.equals (charFromWord, charFromAnagram);
	}
}