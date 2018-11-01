import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class CountKComplementaryTest {
	public static void countKComplementaryPairs (int[] arr, int k) {
		int count = 0;
		Map<Integer, Integer> elementToNumOccurrenceMap = new HashMap<Integer, Integer>();

		System.out.print ("Array: [ ");
		for (int i : arr) {
			System.out.print (i + " ");
			if (elementToNumOccurrenceMap.get (i) == null) {
				elementToNumOccurrenceMap.put (i, 1);
			} else {
				elementToNumOccurrenceMap.put (i, elementToNumOccurrenceMap.get(i) + 1);
			}
		}
		System.out.println ("]");

		Set<Integer> keys = elementToNumOccurrenceMap.keySet ();
		for (Integer key : keys) {
			int difference = (k - key);

			if (elementToNumOccurrenceMap.containsKey (difference)) {
				count += elementToNumOccurrenceMap.get (key) * elementToNumOccurrenceMap.get (difference);
			}
		}

		System.out.println ("Count: " + count);
		elementToNumOccurrenceMap.clear ();
		elementToNumOccurrenceMap = null;
	}

	public static void main (String[] args) {
		System.out.print ("Enter the length of the array: ");
		Scanner scanner = new Scanner (System.in);
		int arrayLength = scanner.nextInt();
		int[] numbers = new int[arrayLength];

		System.out.println ("Enter elements of the array: ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}

		System.out.print("Enter a value for 'K': ");
		int k = scanner.nextInt();
		CountKComplementaryTest.countKComplementaryPairs (numbers, k);
	}
}
