import java.util.Set;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MTest {
    public static void main(String[] args) {
        int arr1[] = {2, 0, -1, 12, 9};
        int arr2[] = {12, 9, 22, 11, 15};

        NavigableMap<Integer, Integer> mmap = new TreeMap<>();

        for (int i = 0; i < arr1.length; i++) {
            mmap.put(arr1[i], arr1[i]);
        }

        for (int j = 0; j < arr2.length; j++) {
            mmap.put(arr2[j], arr2[j]);
        }

		System.out.println (mmap.firstEntry ().getKey ());
    }
}