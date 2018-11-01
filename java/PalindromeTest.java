import java.util.Scanner;

public class PalindromeTest {

    public static String reverse (String inputStr) {
        int length = inputStr.length();
        StringBuilder sb = new StringBuilder ();

        for (int i = length - 1; i >= 0; i--) {
            sb.append (inputStr.charAt (i));
        }

        return sb.toString();
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println ("Enter a value to check whether it is a Palindrome or not");
        String inputStr = scanner.next ();

        if (inputStr != null && !"".equals (inputStr)) {
        	if (inputStr.equals (PalindromeTest.reverse (inputStr))) {
        		System.out.println ("The entered value " + inputStr + " is a Palindrome");
        	} else {
        		System.out.println ("The entered value " + inputStr + " is NOT a Palindrome");
        	}
        }
    }
}
