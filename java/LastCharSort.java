import java.util.Arrays;
import java.util.Comparator;

public class LastCharSort {
/*    private static class comparelengths implements Comparator<String>{

@Override
public int compare(String arg0, String arg1) {
// TODO Auto-generated method stub
return (arg0.length()- arg1.length());
}
}
*/
	private static class LastCharCompare implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			/*if (s1.length () == 0 && s2.length () > 0)
				return 1;

			if (s2.length () == 0 && s1.length () > 0)
				return -1;

			if (s2.length () == 0 && s1.length () == 0)
				return 0;*/

			return (s1.charAt (s1.length () - 1) - s2.charAt (0));
		}
	}

	public static void main(String args[]){
		String arr[] = {"abd", "abc", "def" , "cat", "feq", "tge"};
		Arrays.sort(arr);

		char lastChar = arr[0].charAt(arr[0].length () - 1);
		System.out.println(arr[0] + " -- ");

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].charAt (0) == lastChar) {
				System.out.println(arr[i]);
				lastChar = arr[i].charAt(arr[i].length () - 1);
			} else {
				continue;
			}
		}

		System.out.println("-----");

// sorts according to length of string
/*Arrays.sort(arr, new comparelengths());
for(int j=0;j<arr.length;j++){
System.out.println(arr[j]);
}*/

//sorts lexicographically according to last letter
		Arrays.sort (arr, new LastCharCompare ());
		for (String str : arr){
			System.out.println(str);
		}
	}
}