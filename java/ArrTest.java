import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class ArrTest {
	private static List<Integer> getIntegerListFromIntArray (int[] array) {
		List<Integer> intList = new ArrayList<> ();
		for (int i = 0; i < array.length; i++) {
			intList.add (array [i]);
		}

		return intList;
	}

	public static void printMinCommon (int[] arr1, int[] arr2) {
		List<Integer> commonArrList = getIntegerListFromIntArray (arr1);
		List<Integer> secondArrList = getIntegerListFromIntArray (arr2);

		System.out.println ("First: " + commonArrList);
		System.out.println ("Second: " + secondArrList);

		//commonArrList.removeAll (secondArrList);
		commonArrList.addAll (secondArrList);
		//Collections.sort (commonArrList);
		System.out.println ("Merged: " + commonArrList);

		/*if (commonArrList.size () > 0) {
			System.out.println ("Min element: " + commonArrList.get (0));
		}*/

		TreeSet<Integer> s1 = new TreeSet<> (commonArrList);
		System.out.println (s1.first ());

	}

	public static void main (String[] args) {
		int[] arr1 = {8, 2, 1, 7, 10};
		int[] arr2 = {8, 4, 6, 17, 1, 99};

		printMinCommon (arr1, arr2);
	}
}


