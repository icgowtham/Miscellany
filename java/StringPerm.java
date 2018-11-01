import java.util.List;
import java.util.LinkedList;

public class StringPerm {
	public static List<String> permutations(String a) {
		List<String> result = new LinkedList<>();
		int len = a.length();
		if (len <= 1) {
			result.add(a);
		} else {
			for (int i = 0; i < len; i++){
				for (String it : permutations (a.substring(0, i) + a.substring (i + 1))){
					result.add (a.charAt (i) + it);
				}
			}
		}

		return result;
	}

	public static void main (String[] args) {
		String str = "1abA";
		/*List<String> result = permutations (str);

		for (String s : result) {
			System.out.println (s);
		}*/
		permuteString ("", str);
	}

	public static void permuteString (String beginningString, String endingString) {
		if (endingString.length () <= 1)
			System.out.println (beginningString + endingString);
		else
			for (int i = 0; i < endingString.length (); i++) {
				try {
					String newString = endingString.substring (0, i) + endingString.substring (i + 1);
					permuteString (beginningString + endingString.charAt (i), newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace ();
				}
			}
	}
}