import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
To summarize, I have come up with following steps for converting the input integer to Roman numeral(s)
and generating the barcode from the Roman numeral(s).

Step 1: Pre-populate a map datastructure with mappings between most commonly occuring numbers and their
equivalent Roman numeral.

Step 2: Pre-populate a map datastructure with mappings between Roman numeral(s) and the number of barcode
characters to display on the screen.

Step 3: Extract and store the individual numbers from the input string, based on their numerical position,
get their equivalent Roman numeral from the map created in Step 1, and store them in a List.

Step 4: For each item in the List, generate the barcode characters based on the map created in Step 2.
*/

/**
* @author Ishwarachandra Gowtham (ic.gowtham@gmail.com)
*/
public class RomanNumeralBarcodeGenerator {
	/* The pipe symbol, "|", is being used as the barcode character */
	private final static String BARCODE_CHAR = "|";

	private final static String SPACER_CHAR = "   ";

	/* Lookup map for holding the mappings between a number and it's equivalent Roman numeral. */
	private static Map<String, String> s_numStrToRomanNumeralMap = new HashMap<> ();

	/* Lookup map for holding the mappings between a Roman numeral and
	the number of barcode characters (thickness) to display on the screen. */
	private static Map<String, Integer> s_romanNumeralToLineWidthMap = new HashMap<> ();

	/* List for holding the Roman numeral(s) corresponding to the individual numeric components
	from the input string */
	private static List<String> s_romanNumeralsList = new ArrayList<> ();

	static {
		/* We store a blank character for the strings "0", "00" and "000" respectively
		for avoiding the value 'null' getting displayed on the screen. */
		s_numStrToRomanNumeralMap.put ("0",    "");
		s_numStrToRomanNumeralMap.put ("00",   "");
		s_numStrToRomanNumeralMap.put ("000",  "");
		s_numStrToRomanNumeralMap.put ("1",    "I");
		s_numStrToRomanNumeralMap.put ("2",    "II");
		s_numStrToRomanNumeralMap.put ("3",    "III");
		s_numStrToRomanNumeralMap.put ("4",    "IV");
		s_numStrToRomanNumeralMap.put ("5",    "V");
		s_numStrToRomanNumeralMap.put ("6",    "VI");
		s_numStrToRomanNumeralMap.put ("7",    "VII");
		s_numStrToRomanNumeralMap.put ("8",    "VIII");
		s_numStrToRomanNumeralMap.put ("9",    "IX");
		s_numStrToRomanNumeralMap.put ("10",   "X");
		s_numStrToRomanNumeralMap.put ("20",   "XX");
		s_numStrToRomanNumeralMap.put ("30",   "XXX");
		s_numStrToRomanNumeralMap.put ("40",   "XL");
		s_numStrToRomanNumeralMap.put ("50",   "L");
		s_numStrToRomanNumeralMap.put ("60",   "LX");
		s_numStrToRomanNumeralMap.put ("70",   "LXX");
		s_numStrToRomanNumeralMap.put ("80",   "LXXX");
		s_numStrToRomanNumeralMap.put ("90",   "XC");
		s_numStrToRomanNumeralMap.put ("100",  "C");
		s_numStrToRomanNumeralMap.put ("200",  "CC");
		s_numStrToRomanNumeralMap.put ("300",  "CCC");
		s_numStrToRomanNumeralMap.put ("400",  "CD");
		s_numStrToRomanNumeralMap.put ("500",  "D");
		s_numStrToRomanNumeralMap.put ("600",  "DC");
		s_numStrToRomanNumeralMap.put ("700",  "DCC");
		s_numStrToRomanNumeralMap.put ("800",  "DCCC");
		s_numStrToRomanNumeralMap.put ("900",  "CM");
		s_numStrToRomanNumeralMap.put ("1000", "M");
		s_numStrToRomanNumeralMap.put ("2000", "MM");
		s_numStrToRomanNumeralMap.put ("3000", "MMM");

		s_romanNumeralToLineWidthMap.put ("I", 1);
		s_romanNumeralToLineWidthMap.put ("V", 3);
		s_romanNumeralToLineWidthMap.put ("X", 5);
		s_romanNumeralToLineWidthMap.put ("L", 7);
		s_romanNumeralToLineWidthMap.put ("C", 9);
		s_romanNumeralToLineWidthMap.put ("D", 11);
		s_romanNumeralToLineWidthMap.put ("M", 13);
	}

	/**
	* This method populates the list containing individual numeric components from which we try and display the barcode.
	*
	* @param inputStr input integer value passed to the program as String
	*/
	public static void populateRomanNumerals (String inputStr) {
		int inputStrLength = inputStr.length ();
		StringBuilder sb = null;
		String romanLiteral = null;

		System.out.print ("Roman Numeral: ");
		/*
		This is for the straightforward cases where the input String is 1000, 500, 100, etc.
		*/
		if (s_numStrToRomanNumeralMap.containsKey (inputStr)) {
			romanLiteral = s_numStrToRomanNumeralMap.get (inputStr);
			s_romanNumeralsList.add (romanLiteral);
			System.out.println (romanLiteral);
		} else {
			/* The idea here is to create individual String for each number from the input based on their numerical position.
			For e.g., in case the input is 1971, then we generate the following individual strings:
			1000
			900
			70
			1
			This would help us to do a quick map lookup to get the corresponding Roman numeral and store them in the list.
			*/
			for (int i = 0; i < inputStrLength; i++) {
				sb = new StringBuilder ();
				sb.append (Character.toString (inputStr.charAt (i)));
				for (int j = i; j < inputStrLength - 1; j++) {
					sb.append ("0");
				}

				romanLiteral = s_numStrToRomanNumeralMap.get (sb.toString ());
				s_romanNumeralsList.add (romanLiteral);
				System.out.print (romanLiteral + " ");
			}

			System.out.println (" ");
		}
	}

	/**
	* This method displays the barcode on the screen for the elements in the list s_romanNumeralsList.
	* For each of the elements in the list s_romanNumeralsList, the number of barcode characters to display is queried
	* from the map s_romanNumeralToLineWidthMap
	*
	*/
	public static void displayBarcode () {
		System.out.println ("Barcode:");
		for (String rm : s_romanNumeralsList) {
			int rmLength = rm.length ();
			for (int i = 0; i < rmLength; i++) {
				int repeatFactor = s_romanNumeralToLineWidthMap.get (Character.toString (rm.charAt (i)));
				System.out.print (String.format (String.format ("%%0%dd", repeatFactor), 0).replace("0", BARCODE_CHAR)
								 + SPACER_CHAR);

				/* Single space separator between numerical components representing a single number */
				/*if (rmLength > 1) {
					System.out.print (" ");
				}*/
			}

			/* 3-space separator (for representing 3px) between barcodes */
			//System.out.print (SPACER_CHAR);
		}
	}

	public static void main (String[] args) {
		if (args.length < 1) {
			System.err.println ("Need to pass an integer argument");
			System.exit (1);
		}

		try {
			int inputNumber = Integer.parseInt (args[0]);

			if ((inputNumber <= 0 && inputNumber > 3999) ||
				("00".equals (args[0]) || "000".equals (args[0]) || "0000".equals (args[0])) ||
				(args[0] != null && args[0].length () > 4)) {
				System.err.println ("Please enter a number between 1 to 3999");
				System.exit (2);
			}
		} catch (NumberFormatException nfe) {
			System.err.println ("Please enter a valid number in the range 1 to 3999! " + nfe.getMessage ());
			System.exit (3);
		}

		String input = args[0];
		System.out.println ("Input: " + input);
		populateRomanNumerals (input);
		displayBarcode ();
	}
}